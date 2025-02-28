package GraphGenerator;

public class Main {

	public static void main(String[] args) {


		Graph graph = new Graph();
		
		for (int i = 0; i < 7; i++) {
			graph.createNode();	
		}
		System.out.println("\n\n\n\n\n\n");
//		graph.createNode();
		graph.getBoard().displayBoard();
	}

}
