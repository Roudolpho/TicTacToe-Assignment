package src;

/**
 * Write a description of class computer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Computer
{
    int row, col, team, o;
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
        for(int i = 0; i<=2;i++)
            for(int c = 0;c<=1;c++)
                if(asd[i][c] != 0 && asd[i][c+1] != 0)
                    for(int x=0;x<=2;x++)
                        if(asd[i][x] == 0){
                            row = i;
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
                    
                }
            }
        for(int x=0;x<=2;x++)
                        if(asd[x][c] == 0){
                            row = x;
                            col = c;
                        }
    }

    public int getX(){
        return row;
    }

    public int getY(){
        return col;
    }
}
