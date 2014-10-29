package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class PlayGameTest {

    private Random rand = new Random();

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
    public void testCheckForInvalidMove(){
	
	String[][] testBoard = new String [3][3];
	testBoard = PlayGame.initialiazeTheBoard(testBoard);
	
	testBoard[0][0] = "X";
	testBoard[0][2] = "X";
	testBoard[1][1] = "O";
	testBoard[1][2] = "O";
	testBoard[2][1] = "O";
	
	Point point = new Point(0, 0);
	boolean result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);
 
	point = new Point(0, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(0, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(1, 0);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(1, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);
	
	point = new Point(1, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(2, 0);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

	point = new Point(2, 1);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(true, result);

	point = new Point(2, 2);
	result = PlayGame.checkForInvalidMove(testBoard, point);
	assertEquals(false, result);

    }

    @Test //check if computer returns the random coordinates in correct range, that is between 0 =< x =< 2
    public void testGetApointFromComputerPlayer(){ 

	ComputerPlayer comp = new ComputerPlayer();	
	for(int i = 0; i < 20; i++){
	    Point ptn = PlayGame.getApointFromThePlayer(comp);
	    if(ptn.getX() > 3 || ptn.getY() > 3) fail();
	}
	
    }
    
    //testing the winning logic
    @Test
    public void testVictoryOnInvertedDiagnal(){
	
	String[][] winO = new String[3][3];
        winO[2][0] = "O";
        winO[1][1] = "O";
        winO[0][2] = "O";       
	assertEquals(true, PlayGame.chechInvDiagnal(winO));

	String[][] winX = new String[3][3];
	winX[2][0] = "X";			     
        winX[1][1] = "X";			     
	winX[0][2] = "X";
	assertEquals(true, PlayGame.chechInvDiagnal(winX));
	
 	String[][] wrong1  = new String[3][3];
	wrong1[2][0] = "X";			     
        wrong1[1][1] = "O";			     
	wrong1[0][2] = "X";
	assertEquals(false, PlayGame.chechInvDiagnal(wrong1));
     
	String[][] wrong2 = new String[3][3];
	wrong2[2][0] = "O";			     
        wrong2[1][1] = "X";			     
	wrong2[0][2] = "O";
	assertEquals(false, PlayGame.chechInvDiagnal(wrong2));
	     
    }

    @Test
    public void testDiagnal(){
	
	String[][] winO = new String[3][3];
        winO[0][0] = "O";
        winO[1][1] = "O";
        winO[2][2] = "O";       
	assertEquals(true, PlayGame.checkDiagnal(winO));

	String[][] winX = new String[3][3];
	winX[0][0] = "X";			     
        winX[1][1] = "X";			     
	winX[2][2] = "X";
	assertEquals(true, PlayGame.checkDiagnal(winX));
	
 	String[][] wrong1  = new String[3][3];
	wrong1[0][0] = "X";			     
        wrong1[1][1] = "O";			     
	wrong1[2][2] = "X";
	assertEquals(false, PlayGame.checkDiagnal(wrong1));
     
	String[][] wrong2 = new String[3][3];
	wrong2[0][0] = "O";			     
        wrong2[1][1] = "X";			     
	wrong2[2][2] = "O";
	assertEquals(false, PlayGame.checkDiagnal(wrong2));

    }


}
