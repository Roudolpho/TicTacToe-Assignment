
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

		Player player1 = new Player(1, board);
		Player player2 = new Player(2, board);

		boolean thisdumbassvar = false;
		while (!thisdumbassvar) {
			System.out.println("Are you playing the computer \"yes\" or \"no\"");
			String str = scan.nextLine();
			if (str.toLowerCase().equals("yes")) {
				System.out.println("What level of the computer ar you playeing easy(1) or hard(2)");
				int lvl = scan.nextInt();
				player2 = new Computer(2, board, lvl);
				thisdumbassvar = !thisdumbassvar;
			} else if (str.toLowerCase().equals("no")) {
				player2 = new Player(2, board);
				thisdumbassvar = !thisdumbassvar;
			} else {
				System.out.println("You didn't give a correct response");
			}
		}
		boolean win = false;
		int winningTeam = 0;
		while (win == false) {// print board then do player1's turn then computer's or player2's
			player1.TakeTurn();
			if (board.checkVictory()) {
				win = true;
				winningTeam = 1;
			} else {
				player2.TakeTurn();
				if (board.checkVictory()) {
					win = true;
					winningTeam = 2;
				}
			}
		}
		System.out.println(board.toString());
		System.out.println("Team " + winningTeam + " won");
		scan.close();
	}
}
