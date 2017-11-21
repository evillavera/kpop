package alexErikGame;

import caveExplorer.CaveExplorer;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	private AlexErikFleet[][] compships;
	private int userShips;
	private int compShips;
	private int compShortShips;
	private int compLongShips;
	private int shortShipSize;
	private int largeShipSize;
	private boolean smartComp;
	private int shipsSunk;
	
	private int selRow;
	private int selCol;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[8][8];
		compships = new AlexErikFleet[8][8];
		userShips = 3;
		compShips = 3;
		compShortShips = 1;
		compLongShips = 2;
		shortShipSize = 3;
		largeShipSize = 4;
		smartComp = false;
		getGrid();
	}

	// NOCKLES : "IN ORDER FOR BACKEND TO MEET THE REQUIREMENT FOR A 5, THE AI MUST BE SMART"
	// IF THE AI HITS A SHIP, IT MUST SELECT TO HIT ANOTHER SPACE NEAR THE SHIP
	// CHECK THE RUBRIC FOR ADDITIONAL INFORMATION

	//NEW IDEA: HAVE A SHIP THAT MUST BE HIT TWICE IN EACH SPACE TO BE SUNK
	public void getGrid() {
		for(int row = 0; row < ships.length; row++){
			for(int col = 0; col < ships[row].length; col++){
				ships[row][col] = new AlexErikFleet(row, col);
			}
		}
		// include player ships?
		// determine if ship is completely destroyed and whether or not it's a 3-ship for 4-ship
		// produce 3 ships, not two
		int countShortCompShips = 0;
		int countLongCompShips = 0;
		while(countShortCompShips < compShortShips){
			int randRow = (int)(Math.random() * ships.length);
			int randCol = (int)(Math.random() * ships[randRow].length);	
			if(!ships[randRow][randCol].containsShip()){
				if(randRow > shortShipSize-2 && !ships[randRow-1][randCol].containsShip() && !ships[randRow-2][randCol].containsShip()) {
					// activate vertical in upward directions
					for(int i = randRow; i > randRow - 3;i--) {
						ships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
				else if(!ships[randRow+1][randCol].containsShip() && !ships[randRow+2][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 3;i++) {
						ships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
				else if(randCol > shortShipSize-2 && !ships[randRow][randCol-1].containsShip() && !ships[randRow][randCol-2].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 3;i--) {
							ships[randRow][i].setContainsShip(true);
						}
						countShortCompShips++;
				}
				else if(!ships[randRow][randCol+1].containsShip() && !ships[randRow][randCol+2].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 3;i++) {
						ships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
			}
		}
		while(countLongCompShips < compLongShips) {
			int randRow = (int)(Math.random() * ships.length);
			int randCol = (int)(Math.random() * ships[randRow].length);
			if(!ships[randRow][randCol].containsShip()){
				if(randRow > largeShipSize-2 && !ships[randRow-1][randCol].containsShip() && !ships[randRow-2][randCol].containsShip() && !ships[randRow-3][randCol].containsShip()) {
					// activate vertical in upward directions
					for(int i = randRow; i > randRow - 4;i--) {
						ships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
				else if(randRow <= largeShipSize && !ships[randRow+1][randCol].containsShip() && !ships[randRow+2][randCol].containsShip() && !ships[randRow+3][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 4;i++) {
						ships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
				else if(randCol > largeShipSize-2 && !ships[randRow][randCol-1].containsShip() && !ships[randRow][randCol-2].containsShip() && !ships[randRow][randCol-3].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 4;i--) {
							ships[randRow][i].setContainsShip(true);
						}
						countLongCompShips++;
				}
				else if(randCol <= largeShipSize && !ships[randRow][randCol+1].containsShip() && !ships[randRow][randCol+2].containsShip() && !ships[randRow][randCol+3].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 4;i++) {
						ships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
			}
		}
	}
	
	//public void placeComputerShortShipsVertically(int colnum, int direction)
	
	public void setUserShips(int userShips) {
		this.userShips = userShips;
	}

	public void setCompShips(int compShips) {
		this.compShips = compShips;
	}

	public AlexErikFleet[][] getFleet(){
		getGrid();
		return ships;
	}
	
	public AlexErikFleet[][] getCompFleet(){
		getCompGrid();
		return compships;
	}
	
	public void getCompGrid() {
		for(int row = 0; row < compships.length; row++){
			for(int col = 0; col < compships[row].length; col++){
				compships[row][col] = new AlexErikFleet(row, col);
			}
		}
		// include player ships?
		// determine if ship is completely destroyed and whether or not it's a 3-ship for 4-ship
		// produce 3 ships, not two
		int countShortCompShips = 0;
		int countLongCompShips = 0;
		while(countShortCompShips < compShortShips){
			int randRow = (int)(Math.random() * compships.length);
			int randCol = (int)(Math.random() * compships[randRow].length);	
			if(!compships[randRow][randCol].containsShip()){
				if(randRow > shortShipSize-2 && !compships[randRow-1][randCol].containsShip() && !compships[randRow-2][randCol].containsShip()) {
					// activate vertical in upward directions
					for(int i = randRow; i > randRow - 3;i--) {
						compships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
				else if(!compships[randRow+1][randCol].containsShip() && !compships[randRow+2][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 3;i++) {
						compships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
				else if(randCol > shortShipSize-2 && !compships[randRow][randCol-1].containsShip() && !compships[randRow][randCol-2].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 3;i--) {
							compships[randRow][i].setContainsShip(true);
						}
						countShortCompShips++;
				}
				else if(!compships[randRow][randCol+1].containsShip() && !compships[randRow][randCol+2].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 3;i++) {
						compships[i][randCol].setContainsShip(true);
					}
					countShortCompShips++;
				}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
			}
		}
		while(countLongCompShips < compLongShips) {
			int randRow = (int)(Math.random() * compships.length);
			int randCol = (int)(Math.random() * compships[randRow].length);
			if(!compships[randRow][randCol].containsShip()){
				if(randRow > largeShipSize-2 && !compships[randRow-1][randCol].containsShip() && !compships[randRow-2][randCol].containsShip() && !ships[randRow-3][randCol].containsShip()) {
					// activate vertical in upward directions
					for(int i = randRow; i > randRow - 4;i--) {
						compships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
				else if(randRow <= largeShipSize && !compships[randRow+1][randCol].containsShip() && !compships[randRow+2][randCol].containsShip() && !ships[randRow+3][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 4;i++) {
						compships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
				else if(randCol > largeShipSize-2 && !compships[randRow][randCol-1].containsShip() && !compships[randRow][randCol-2].containsShip() && !ships[randRow][randCol-3].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 4;i--) {
							compships[randRow][i].setContainsShip(true);
						}
						countLongCompShips++;
				}
				else if(randCol <= largeShipSize && !compships[randRow][randCol+1].containsShip() && !compships[randRow][randCol+2].containsShip() && !ships[randRow][randCol+3].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 4;i++) {
						compships[i][randCol].setContainsShip(true);
					}
					countLongCompShips++;
				}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
			}
		}
	}
	
	
	
	
	public void computerTurn() {
		//STEPS TO MAKE INTELLIGENT AI
		//1. Activate computer's turn
		//2. Computer decides and launches missile
		//3. Message displayed to console -- "The computer has taken its turn. It has launched a missile at the coordinates(,). That's a miss. "
		//4. Activate player's turn
		
		//does the computer have a registered hit it can take
		//if it does, then use it
		// if it doesn't, then use a random
		//SHIPS ARE ONLY VERTICAL AND HORIZONTAL, THEY DON'T OCCUPY multiple rows AND multiple columns
		if(!smartComp) {
			int selRow = (int)(Math.random()*ships.length);
			int selCol = (int)(Math.random()*ships[selRow].length);	
			
			printMessageAndReturnComp(selRow,selCol);
		}
		else {
			// create a 2D array of potential coordinates to hit
			// be sure to remove the coordinates from the 2D array once they're used
			// be sure to add coordinates, each time a ship is hit.
			// check to see if the coordinate already exists in the array
			// if it does, don't add it into the array
			int potRow1 = selRow - 1;
			int potRow2 = selRow + 1;
			int potCol1 = selCol - 1;
			int potCol2 = selCol + 1;
			
			int[][] potCoords = new int[4][2];
			
			for(int i = 0; i < potCoords.length;i++) {
				for(int j = 0;j<potCoords[i].length-1;j++) {
					potCoords[i][j] = nums[markerRow];
					potCoords[i][j+1] = nums[markerCol];
					markerRow++;
					markerCol++;
				}
			}
			
			if(potRow1>0 && potRow1<7 && potCol1 > 0 && potCol1 < 7) {
				printMessageAndReturnComp(potRow1,potCol1);
			}
		}
	}
	
	public void printMessageAndReturnComp(int row, int col) {
		if(ships[row][col].containsShip()) {
			System.out.println("The computer has taken its turn. It has launched a missle at the coordinates ("+row+","+col+") That's a hit.");
			smartComp = true;
		}
		else {
			System.out.println("The computer has taken its turn. It has launched a missle at the coordinates ("+row+","+col+") That's a miss.");
			smartComp = false;
		}
	}
	
	
	
	public boolean sunk() {
		return true;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	public boolean shipHit() {
		return true;
	}
	
	
	public int getUserShips() {
		return userShips;
	}

	public int getCompShips() {
		return compShips;
	}

	public int[] getCoordInput() {
		String input = CaveExplorer.in.nextLine();
		while(!(input.length() == 3)) {
			System.out.println("Please enter a valid coordinate.\n"+
					"It should look like _,_ with the blanks being single digit numbers.\n"+
					"Please enter a new coordinate.\n");
			input = CaveExplorer.in.nextLine();
		}
		int[] coords = toCoords(input);
		if(coords[0] == 9 && coords[1] == 9) {
			return coords;
		}
		while(((coords == null || coords[0] < 0 || coords[0] > ships.length-1 || coords[1] < 0 || coords[1] > ships[0].length))){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>"
					+ "\n<row> and <col> should be integers.\n"
					+ "It should also be within the array bounds.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
			if(coords[0] == 9 && coords[1] == 9) {
				return coords;
			}
		}
		return coords;
	}
	
	private int[] toCoords(String input) {
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() ==3){
				int[] coords = {a,b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	public int getComputerShipsSunk() {
		return 0;
	}
	
	public boolean PlayerWon() {
		return true;
	}
	
}