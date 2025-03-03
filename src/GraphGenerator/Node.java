package GraphGenerator;

public class Node {
	private char letter;
	private Position position;
	private int degree;
	private Node[] adjacentList = new Node[0];

	public Node() {
	}
	
	public Node(char letter, Position position, int degree, Node[] adjacentList) {
		this.letter = letter;
		this.position = position;
		this.degree = degree;
		this.adjacentList = adjacentList;
	}
	//deneme
	public void addNeighbor(Node neighbor) {
		// if its list is empty
		if (adjacentList.length == 0) {
	        adjacentList = new Node[1];
	        adjacentList[0] = neighbor;
	    } else {// if not empty
	    	//if its already exist in list
	    	for (Node node : adjacentList) {
	            if (node == neighbor) {
	                return;
	            }
	        }
	        Node[] newAdjacentList = new Node[adjacentList.length + 1];
	        for (int i = 0; i < adjacentList.length; i++) {
				newAdjacentList[i] = adjacentList[i];
			}
	        newAdjacentList[adjacentList.length] = neighbor;
	        adjacentList = newAdjacentList;
	    }
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public Node[] getadjacentList() {
		return adjacentList;
	}
	public void setadjacentList(Node[] adjacentList) {
		this.adjacentList = adjacentList;
	}


}
