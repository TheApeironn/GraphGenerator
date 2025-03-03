package GraphGenerator;

import java.util.Random;

public class Graph {

	private Position[] positions;
	private Node[] nodes;
	private int counter = 0;
	private Board board = new Board();

	public Graph() {
		board.initializeBoard();
	}

	public void printGraph() {
		for (Node node : nodes) {
			System.out.print(node.getLetter() + " -> ");
			for (Node neighbor : node.getadjacentList()) {
				System.out.print(neighbor.getLetter() + " ");
			}
			System.out.println();
		}
	}

	public void graphGenaratorWithSequence(int[] degreeSequence) {
		// setting up the number of nodes
		int numberOfNodes = degreeSequence.length;
		this.nodes = new Node[numberOfNodes];
		this.positions = new Position[numberOfNodes];

		// creating nodes
		for (int i = 0; i < numberOfNodes; i++) {
			nodes[i] = createNode();
			nodes[i].setDegree(degreeSequence[i]);
		}

		// to store nodes in a temp array
		Node[] tempNodes = new Node[numberOfNodes];
		for (int i = 0; i < numberOfNodes; i++) {
			tempNodes[i] = new Node(nodes[i]);
		}

		while (true) {
			nodes = sortNodes(nodes);
			if (nodes[0].getDegree() == 0) {
				break;
			}

			Node currentNode = nodes[0];
			int currentNodeDegree = currentNode.getDegree();
			currentNode.setDegree(0);

			for (int i = 1; i <= currentNodeDegree; i++) {
				nodes[i].addNeighbor(currentNode);
				currentNode.addNeighbor(nodes[i]);
				nodes[i].setDegree(nodes[i].getDegree() - 1);
			}
		}
		 // Restore the original degrees
		 for (int i = 0; i < numberOfNodes; i++) {
			nodes[i].setDegree(tempNodes[i].getDegree());
		}

	}

	public boolean isGraphical(int[] degreeSequence) {
		int[] havelHakimiArray = sortArray(degreeSequence);
		boolean flag = true;
		int count = 0;

		do {
			int counter = 0;
			int maxNumber = havelHakimiArray[0];
			// cant be more adjacent than the given number of nodes
			if (maxNumber > havelHakimiArray.length - 1) {
				System.out
						.println("The given sequence does not provide a Graph according to the Havel-Hakimi Algorithm");
				return false;
			}

			// processing the havel hakimi algorithm
			for (int i = 0; i < maxNumber; i++) {
				havelHakimiArray[i] = havelHakimiArray[i + 1] - 1;
				counter = i;
			}
			havelHakimiArray[counter + 1] = 0;
			havelHakimiArray = sortArray(havelHakimiArray);

			// if an element of array is negative while applying the algorithm, that
			// sequence is not a graph
			for (int i = 0; i < havelHakimiArray.length; i++) {
				if (havelHakimiArray[i] < 0) {
					System.out.println(
							"The given sequence is does not provide a Graph according to the Havel-Hakimi Algorithm");
					return false;
				}
			}

			// after a certain iterating every element of array must be 0, so we can
			// understand that the sequence is a reliable graph
			if (count > 20) {
				for (int i = 0; i < havelHakimiArray.length; i++) {
					if (havelHakimiArray[i] != 0) {
						System.out.println(
								"The given sequence is does not provide a Graph according to the Havel-Hakimi Algorithm");
						return false;
					}
				}
				break;
			}

			count++;
		} while (flag);
		if (flag) {
			System.out.println("the given sequence provide a graph according to the havel hakimi");
		}
		return flag;
	}

	public Node createNode() {
		Node newNode = new Node();
		Position position = new Position();
		Random random = new Random();

		int x = 0;
		int y = 0;
		// creating random position on the table
		do {
			x = random.nextInt(10);
			y = random.nextInt(7);

			position.setX(x * 4);
			position.setY(y * 4);

		} while (isPositionFull(position));

		// saving newNode to the graph
		newNode.setLetter((char) (counter + 65));
		newNode.setPosition(position);
		nodes[counter] = newNode;
		positions[counter] = position;
		counter++;

		// saving its place to the board
		int a = newNode.getPosition().getX();
		int b = newNode.getPosition().getY();
		board.setAPosition(a, b, newNode.getLetter());

		return newNode;
	}

	public boolean isPositionFull(Position position) {
		// controlling that the new random position is full?
		for (int i = 0; i < counter + 1; i++) {
			// is full , cant be used
			// new position is compared with the previous positions
			if (positions[i] != null && positions[i].getX() == position.getX()
					&& positions[i].getY() == position.getY()) {
				return true;
			}
		}
		// position is empty so it can be used
		return false;
	}

	public int[] sortArray(int[] array) {
		int[] sortedArray = new int[array.length];
		int turnOfMax = 0;

		for (int j = 0; j < array.length; j++) {
			int maxNumber = Integer.MIN_VALUE;

			// the max number in the first array
			for (int i = 0; i < sortedArray.length; i++) {
				if (array[i] > maxNumber) {
					maxNumber = array[i];
					turnOfMax = i;
				}
			}
			// the max is made a small value to prevent it from being selected again
			array[turnOfMax] = Integer.MIN_VALUE;
			// in descending order maxs are ordered
			sortedArray[j] = maxNumber;
		}
		return sortedArray;
	}

	public Node[] sortNodes(Node[] array) {
		Node[] sortedArray = new Node[array.length];

		// Sıralama işlemi yapılmadan önce array'i kopyalayalım.
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = array[i];
		}

		for (int j = 0; j < sortedArray.length; j++) {
			int maxDegree = Integer.MIN_VALUE;
			int turnOfMax = 0;

			// Maksimum dereceli düğümü bulma
			for (int i = 0; i < array.length; i++) {
				if (array[i] != null && array[i].getDegree() > maxDegree) {
					maxDegree = array[i].getDegree();
					turnOfMax = i;
				}
			}

			// Maksimum dereceyi sıralanmış dizideki yerine koyuyoruz
			Node maxNode = array[turnOfMax];
			array[turnOfMax] = null; // Bu öğeyi 'silmiş' olduk
			sortedArray[j] = maxNode; // Sıralı dizinin doğru konumuna ekliyoruz
		}

		return sortedArray;
	}

	public Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	public Position[] getPositions() {
		return positions;
	}

	public void setPositions(Position[] positions) {
		this.positions = positions;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
