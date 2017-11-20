package alexErikGame;

import caveExplorer.CaveExplorer;

public class ErikFrontEnd implements AlexSupport{

	private ErikSupport backend;
	private int userShips;
	private int compShips;
	private String message;
	private AlexErikFleet[][] userBoard;
	private AlexErikFleet[][] compBoard;
	private int[] lastCoords;
	
	public static void main(String[] args) {
		ErikFrontEnd game = new ErikFrontEnd();
		game.directions();
		//game.startGame();
	}
	
	/*
	 * Fix outofbounds error for displayhints code DONE
	 * make places where you already shot unshootable
	 * add a directions screen
	 * make cheat code
	 */
	
	
	private void directions() {
		System.out.println("Welcome to BattleShip! Your ships are auto-generated for you.\n"
				+ "Your goal is to find and destroy all your enemies ships!\n"
				+ "There are 1 3space ship and 2 4space ships to attack.\n"
				+ "You must enter your coordinates in this format row,col.\n"
				+ "If you miss, you will be asked if you want a hint. You must reply yes or no.\n");
		//add a press 'p' to play
		startGame();
	}

	public ErikFrontEnd() {
			backend = new AlexBackEnd(this);
			CaveExplorer.initScanner();
			userShips = backend.getUserShips();
			compShips = backend.getCompShips();
			message = null;
			userBoard = backend.getFleet();
			compBoard = backend.getFleet();
			int[] lastCoords = new int[2];
	}
	
	private void startGame() {
		while(userShips > 0 && compShips > 0) {
			displayUserBoard(userBoard);
			//System.out.println("\n");
			//displayCompBoard(compBoard);
			System.out.println("\nWhere do you want to shoot?");
			int[] coords = backend.getCoordInput();
			lastCoords = coords;
			playersTurn(coords);
			compShips = backend.getCompShips();
			backend.computerTurn();
			userShips = backend.getUserShips();
		}
		displayResult();
		System.out.println("GAME OVER\n");
		
	/*
		while(userShips > 0 && compShips > 0) {
			computerTurn();
			//tell user if ship is in NESW
			System.out.println("Where do you want to shoot?");
			int[] coords = backend.getCoordInput();
		
			
		//	p = ships[coords[0]][coords[1]];
		}
		displayResult();
		System.out.println("GAME OVER\n");
	*/	
	}
	
	private void playersTurn(int [] coords) {
		int row = coords[0];
		int col = coords[1];
		if(userBoard[row][col].containsShip()) {
			userBoard[row][col].setRevealed(true);
			userBoard[row][col].setContainsShip(false);
			System.out.println("That's a hit!");
		}
		//when ship is destroyed
	/*	if(compShips == backend.getCompShips()-1)
		
		
	*/	else {
			userBoard[row][col].setMiss(true);
			System.out.println("You missed.");
			displayHints();
		}
	}

	private void displayUserBoard(AlexErikFleet[][] ships) {
		String rows = "0123456789";
		String columns = "   0  1  2  3  4  5  6  7  8  9";
		for(int row = 0; row < ships.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < ships[row].length; col++){
				if(ships[row][col].isRevealed()){
					System.out.print("[x]");
				}
	/*			
				else if(ships[row][col].containsShip()){
						System.out.print("[+]");
				}	
		*/
					else if(ships[row][col].isMiss()) {
						System.out.print("[o]");
					}else {
					System.out.print("[ ]");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
			System.out.print(columns.substring(0, ships[0].length+18));
	}
/*	
	private void displayCompBoard(AlexErikFleet[][] ships) {
		String rows = "0123456789";
		String columns = "   0  1  2  3  4  5  6  7  8  9";
		for(int row = 0; row < ships.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < ships[row].length; col++){
				if(ships[row][col].isRevealed()){
					System.out.print("[x]");
				}
				
				else if(ships[row][col].containsShip()){
						System.out.print("[+]");
				}	
				
					else if(ships[row][col].isMiss()) {
						System.out.print("[o]");
					}else {
					System.out.print("[ ]");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
			System.out.print(columns.substring(0, ships[0].length+18));
	}
	
*/	
	public void displayShipsSunk(AlexErikFleet p) {
		// TODO Auto-generated method stub
		
	}

	public void displayHints() {
		System.out.println("Need a a hint?");
		String input = CaveExplorer.in.nextLine();
		if(input.equals("yes")) {
			System.out.println("Here is your hint.");
			checkAreaAround(lastCoords);
		}
	}

	private void checkAreaAround(int[] lastCoords) {
		
		int top = lastCoords[0]-1;
		int middle = lastCoords[0];
		int bottom = lastCoords[0]+1;
		int left = lastCoords[1]-1;
		int between = lastCoords[1];
		int right = lastCoords[1]+1;
	
		if(top > -1 && top < 7 && left > -1 && left < 7) {
			//check area north
			if(userBoard[top][left].containsShip() || userBoard[top][between].containsShip()) {
				System.out.println("There is a ship North");
			}
		}
		if(bottom > 0 && bottom < 8 && right > 0 && right < 8) {
			//check area south
			if(userBoard[bottom][middle].containsShip() ||  userBoard[bottom][right].containsShip()) {
				System.out.println("There is a ship South");
			}
		}
		if(left > -1 && left < 7 && bottom > 0 && bottom < 8) {
			//check area west
			if(userBoard[middle][left].containsShip() ||  userBoard[bottom][left].containsShip()) {
				System.out.println("There is a ship West");
			}
		}
		if(right > 0 && right < 8 && top > -1 && top < 7) {
			//check area east
			if(userBoard[top][right].containsShip() ||  userBoard[middle][right].containsShip()) {
				System.out.println("There is a ship East");
			}
		}
		
		System.out.println("There are no ships around you!");
	}

	public void displayResult() {
		if(compShips == 0) {
			System.out.println("You did it!!");
		}else {
			System.out.println("Maybe if you try this cheat code 'i love pie' you can win.");
		}
		
	}

	public int getCompShips() {
		return compShips;
	}

	public int getUserShips() {
		return userShips;
	}
}
