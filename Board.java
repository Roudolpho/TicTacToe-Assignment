 


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
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
                return true;
        }
        for (int i = 0; i < board[0].length; i++) {// check vertical victory
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return true;
        }
        if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) || (board[0][2] == board[1][1] && board[0][0] == board[2][0]))
            return true;
        return false;
    }

    public void makeMove(int x, int y, int team) {
        if ((team == 1 || team == 2) && board[y][x] == 0)
            board[y][x] = team;
    }

    public void resetBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[y][x] = 0;
            }
        }
    }
    
    public String toString() {// This needs to display the board IDK how. Graphics? Special Print way?  
        return board.toString();
    }
}
