
/**
 * Write a description of class computer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Computer extends Player
{
    int row, col, team, o, spot;
    public Computer(int t, Board board1){
        team = t;
        if (t == 1)
			teamstr = "one";
		if (t == 2)
			teamstr = "two";
		board = board1;
    }

    public void getSpaceEasy(int[][] asd){
        row = -1;
        col = -1;
        do{
            row = (int)(3*Math.random());
            col = (int)(3*Math.random());    
        } while(asd[row][col]!=0);
    }

    public void getSpaceHard(int[][] asd){
        row = -1;
        col = -1;
        checkRows(asd);
        if(row == -1 && col == -1)
            checkColumns(asd);
        if(row == -1 && col == -1)
            checkDiagonals(asd);
        if(row == -1 && col == -1)
            checkDiagonals2(asd);
        if(row == -1 && col == -1)
            getSpaceEasy(asd);
        
    }

    /*should check for any possible crosses though columns*/
    public void checkColumns(int[][] asd){
        o = 0;
        spot = -1;
        for(int i = 0; i<=2;i++)
            for(int c = 0;c<=2;c++){
                if(asd[i][c] == 1){
                    o += 1;
                } else if(asd[i][c] == 0)
                    spot = c;
                if(o == 2 && spot != -1){
                    row = i;
                    col = spot;
                    c = 2;
                    i = 2;
                }
            }
    }

    /*should check for any possible crosses though rows*/
    public void checkRows(int[][] asd){
        o = 0;
        spot = -1;
        for(int c = 0; c<=2;c++)
            for(int i = 0;i<=2;i++){
                if(asd[i][c] == 1){
                    o += 1;
                } else if(asd[i][c] == 0)
                    spot = c;
                if(o == 2 && spot != -1){
                    row = spot;
                    col = c;
                    c = 2;
                    i = 2;
                }
            }
    }

    public void checkDiagonals(int[][] asd){
        o = 0;
        spot = -1;
        for(int c = 0; c<=2;c++)
            for(int i = 2;i>=0;i++){
                if(asd[i][c] == 1){
                    o += 1;
                } else if(asd[i][c] == 0)
                    spot = i;
                if(o == 2 && spot != -1){
                    row = i;
                    col = c;
                    c = 2;
                    i = 0;
                }
            }
    }
    
     public void checkDiagonals2(int[][] asd){
        o = 0;
        spot = -1;
        for(int i = 0; i<=2;i++)
            for(int c = 2;c>=0;c++){
                if(asd[i][c] == 1){
                    o += 1;
                } else if(asd[i][c] == 0)
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
