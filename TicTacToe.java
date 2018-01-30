
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

		System.out.println("Are you playing the computer \"yes\" or \"no\"");
		String str = scan.nextLine();

		Player player1 = new Player(1);
		
		if (str.toLowerCase().equals("yes")) {
			Computer comp = new Computer(2);
		} else {
			Player player2 = new Player(2);
		}
		
		while (win == false) {// print board then do player1's turn then computer's or player2's

		}

		
		
	}
}
