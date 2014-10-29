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

    public void testDraw(){
	for(int i = 0; i < 15; i++){
	    int finishGame = rand.nextInt(15);
	    if(finishGame < 9) assertEquals(false, PlayGame.checkDraw(finishGame, null, null));
	    else assertEquals(true, PlayGame.checkDraw(finishGame, null, null));
	}
    }

    @Test
    public void testCheckWins(){
	String[][] win = new String[3][3];
	//test horizontal
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(i % 2 == 0) win[i][j] = "O";
		else win[i][j] = "X";
	    }
	    assertEquals(true, PlayGame.checkWins(win));
	}
		
	//test vertical
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 3; j++){
		if(i % 2 == 0)win[j][i] = "X";
		else win[j][i] = "O";
	    }
	    assertEquals(true, PlayGame.checkWins(win));
	}
	
	//test diagonal
        win[0][0] = "O";
        win[1][1] = "O";
        win[2][2] = "O";       
	assertEquals(true, PlayGame.checkWins(win));

	win[0][0] = "X";     
        win[1][1] = "X";     
	win[2][2] = "X";
	assertEquals(true, PlayGame.checkWins(win));

	//test inv diagonal
        win[2][0] = "O";
        win[1][1] = "O";
        win[0][2] = "O";      
	assertEquals(true, PlayGame.checkWins(win));

	win[2][0] = "X";     
        win[1][1] = "X";     
	win[0][2] = "X";
	assertEquals(true, PlayGame.checkWins(win));


    }


}
