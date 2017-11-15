package alexErikGame;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	private int userShips;
	private int compShips;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[6][6];
		userShips = 3;
		compShips = 3;
		getGrid();
	}
	
	public AlexErikFleet[][] getFleet(){
		return ships;
	}
	
	public void shipShape() {
		// TODO Auto-generated method stub
		
	}

	public void sunk() {
		// TODO Auto-generated method stub
		
	}

	public void placeMarker() {
		// TODO Auto-generated method stub
		
	}

	public int[] getCoordInput() {
		// TODO Auto-generated method stub
		return null;
	}
	// NOCKLES : "IN ORDER FOR BACKEND TO MEET THE REQUIREMENT FOR A 5, THE AI MUST BE SMART"
	// IF THE AI HITS A SHIP, IT MUST SELECT TO HIT ANOTHER SPACE NEAR THE SHIP
	// CHECK THE RUBRIC FOR ADDITIONAL INFORMATION
	public void getGrid() {
		for(int row = 0; row < ships.length; row++){
			for(int col = 0; col < ships[row].length; col++){
				ships[row][col] = new AlexErikFleet(row, col);
			}
		}
		/*
		//Add Ships randomly
		int count = 0;
		while( count < userShips){
			int randRow = (int)(Math.random() * plots.length);
			int randCol = (int)(Math.random() * plots[randRow].length);
			if(!plots[randRow][randCol].containsTreasure()){
				plots[randRow][randCol].setContainsTreasure(true);
				plots[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
				count++;
			}
		}
		*/
	}

	public int getShipsSunk() {
		return 0;
	}

	
	public boolean checkNumCoordInput(String userInput) {
		// this method should only be used on the numbers in the coordinates
		try {
			int num1 = Integer.parseInt(userInput.substring(0,1));
			return true;
		}
		catch(NumberFormatException dumnum){
			return false;
		}
	}
	public boolean checkCommmaCoordInput(String userInput) {
		// this method should only be used on the commma part of the coordinate form
		if(userInput.substring(1,2).equals(",")) {
			return true;
		}
		return false;
	}
	
}