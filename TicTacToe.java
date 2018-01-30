
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

		if (str.toLowerCase().equals("yes")) {
			Player player = new Player(1);
			Computer comp = new Computer(2);
		}
		while (win == false) {

		}

	}
}
