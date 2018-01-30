
/**
 * This Class is the class that makes a player.
 *
 * @author Stephen, Ryan, and Chris Created Jan 29, 2018.
 */
import java.util.*;

public class Player {
	private int team = 0;
	private String teamstr = "";
	private Scanner scan = new Scanner(System.in);

	Player(int t) {// Sets up a player with a team.
		team = t;
		if (t == 1)
			teamstr = "one";
		if (t == 2)
			teamstr = "two";
	}

	public void TakeTurn() {// Takes a player's turn.
		System.out.println("It is player " + teamstr + "'s turn.");
		System.out.println("Please input board coordinates as integers, x first then y");
		int x = scan.nextInt() -1 ;
		
	}

}
