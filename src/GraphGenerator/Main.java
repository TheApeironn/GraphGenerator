package GraphGenerator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


//		Graph graph = new Graph();
//		
//		for (int i = 0; i < 7; i++) {
//			graph.createNode();	
//		}
//		System.out.println("\n\n\n\n\n\n");
////		graph.createNode();
//		graph.getBoard().displayBoard();
//		
//		
		System.out.println("enter degree dequence:");
		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
		Graph graph = new Graph();
		
		int[] degreeSequence = {3, 3, 2, 2, 2, 2};
		graph.graphGenaratorWithSequence(degreeSequence);
		graph.getBoard().displayBoard();
		graph.printGraph();

		Node[] nodes = graph.getNodes();
		for (Node node : nodes) {
			System.out.println(node.getLetter() + " -> " + node.getDegree());
		}
		
		
		

//		String[] degrees = input.split(",");
//		int[] degreeSequence = new int[degrees.length];
//
//		try {
//			for (int i = 0; i < degrees.length; i++) {
//				degreeSequence[i] = Integer.parseInt(degrees[i].trim());
//			}
//
//			graph.isGraphical(degreeSequence);
//		} catch (NumberFormatException e) {
//			System.out.println("Geçersiz giriş! Sadece sayılar girin.");
//		}
//		
	}

}
