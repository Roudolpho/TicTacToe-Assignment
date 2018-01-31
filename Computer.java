 

/**
 * Write a description of class computer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Computer extends Player
{
    int row, col, team, o, spot;
    public Computer(int t){
        team = t;
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
        if(row != -1 && col != -1)
            checkColumns(asd);

    }

    /*should check for any possible crosses though columns*/
    public void checkColumns(int[][] asd){
        o = 0;
        for(int i = 0; i<=2;i++)
            for(int c = 0;c<=2;c++){
                if(asd[i][c] == 1)
                    o += 1;
                if(o == 2){
                    o = i;
                    c = 2;
                    i = 2;
                }
            }
        for(int x=0;x<=2;x++)
            if(asd[o][x] == 0){
                row = o;
                col = x;
            }
    }

    /*should check for any possible crosses though rows*/
    public void checkRows(int[][] asd){
        o = 0;
        for(int c = 0; c<=2;c++)
            for(int i = 0;i<=2;i++){
                if(asd[i][c] == 1)
                    o += 1;
                if(o == 2){
                    o = c;
                    c = 2;
                    i = 2;
                }
            }
        for(int x=0;x<=2;x++)
            if(asd[x][o] == 0){
                row = x;
                col = o;
            }
    }
    
    public void checkDiagonals(int[][] asd){
        o = 0;
        spot = 0;
        for(int c = 0; c<=2;c++)
            for(int i = 2;i>=0;i++){
                if(asd[i][c] == 1){
                    o += 1;
                } else if(asd[i][c] == 0)
                if(o == 2){
                    
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
