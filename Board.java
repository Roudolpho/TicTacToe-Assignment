
/**
 * Board
 *
 * @author Ryan Druffel
 * @version 0.0.0.1
 */
public class Board {
	private int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	/*
	 * 0-Empty space 1-Represents X 2-Represents O
	 */
	Board() {

	}

	public int[][] getBoard() { // Method so that the main method may retrieve the state of the board
		return board;
	}

	public boolean checkVictory() {
		for (int i = 0; i < board.length; i++) {// check horizontal victory
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != 0) {
				// System.out.println("1");
				return true;
			}
		}
		for (int i = 0; i < board[0].length; i++) {// check vertical victory
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
				// System.out.println("2");
				return true;
			}
		}
		if (((board[0][0] == board[1][1] && board[0][0] == board[2][2])
				|| (board[0][2] == board[1][1] && board[0][2] == board[2][0])) && board[1][1] != 0) {
			// System.out.println("3");
			return true;
		}
		return false;
	}

	public boolean makeMove(int x, int y, int team) {
		if (x <= 2 && x >= 0 && y <= 2 && y >= 0) {
			if (x == -1 || y == -1)
				return false;
			if ((team == 1 || team == 2) && board[y][x] == 0) {
				board[y][x] = team;
				return true;
			}
		}
		return false;
	}

	public boolean checkMove(int x, int y) {
		if (board[y][x] == 0)
			return true;
		return false;
	}

	public int getSpace(int x, int y) {
		return board[y][x];
	}

	public void resetBoard() {// resets the board
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				board[y][x] = 0;
			}
		}
	}

	public void rotateBoard() {
		int[][] temp = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i][j] = board[i][j];
			}
		}
		// System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[j][2 - i] = temp[i][j];
			}
		}
	}

	public void scramble() {
		int[][] temp = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i][j] = board[(int) (3 * Math.random())][(int) (3 * Math.random())];
			}
		}
		board = temp;
	}

	public String toString() {// This needs to display the board IDK how. Graphics? Special Print way?
		char[][] board1 = new char[3][3];

		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[j].length; i++) {
				if (board[i][j] == 0) {
					board1[i][j] = ' ';
				} else if (board[i][j] == 1) {
					board1[i][j] = 'X';
				} else if (board[i][j] == 2) {
					board1[i][j] = 'O';
				}

			}
		}
		String temp = "\t[" + board1[0][0] + "]\t[" + board1[0][1] + "]\t[" + board1[0][2] + "]\t\n\t[" + board1[1][0] + "]\t["
				+ board1[1][1] + "]\t[" + board1[1][2] + "]\t\n\t[" + board1[2][0] + "]\t[" + board1[2][1] + "]\t["
				+ board1[2][2] + "]\n";
		return temp;
	}
}
