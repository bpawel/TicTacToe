
/*Tic Tac Toe*/

import java.util.Scanner;
public class game {
		private char[][] board;
		private char player1;
		private static Scanner print;
	public game() {
		board = new char[4][4];
		printMark();
		player1 = 'x';
	}
	
	public void printMark(){
		for(int i = 1; i < 4; i ++){
			 for(int j = 1; j < 4; j++){
				 board[i][j] = '*';
			 }
		}
	}
	//Print board
	public void boardGame(){
		System.out.println("-------------");
		//rows
		for(int i = 1; i < 4; i++){	
			System.out.print("| ");
			
			//column
			for(int j = 1; j < 4; j++){
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			
			System.out.println("-------------");
			
		}
	
	}
	//Loop which set char '*'.
	 public boolean boardFull(){
		 boolean full = true;
		 for(int i = 1; i < 4; i ++){
			 for(int j = 1; j < 4; j++){
				 if(board[i][j] == '*'){
					 full = false;
				 }
			 }
		 }	
		 return full;
	 }
		        
	//Loop checks rows for win.
	private boolean checkRow(){
		for(int i = 1; i < 4; i++){
			if(checkXY(board[1][i], board[2][i], board[3][i]) == true){
				return true;
			}
			
		}
		return false;
	}
	
	//Loop checks columns for win.
	private boolean checkColumn(){
		for(int j = 1; j < 4; j++){
			if(checkXY(board[j][1], board[j][2], board[j][3]) == true){
				return true;
			}
			
		}
		return false;
	}
	
	//Check diagonally for win.
	private boolean checkDiagonally(){
		return((checkXY(board[1][1], board[2][2], board[3][3]) == true) || (checkXY(board[1][3], board[2][2], board[3][1]) == true));
	}
	//Check if you won if all three values are the same.
	private boolean checkXY(char a, char b , char c){
		return((a != '*') && (a == b) && (b == c));
	}
	//If is a win returns true.
	public boolean check(){
		return (checkRow()||checkColumn()||checkDiagonally());
	}	
	
	//Change player
	public void player(){
		if(player1 == 'x'){
			player1 = 'o';
			
			
		}
		else{
			player1 = 'x';
			
		}
	}
	
	// Places a mark current player through the columns and rows.
	public boolean mark(int row, int col){
		if((row >= 1) && (row < 4)){
			if((col >=1) && (row < 4)){
				
					board[row][col] = player1;
					return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		
		game TicTacToe = new game();
		int a,b;
	
		print = new Scanner(System.in);
		System.out.println("Welcome to the game 'Tic tac toe'.");
		TicTacToe.printMark();
		TicTacToe.boardGame();

		
		while(true){
			
			System.out.println("Firts player starts out as 'o'. START!");
			System.out.println("Choose row and column[x][y]");
			
			TicTacToe.player();
			System.out.print("Choose row: ");
			a = print.nextInt();
			
			System.out.print("Choose column: ");
			b = print.nextInt();
			
			
			while(TicTacToe.mark(a,b)){
				TicTacToe.boardGame();
				if(TicTacToe.check()){
					System.out.println("YOU WON!");
					System.exit(0);
				}
				else if(TicTacToe.boardFull()){
					System.out.println("DRAW!");
					System.exit(0);
				}
				
				
				System.out.println();
				TicTacToe.player();
				System.out.print("Choose row: ");
				a = print.nextInt();
				System.out.print("Choose column: ");
				b = print.nextInt();
				
			
			}
			
		}
		
		
	}
}


