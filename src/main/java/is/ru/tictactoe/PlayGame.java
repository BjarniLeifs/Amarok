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


}
