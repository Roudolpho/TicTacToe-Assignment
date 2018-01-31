
/**
 * This Class is the class that makes a player.
 *
 * @author Stephen, Ryan, and Chris Created Jan 29, 2018.
 */
import java.util.*;

public class Player {
	public int team = 0;
	public String teamstr = "";
	private Scanner scan = new Scanner(System.in);
	public Board board = new Board();

	Player() {

	}

	Player(int t, Board board1) {// Sets up a player with a team.
		team = t;
		if (t == 1)
			teamstr = "one";
		if (t == 2)
			teamstr = "two";
		board = board1;
	}

	public void TakeTurn() {// Takes a player's turn.
		System.out.println("It is player " + teamstr + "'s turn.");
		System.out.println("Please input board coordinates as integers, x first then y");
		int x = scan.nextInt() - 1;
		int y = scan.nextInt() - 1;

		board.makeMove(x, y, team);
	}

}
