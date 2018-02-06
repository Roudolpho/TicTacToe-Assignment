
/**
 * This is the class that is the automated opponent
 * It Extends the player class
 *
 * @author Chris Phan
 * @version 2/6/18
 */
public class Computer extends Player {
    int row, col, team, o, spot, l, v;

    public Computer(int t, Board board1, int level) {
        team = t;
        if (t == 1)
            teamstr = "one";
        if (t == 2)
            teamstr = "two";
        board = board1;
        l = level;
        comp = true;
    }

    @Override
    public void TakeTurn() {
        // this should check for if computer is set to easy or hard and then takes a
        // turn.
        System.out.println(board.toString());
        System.out.println("Computer is taking its turn...");
        switch (l) {
            case 1:
            getSpaceEasy();
            break;
            case 2:
            getSpaceHard();
            break;
        }
        board.rotateBoard();
    }

    public void getSpaceEasy() { // I don't think that you need to call the board each time because in
        // board.makemove it uses the board itself.
        do {
            row = (int) (3 * Math.random());
            col = (int) (3 * Math.random());
        } while (board.makeMove(row, col, team) == false); // board.makemove() now returns a boolean if it makes a move
        // for you so you can use board.makemove to both check if a
        // move is possible and make the move at the same time.
    }

    public void getSpaceHard() {
        row = -1;
        col = -1;
        checkRows();
        if (row  == -1) {
            checkColumns();
        }
        if (row  == -1) {
            checkDiagonals();
        }
        if (row  == -1) {
            checkDiagonals2();
        }
        if(row  == -1){
            getSpaceEasy();
        }
    }

    /* should check for any possible crosses through columns */
    public void checkColumns() {
        for (int i = 0; i <= 2; i++){
            o = 0;
            spot = -1;
            for (int c = 0; c <= 2; c++) {
                if (board.getBoard()[i][c] == 1) {
                    o += 1;
                }else if (board.getBoard()[i][c] == 0)
                    spot = c;
                if (o == 2 && spot != -1) {
                    row = i;
                    col = spot;
                    c = 3;
                    i = 3;
                    board.makeMove(col, row, team);
                }
            }
        }
    }

    /* should check for any possible crosses through rows */
    public void checkRows() {
        for (int c = 0; c <= 2; c++){
            o = 0;
            spot = -1;      
            for (int i = 0; i <= 2; i++) {
                if (board.getBoard()[i][c] == 1 ) {
                    o += 1;
                }else if (board.getBoard()[i][c] == 0)
                    spot = i;
                if (o == 2 && spot != -1) {
                    row = spot;
                    col = c;
                    i = 3;
                    c = 3;
                    board.makeMove(col, row, team);
                }
            }         
        }

    }
    //
    public void checkDiagonals() {
        o = 0;
        spot = -1;
        for (int i = 2; i >= 0; i--) {
            if (board.getBoard()[i][i] == 1) {
                o += 1;
            }else if (board.getBoard()[i][i] == 0){
                spot = i;
            }
            if (o == 2 && spot != -1) {
                row = spot;
                col = spot;
                board.makeMove(col, row, team);
            }
        }
    }

    public void checkDiagonals2() {
        o = 0;
        spot = -1;
        for (int i = 2; i >= 0; i--) {
            int c = 0;
            switch(i)
            {
                case 0: c = 2;break;
                case 1: c = 1;break;
                case 2: c = 0;break;
            }
            if (board.getBoard()[i][c] == 1) {
                o += 1;
            }else if (board.getBoard()[i][c] == 0)
                spot = i;
            if (o == 2 && spot != -1) {
                row = spot;
                switch(spot)
                {
                    case 0: col = 2;break;
                    case 1: col = 1;break;
                    case 2: col = 0;break;
                }
                board.makeMove(col, row, team);
            }
        }
    }
}
