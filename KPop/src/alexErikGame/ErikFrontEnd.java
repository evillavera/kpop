package alexErikGame;

import caveExplorer.CaveExplorer;

public class ErikFrontEnd implements AlexSupport{

	private ErikSupport backend;
	private int userShips;
	private int compShips;
	private String message;
	private AlexErikFleet[][] ships;
	
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
			ships = backend.getFleet();
	}
	
	private void startGame() {
		AlexErikFleet[][] ships = backend.getFleet();
		AlexErikFleet p = null;
		displayFleet(ships);
		makeShips();
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
	
	private void makeShips() {
		String input = CaveExplorer.in.nextLine();
		selectPosition(input);
		CaveExplorer.in.nextLine();
		System.out.println("Hi");
		if(input.length() == 3 && input.substring(0,1).length() < backend.getFleet().length && input.substring(2,3).length() < backend.getFleet().length) {
			CaveExplorer.in.nextLine();
			//place ship
			if(!ships[Integer.parseInt(input.substring(0,1))][Integer.parseInt(input.substring(2,3))].containsShip()) {
				System.out.println("Hello");
			}
		}
		
	}
	

	private void selectPosition(String input) {
		boolean vertical = false;
		boolean horizontal = false;
		System.out.println("Where do you want to place your 3 platform ship?"+"Press 'h' for horizontal or 'p' for vertical)");
		if(input.equals("v")) {
			vertical = true;
			horizontal = false;
		}else if(input.equals("h")) {
			horizontal = true;
			vertical = false;
		} else {
			System.out.println("Please enter a valid input. 'h' or 'p'.");
		}
	}

	private void displayFleet(AlexErikFleet[][] ships) {
		String rows = "0123456789";
		String columns = "   0 1 2 3 4 5 6 7 8 9";
		for(int row = 0; row < ships.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < ships[row].length; col++){
				if(ships[row][col].isRevealed()){
					if(ships[row][col].containsShip()){
						System.out.print("X");
					}else{
						System.out.print(" ");	
					}

				}else{
					System.out.print("[]");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
			System.out.print(columns.substring(0, ships[0].length+10));
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
