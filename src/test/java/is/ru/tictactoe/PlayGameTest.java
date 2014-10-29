package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayGameTest {

    @Test
    public void testInitialiazeTheBoard() {
	String[][] correctBoard = new String[3][3];
	
	correctBoard[0][0] = " ";
	correctBoard[0][1] = " ";	
	correctBoard[0][2] = " ";	

	correctBoard[1][0] = " ";	
	correctBoard[1][1] = " ";	
	correctBoard[1][2] = " ";	

	correctBoard[2][0] = " ";	
	correctBoard[2][1] = " ";	
	correctBoard[2][2] = " ";	
	
	String[][] testBoard = new String[3][3];
	testBoard = PlayGame.initialiazeTheBoard(testBoard);
	assertArrayEquals(correctBoard, testBoard);
    }

    @Test
    public void testCheckForInvalidValidMove(){
	
	String[][] testBoard = new String [3][3];
	testBoard = PlayGame.initialiazeTheBoard(testBoard);

	Point point = new Point(0, 0);
	boolean result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result); 
    }
       
   
}
