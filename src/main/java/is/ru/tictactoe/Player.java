package is.ru.tictactoe;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class Player {
    protected static In in = new In();
    protected static Out out = new Out();
    
    private int wins;
    
    public Player(){
	wins = 0;
    }
    
    public void setWins(int new_win){
	wins = new_win;
    }
    
    public int getWins(){
	return wins;
    }
    
    public Point nextMove(){ return null; } //function for @Override
    
}
