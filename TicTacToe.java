 


/**
 * TicTacToe AP Computer Science A Assignment
 *
 * @author Ryan Druffel, Stephen Armstrong, Chris Pham
 * @version 0.0.0.1
 */
import java.util.*;

public class TicTacToe {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		Board board = new Board();
		
		System.out.println("Are you playing the computer \"yes\" or \"no\"");
		String str = scan.nextLine();
		
		Player player1 = new Player(1, board);
		
		if (str.toLowerCase().equals("yes")) {
			Computer comp = new Computer(2);
			int plyrs = 1;
		} else {
			Player player2 = new Player(2, board);
			int plyrs = 2;
		}
		boolean win;
		int winningTeam;
		while (win == false) {// print board then do player1's turn then computer's or player2's
			
			if(plyrs == 1) {
				player1.TakeTurn();
				if(board.checkVictory()) {
					win = true;
					winningTeam = 1;
				}
				comp.takeTurn();
				if(board.checkVictory()) {
					win = true;
					winningTeam = 2;
				}
			}
			else {
				player1.TakeTurn();
				if(board.checkVictory()) {
					win = true;
					winningTeam = 1;
				}
				player2.TakeTurn();
				if(board.checkVictory()) {
					win = true;
					winningTeam = 2;
				}
			}
		}
		
		
		
		
		
		
		
	}
}
