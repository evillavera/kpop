package alexErikGame;

import caveExplorer.CaveExplorer;

public class ErikFrontEnd implements AlexSupport{

	private ErikSupport backend;
	private int userShips;
	private int compShips;
	private String message;
	private AlexErikFleet[][] userBoard;
	private AlexErikFleet[][] compBoard;
	
	public static void main(String[] args) {
		ErikFrontEnd game = new ErikFrontEnd();
		game.startGame();
	}
	
	public ErikFrontEnd() {
			backend = new AlexBackEnd(this);
			CaveExplorer.initScanner();
			userShips = 3;
			compShips = 3;
			message = null;
			userBoard = backend.getFleet();
			compBoard = backend.getFleet();
	}
	
	private void startGame() {
		displayUserBoard(userBoard);
		System.out.println("\nWelcome to BattleShip! Your ships are auto-generated for you.");
		//makeShips();
		while(userShips > 0 && compShips > 0) {
			displayUserBoard(userBoard);
			System.out.println("Where do you want to shoot?");
			int[] coords = backend.getCoordInput();
			playersTurn(coords);
			compShips = backend.getCompShips();
			backend.computerTurn();
			userShips = backend.getUserShips();
		}
		
	/*
		while(userShips > 0 && compShips > 0) {
			displayShipsSunk(p);
			displayHints();
			playersTurn();
			userShips = getUserShips();
			compShips = getCompShips();
			computerTurn();
			userShips = getUserShips();
			compShips = getCompShips();
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
		}else
			userBoard[row][col].setMiss(true);
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
			System.out.print(columns.substring(0, ships[0].length+16));
	}
	
	public void displayShipsSunk(AlexErikFleet p) {
		// TODO Auto-generated method stub
		
	}

	public void displayHints() {
		// TODO Auto-generated method stub
		
	}

	public void displayResult() {
		// TODO Auto-generated method stub
		
	}

	public int getCompShips() {
		return compShips;
	}

	public int getUserShips() {
		return userShips;
	}
}
