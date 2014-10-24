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
	HumanPlayer human_A = new HumanPlayer();
	HumanPlayer human_B = new HumanPlayer();
	ComputerPlayer comp_A = new ComputerPlayer();
	ComputerPlayer comp_B = new ComputerPlayer();

	comp_A.setUsername("Awesom-O"); //set computer names
	comp_B.setUsername("R2-D2"); 

	printWelcome();
	//----------------
	String username;
	out.println(); 
	out.print("Username: "); username = in.readString();
	out.println();
	human_A.setUsername(username);
	//----------------
	printMenu();

	int choice, tmp = 0;
	boolean tick = false;
	do{
	    tmp++;
	    initialiazeTheBoard();
	    out.print("Your choice: "); choice = in.readInt();
	    out.println();

	    if(choice == 1 || choice == 2 ||choice == 3 || choice == 0) out.print(referenceBoardToString());
	    
	    if(choice == 0){
		tick = true;
		printInfo();
	    }

	    //set the game mode
	    else if(choice == 1){
		if(tmp == 1 || tick){
		    out.print("Player 2 Username: "); username = in.readString();
		    out.println();
		    human_B.setUsername(username);
		    tick = false;
		}
		play(human_A, human_B);
	    }
	    
	    else if(choice == 2){
		play(human_A, comp_A);
	    }
	    
	    else if(choice == 3){
		play(comp_A, comp_B); 
	    }
	   

	}while(choice == 1 || choice == 2 ||choice == 3 || choice == 0); //TODO: write a test for testing if correct game mode is entered after in each case

	//TODO: print out the results table

    }
    
    //printing functions
    public static void printInfo(){
	out.println("---------------------------------------------------------------------"); 
	out.println("\t\t\tProduction of AMAROK");
	out.println("---------------------------------------------------------------------"); 
	out.println("TicTacToe is a widely known Tic Tac Toe game for Linux and Unix OS.");
	out.println("In this game, player can play against another player, compete against");
	out.println("a computer and finally to spectate a game computer vs computer.");
	out.println("If you dont know how to play Tic Tac Toe, see the follwoing link ");
	out.println("for more information http://www.cs.jhu.edu/~jorgev/cs106/ttt.pdf");
	out.println("---------------------------------------------------------------------"); 
	out.println(); 
    }

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
	out.println("--------------------------------------------"); 	
	out.println("\t\t MAIN MENU ");
	out.println("--------------------------------------------\n"); 
	out.println("[ Game mode ]");
	out.println("(1) Player vs Player ");
	out.println("(2) Player vs Computer ");
	out.println("(3) Computer vs Computer ");
	out.println();
	out.println("(0) Info");
	out.println("(4) Quit");
	out.println("\n");
    }

    public static String referenceBoardToString(){
	StringBuilder sb = new StringBuilder();
	sb.append("--------------------------------------------\n");
	sb.append("\t\tCoordinate map\n");
	sb.append("--------------------------------------------\n");
	sb.append("\t\t a1 | a2 | a3");
	sb.append("\n\t\t----+----+----\n");
	sb.append(" \t\t b1 | b2 | b3");
	sb.append("\n\t\t----+----+----\n");
	sb.append(" \t\t c1 | c2 | c3\n");
	sb.append("--------------------------------------------\n");
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

    
    //play the game...
    public static void play(Player player1, Player player2){
	Point point;
	boolean win = false;
	int finishGame = 0;  
	while(!win){
	    out.println(player1.getUsername()+ "'s " + "time to play "); 
	    point = player1.nextMove();
	    if(board[point.getX()][point.getY()] != " "){
		while(board[point.getX()][point.getY()] != " ") {
		    out.print("Invalid coordinate! Try again ");
		    out.println(); 
		    point = player1.nextMove();
		}
	    }
	    out.println();
	    board[point.getX()][point.getY()] = "X";
	    out.print(drawUpdatedBoard());
	    finishGame++; //x made a move
	    win = checkWins(); 
	    if(win){
		player1.setWins(player1.getWins() + 1);
		out.println("--------------------------------------------"); 	
		out.println("\t\t~~~Victory~~~");
		out.println("--------------------------------------------"); 	
		out.println("\t\t" + player1.getUsername() + " won!");
		
		out.println("\tWould you like to play again!?\n");
		printMenu();
		return;
	    }
	    
	    // check if draw
	    if(finishGame >= boardSize){
		out.println("--------------------------------------------"); 	
		out.println("\t\t~~~DRAW~~~");
		out.println("--------------------------------------------");
		out.println("\tWould you like to play again!?\n");
		return; 
	    }
	    
	    // player 2 starts playing  
	    out.println(player2.getUsername()+ "'s " + "time to play \n");
	    point = player2.nextMove();
	    if(board[point.getX()][point.getY()] != " "){
		while(board[point.getX()][point.getY()] != " ") {
		    out.print("Invalid coordinate! Try again ");
		    out.println();
		    point = player2.nextMove();
		}
	    }
	    board[point.getX()][point.getY()] = "O";
	    out.print(drawUpdatedBoard());
	    
	    finishGame++; //O made a move
	    win = checkWins(); 
	    if(win){
		player2.setWins(player2.getWins() + 1);
		out.println("--------------------------------------------"); 	
		out.println("\t\t~~~Victory~~~");
		out.println("--------------------------------------------"); 	
		out.println("\t\t" + player2.getUsername() + " won!");
		
		out.println("\tWould you like to play again!?\n");
		printMenu();
		return;
	    }
	    
	}
	
    }

    //Winning logic starts here -> TODO: test everything
    //IF ANYONE SEES HOW TO MAKE THIS PART SHORTER, GO AHEAD AND CHANGE IT!

    public static boolean checkWins(){ 
	if(checkHorizontalforX() || checkHorizontalforO() || checkVerticalforX() || checkVerticalforO() || checkDiagnal() || chechInvDiagnal()) return true;
	return false; 
    }
    
    private static boolean checkHorizontalforX(){
	boolean h1 = true;
	boolean h2 = true;
	boolean h3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[0][i] != "X") h1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[1][i] != "X") h2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[2][i] != "X") h3 = false; 
	}
	
	if(h1 || h2 || h3) return true;
	return false; 
    }
    
    private static boolean checkHorizontalforO(){
	boolean h1 = true;
	boolean h2 = true;
	boolean h3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[0][i] != "O") h1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[1][i] != "O") h2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[2][i] != "O") h3 = false; 
	}
	
	if(h1 || h2 || h3) return true;
	return false; 
    }
    
    private static boolean checkVerticalforX(){
	boolean v1 = true;
	boolean v2 = true;
	boolean v3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[i][0] != "X") v1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][1] != "X") v2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][2] != "X") v3 = false; 
	}
	
	if(v1 || v2 || v3) return true;
	return false; 
    }
    
    private static boolean checkVerticalforO(){
	boolean v1 = true;
	boolean v2 = true;
	boolean v3 = true;
	
	for(int i = 0; i < 3; i++){
	    if(board[i][0] != "O") v1 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][1] != "O") v2 = false; 
	}
	
	for(int i = 0; i < 3; i++){
	    if(board[i][2] != "O") v3 = false; 
	}
	
	if(v1 || v2 || v3) return true;
	return false; 
    }
    
    private static boolean checkDiagnal(){
	if(board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") return true; 
	else if(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") return true; 
	return false;
    }
    
    private static boolean chechInvDiagnal(){
	if(board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") return true; 
	else if(board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") return true; 
	return false;
    }


    

}
