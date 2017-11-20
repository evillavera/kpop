package alexErikGame;

import caveExplorer.CaveExplorer;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	private int userShips;
	private int compShortShips;
	private int compLongShips;
	private int shortShipSize;
	private int largeShipSize;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[7][7];
		userShips = 3;
		compShortShips = 1;
		compLongShips = 2;
		shortShipSize = 3;
		largeShipSize = 4;
		getGrid();
	}

	// NOCKLES : "IN ORDER FOR BACKEND TO MEET THE REQUIREMENT FOR A 5, THE AI MUST BE SMART"
	// IF THE AI HITS A SHIP, IT MUST SELECT TO HIT ANOTHER SPACE NEAR THE SHIP
	// CHECK THE RUBRIC FOR ADDITIONAL INFORMATION

	//NEW IDEA: HAVE A SHIP THAT MUST BE HIT TWICE IN EACH SPACE TO BE SUNK
	
	//STEPS TO MAKE INTELLIGENT AI
	//1. Activate computer's turn
	//2. Computer decides and launches missile
	//3. Message displayed to console -- "The computer has taken its turn. It has launched a missile at the coordinates(,). That's a miss. "
	//4. Activate player's turn
	public void getGrid() {
		for(int row = 0; row < ships.length; row++){
			for(int col = 0; col < ships[row].length; col++){
				ships[row][col] = new AlexErikFleet(row, col);
			}
		}
		// Include 2 longer ships
		// include player ships?
		// make sure nothing overlaps
		
		//Add Ships randomly
		//NEW WAY TO IMPLEMENT compShips
		//0. Decide which ships will be placed in the sea first
		//1.pick a random space in the sea
		//2. use math.random to select whether or not the ship will be placed vertically or horizontally
		//3. check to see if the ship is able to fit in that orientation
		//4. place ships spaces in the sea
		//5. Do the same for all the ships
		int countShortCompShips = 0;
		int countLongCompShips = 0;
		while(countShortCompShips < compShortShips){
			int randRow = (int)(Math.random() * ships.length);
			int randCol = (int)(Math.random() * ships[randRow].length);
			// RULES TO FOLLOW REGARDING PLACEMENT OF SHIPS
			// CHECK VERTICAL THEN HORIZONTAL
			// FOR VERTICAL, CHECK UP FIRST, AND THEN DOWN
			// FOR HORIZONTAL, CHECK LEFT, AND THEN RIGHT			
			if(!ships[randRow][randCol].containsShip()){
				if(Math.random() < .5) {
					if(randRow > shortShipSize-2 && !ships[randRow-1][randCol].containsShip() && !ships[randRow-2][randCol].containsShip()) {
						// activate vertical in upward directions
						for(int i = randRow; i > randRow - 3;i--) {
							ships[i][randCol].setContainsShip(true); // => have 4 function that place ships vertically and horizontally in specific directions -- second parameter can indicate direction
						}
					}
					else if(!ships[randRow+1][randCol].containsShip() && !ships[randRow+2][randCol].containsShip()){
						// activate vertical in downward direction
						for(int i = randRow; i < randRow + 3;i++) {
							ships[i][randCol].setContainsShip(true); // => have 4 function that place ships vertically and horizontally in specific directions -- second parameter can indicate direction
						}
					}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
					countShortCompShips++;
				}
				else {
					if(randCol > shortShipSize-2 && !ships[randRow][randCol-1].containsShip() && !ships[randRow][randCol-2].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 3;i--) {
							ships[randRow][i].setContainsShip(true); // => have 4 function that place ships vertically and horizontally in specific directions -- second parameter can indicate direction
						}
					}
					else if(!ships[randRow][randCol+1].containsShip() && !ships[randRow][randCol+2].containsShip()){
						// activate horizontal in rightward direction
						for(int i = randCol; i < randCol + 3;i++) {
							ships[i][randCol].setContainsShip(true); // => have 4 function that place ships vertically and horizontally in specific directions -- second parameter can indicate direction
						}
					}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
					countShortCompShips++;
				}
			}
		}
	}
	
	public void placeComputerShortShipsVertically(int colnum, int direction) {
		
	}
	public AlexErikFleet[][] getFleet(){
		getGrid();
		return ships;
	}
	
	public void computerTakesTurn() {
		
	}
	
	public boolean sunk() {
		return true;
	}
	
	public boolean shipSink() {
		return true;
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
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>"
					+ "\n<row> and <col> should be integers.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
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

	public int getShipsSunk() {
		return 0;
	}
	
	public int getComputerShipsSunk() {
		return 0;
	}
	
	public boolean PlayerWon() {
		return true;
	}

	public void computerTurn() {
		// TODO Auto-generated method stub
		
	}
	
}