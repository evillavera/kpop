package alexErikGame;

import caveExplorer.CaveExplorer;

public class ErikFrontEnd implements AlexSupport{

	private ErikSupport backend;
	private int userShips;
	private int compShips;
	private String message;
	
	public static void main(String[] args) {
		ErikFrontEnd game = new ErikFrontEnd();
		game.startGame();
	}
	
	public ErikFrontEnd() {
			backend = new AlexBackEnd(this);
			userShips = 3;
			compShips = 3;
			message = null;
	}
	
	private void startGame() {
		AlexErikFleet[][] ships = backend.getFleet();
		AlexErikFleet p = null;
		displayFleet(ships);
	/*
		while(userShips > 0 && compShips > 0) {
			displayFleet(ships);
			displayShipsSunk(p);
			displayHints();
			//tell user if ship is in NESW
			System.out.println("Where do you want to shoot?");
			int[] coords = backend.getCoordInput();
			
			userShips = getUserShips();
			compShips = getCompShips();
			
		//	p = ships[coords[0]][coords[1]];
		}
		displayResult();
		System.out.println("GAME OVER\n");
	*/	
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
