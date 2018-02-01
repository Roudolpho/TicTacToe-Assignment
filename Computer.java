
/**
 * Write a description of class computer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Computer extends Player
{
    int row, col, team, o, spot, l;
    int[][] b = null;
    public Computer(int t, Board board1, int level){
        team = t;
        if (t == 1)
            teamstr = "one";
        if (t == 2)
            teamstr = "two";
        board = board1;
        b = board.getBoard();
        l = level;
    }

    @Override public void TakeTurn() {
        //this should check for if computer is set to easy or hard and then takes a turn. 
        switch(l)
        {
            case 1: getSpaceEasy();break;
            case 2: getSpaceHard();break;
        }
    }

    public void getSpaceEasy(){ //I don't think that you need to call the board each time because in board.makemove it uses the board itself. 
        do{
            row = (int)(2*Math.random());
            col = (int)(2*Math.random());    
        } while(board.makeMove(row,col,team) == false); //board.makemove() now returns a boolean if it makes a move for you so you can use board.makemove to both check if a move is possible and make the move at the same time. 
    }

    public void getSpaceHard(){
        checkRows();
        if(board.makeMove(row,col,team) == false)
            checkColumns();
        if(board.makeMove(row,col,team) == false)
            checkDiagonals();
        if(board.makeMove(row,col,team) == false)
            checkDiagonals2();
        while(board.makeMove(row,col,team) == false)
            getSpaceEasy();
    }

    /*should check for any possible crosses through columns*/
    public void checkColumns(){
        o = 0;
        spot = -1;
        for(int i = 0; i<=2;i++)
            for(int c = 0;c<=2;c++){
                if(b[i][c] == 1){
                    o += 1;
                } else if(b[i][c] == 0)
                    spot = c;
                if(o == 2 && spot != -1){
                    row = i;
                    col = spot;
                    c = 2;
                    i = 2;
                }
            }
    }

    /*should check for any possible crosses through rows*/
    public void checkRows(){
        o = 0;
        spot = -1;
        for(int c = 0; c<=2;c++)
            for(int i = 0;i<=2;i++){
                if(b[i][c] == 1){
                    o += 1;
                } else if(b[i][c] == 0)
                    spot = c;
                if(o == 2 && spot != -1){
                    row = spot;
                    col = c;
                    c = 2;
                    i = 2;
                }
            }
    }

    public void checkDiagonals(){
        o = 0;
        spot = -1;
        for(int c = 0; c<=2;c++)
            for(int i = 2;i>=0;i++){
                if(b[i][c] == 1){
                    o += 1;
                } else if(b[i][c] == 0)
                    spot = i;
                if(o == 2 && spot != -1){
                    row = i;
                    col = c;
                    c = 2;
                    i = 0;
                }
            }
    }

    public void checkDiagonals2(){
        o = 0;
        spot = -1;
        for(int i = 0; i<=2;i++)
            for(int c = 2;c>=0;c++){
                if(b[i][c] == 1){
                    o += 1;
                } else if(b[i][c] == 0)
                    spot = i;
                if(o == 2 && spot != -1){
                    row = i;
                    col = c;
                    c = 0;
                    i = 2;
                }
            }
    }

    public int getX(){
        return row;
    }

    public int getY(){
        return col;
    }
}
