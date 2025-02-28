package GraphGenerator;

public class Board {

	char[][] board = new char[25][37];

	public Board() {

	}

	public Board(char[][] board) {
		this.board = board;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public void initializeBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i % 4 == 0 && j % 4 == 0) {
					board[i][j] = '.';
				} else
					board[i][j] = ' ';
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public void setAPosition(int x, int y, char chr) {
		if (x >= 0 && x < board[0].length && y >= 0 && y < board.length) {
			this.board[y][x] = chr;
		}
	}

}
