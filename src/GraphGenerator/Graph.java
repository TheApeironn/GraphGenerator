package GraphGenerator;

public class Graph {
	private  Board board = new Board();

	public Graph() {
		board.initializeBoard();
	}

	public void createNode() {
		Node newnode = new Node(0);
		
		
		int x = newnode.getPositions()[newnode.getCounter()-1].getX();
		int y = newnode.getPositions()[newnode.getCounter()-1].getY();
		board.setAPosition(x, y, newnode.getNodes()[newnode.getCounter()-1]);
		
//		board.getBoard()[newnode.getPositions()[newnode.getCounter()].getX()][newnode.getPositions()[newnode.getCounter()].getY()] = newnode.getNodes()[newnode.getCounter()];
		
//		board.getBoard()[newnode.getPositions()[i].getX()][newnode.getPositions()[i].getY()] = newnode.getNodes()[i];


	}


	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
