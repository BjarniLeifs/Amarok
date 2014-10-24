package is.ru.tictactoe;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class PlayGame {

    private static String[][] board = new String [3][3];
    private final static int boardSize = 9;
    //from algs4
    private static In in = new In();     
    private static Out out = new Out();
    

    public static void main(String[] args){

	//the game has 3 modes: human vs. human, computer vs. computer and human vs. computer
	//HumanPlayer human_A = new HumanPlayer();
	//HumanPlayer human_B = new HumanPlayer();
	//ComputerPlayer comp_A = new ComputerPlayer();
	//ComputerPlayer comp_B = new ComputerPlayer();

	printWelcome();
	printMenu();

    }
    
    //printing functions
    //the tilte was generated using terminal: figlet TicTacToe
    public static void printWelcome(){
	out.println(" _____ _     _____         _____"); 
	out.println("|_   _(_) __|_   _|_ _  __|_   _|__   ___"); 
	out.println("  | | | |/ __|| |/ _` |/ __|| |/ _ \\ / _ \\"); 
	out.println("  | | | | (__ | | (_| | (__ | | (_) |  __/");
	out.println("  |_| |_|\\___||_|\\__,_|\\___||_|\\___/ \\___|");
	out.println("\n--------------------------------------------"); 
	out.println("\t\tVersion 0.1");
	out.println("--------------------------------------------"); 

    }

    public static void printMenu(){	
	out.println("\n\t\t MAIN MENU \n"); 
	out.println("[ Game mode ]");
	out.println("(1) Player vs Player ");
	out.println("(2) Player vs Computer ");
	out.println("(3) Computer vs Computer ");
	out.println();
	out.println("(i) Info");
	out.println("(4) Quit");
	out.println("\n");
	out.print("Your choice: \n");
    }

    public static String referenceBoardToString(){
	StringBuilder sb = new StringBuilder();
	sb.append(" a1 | a2 | a3");
	sb.append("\n----+----+----\n");
	sb.append(" b1 | b2 | b3");
	sb.append("\n----+----+----\n");
	sb.append(" c1 | c2 | c3\n");
	return sb.toString(); 
    }

    public static String drawUpdatedBoard(){
	StringBuilder sb = new StringBuilder(); 
	
	sb.append("  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\t\t|\t     " + " a1 | a2 | a3\n");
	sb.append("----+---+----" + "\t\t|\t     " + "----+----+----\n");
	sb.append("  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\t\t|\t     " + " b1 | b2 | b3\n");
	sb.append("----+---+----" + "\t\t|\t     " + "----+----+----\n");
	sb.append("  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\t\t|\t     " + " c1 | c2 | c3\n");
	
	return sb.append("\n").toString(); 
    }

    //-----Game logic starts here-----

    //TODO: write a unit test! Check if the board is empty when new game starts
    //ALSO test, if this function correctly initializes the board. Hence every elment has to be equal to " "
    public static void initialiazeTheBoard(){
	for(int i = 0; i < 3; i++)
	    for(int j = 0; j < 3; j++)
		board[i][j] = " ";
    }

    

}
