package GraphGenerator;

import java.util.Random;

public class Node {
	private static char[] nodeLetters = new char[7];
	private static Position[] positions = new Position[7];
	private static int counter = 0;
	

	private int degree;

	public Node(int degree) {
		this.degree = degree;
		this.nodeLetters[counter] = (char) (counter + 65);
		Position position = new Position();
		int x = 0;
		int y = 0;
		
		Random random = new Random();
		
		do {
			x = random.nextInt(10);
			y = random.nextInt(7);

			position.setX(x * 4);
			position.setY(y * 4);

		} while (isFull(position));

		positions[counter] = position;

		counter++;
	}

	public static char[] getNodes() {
		return nodeLetters;
	}

	public static void setNodes(char[] nodeLetters) {
		Node.nodeLetters = nodeLetters;
	}

	public static Position[] getPositions() {
		return positions;
	}

	public static void setPositions(Position[] positions) {
		Node.positions = positions;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Node.counter = counter;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public boolean isFull(Position position) {

		for (int i = 0; i < counter; i++) {
			if (positions[i] != null && positions[i].getX() == position.getX()
					&& positions[i].getY() == position.getY()) {
				return true;
			}
		}
		return false;
	}

}
