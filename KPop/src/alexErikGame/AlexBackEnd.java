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
	private int[] computerCoords;
	
	private int potRow1;
	private int potRow2;
	private int potCol1;
	private int potCol2;
	private int[][] shipCoordsArr;
	private int[][] shipCoordsArrComp;
	private boolean isVertical;
	private int compLogicNum;
	private int trackShipCoordInd;
	private int trackShipCoordIndComp;
	private int track3ShipHits;
	private int track4ShipHits1;
	private int track4ShipHits2;
	private boolean threeShipSunk = false;
	private boolean first4ShipSunk = false;
	private boolean second4ShipSunk = false;
	private int track3ShipHitsComp;
	private int track4ShipHits1Comp;
	private int track4ShipHits2Comp;
	private boolean threeShipSunkComp = false;
	private boolean first4ShipSunkComp = false;
	private boolean second4ShipSunkComp = false;
	
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
		shipCoordsArr = new int[11][2];
		shipCoordsArrComp = new int[11][2];
		computerCoords = new int[2];
		compLogicNum = 0;
		trackShipCoordInd = 0;
		trackShipCoordIndComp = 0;
		track3ShipHits = 0;
		track4ShipHits1 = 0;
		track4ShipHits2 = 0;
		track3ShipHitsComp = 0;
		track4ShipHits1Comp = 0;
		track4ShipHits2Comp = 0;
		threeShipSunk = false;
		first4ShipSunk = false;
		second4ShipSunk = false;
	}
	
	public void coordsArrCreation(int row, int col){
		shipCoordsArr[trackShipCoordInd][0] = row;
		shipCoordsArr[trackShipCoordInd][1] = col;
		trackShipCoordInd++;
	}
	
	public void coordsArrCreationComp(int row, int col){
		shipCoordsArrComp[trackShipCoordIndComp][0] = row;
		shipCoordsArrComp[trackShipCoordIndComp][1] = col;
		trackShipCoordIndComp++;
	}
	// keep track of ships
	// if the computer hit all the spaces on a user's ship, the user's ship has sunk
	// if the computer hits a space on the user's ship, the count for the # of times the ship was hit should increase
	
	
	
	public void trackShipsHits(int[] coords, int player) {
		if(player == 0) {
			for(int i = 0; i < shipCoordsArr.length;i++) {
				if(shipCoordsArr[i][0] ==coords[0]  && shipCoordsArr[i][1] == coords[1]) {
					if(i < 3) {
						//3ship
						this.track3ShipHits++;
						//trackShipHits(0);
					}
					if(i > 2 && i < 7) {
						//1stfourship
						this.track4ShipHits1++;
						//trackShipHits(1);
					}
					if(i>6 && i<11) {
						//2ndfourship
						this.track4ShipHits2++;
						//trackShipHits(2);
					}
				}
			}
			
			if(this.track3ShipHits >= 3 && !threeShipSunk) {
				threeShipSunk = true;
				this.compShips --;
				System.out.println("You destroyed the 3 long ship!");
			}
			if(this.track4ShipHits1 >= 4 && !first4ShipSunk) {
				first4ShipSunk = true;	
				this.compShips --;
				System.out.println("You destroyed the 4 long ship!");
			}
			if(this.track4ShipHits2 >= 4 && !second4ShipSunk) {
				second4ShipSunk = true;	
				this.compShips --;
				System.out.println("You destroyed the 4 long ship!");
			}
			System.out.println("Computer has " + this.compShips + " ships left.");
		}
		
		else
		{
			for(int i = 0; i < shipCoordsArrComp.length;i++) {
				if(shipCoordsArrComp[i][0] ==coords[0]  && shipCoordsArrComp[i][1] == coords[1]) {
					if(i < 3) {
						//3ship
						this.track3ShipHitsComp++;
						//trackShipHits(0);
					}
					if(i > 2 && i < 7) {
						//1stfourship
						this.track4ShipHits1Comp++;
						//trackShipHits(1);
					}
					if(i>6 && i<11) {
						//2ndfourship
						this.track4ShipHits2Comp++;
						//trackShipHits(2);
					}
				}
			}
			
			/*
			 * Now it is possible to win, idk about losing UHHHH DONT LOSE
			 * change cmop test color DONE
			 * keep doing test
			 * fix comp turn out of bounds GOOD
			 * keep playing TEXT OUT OF PLACE ONCE IN AWHILE
			 * MERGE
			 */
			
			
			
			if(this.track3ShipHitsComp >= 3 && !threeShipSunkComp) {
				threeShipSunkComp = true;
				this.userShips --;
				System.err.println("Computer destroyed the 3 long ship!");
			}
			if(this.track4ShipHits1Comp >= 4 && !first4ShipSunkComp) {
				first4ShipSunkComp = true;	
				this.userShips --;
				System.err.println("Computer destroyed the 4 long ship!");
			}
			if(this.track4ShipHits2Comp >= 4 && !second4ShipSunkComp) {
				second4ShipSunkComp = true;	
				this.userShips --;
				System.err.println("Computer destroyed the 4 long ship!");
			}
			System.out.println("You have " + this.userShips + " ships left.\n");
		}
	}
	
	public void printMessageAndReturnComp(int row, int col) {
		if(compships[row][col].containsShip()) {
			System.err.println("The computer has taken its turn. It has launched a missle at the coordinates ("+row+","+col+") That's a hit.");
			smartComp = true;
			selRow = row;
			selCol = col;
		}
		else {
			System.err.println("The computer has taken its turn. It has launched a missle at the coordinates ("+row+","+col+") That's a miss.");
			smartComp = false;
		}
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
						coordsArrCreation(i,randCol);
					}
					countShortCompShips++;
				}
				else if(!ships[randRow+1][randCol].containsShip() && !ships[randRow+2][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 3;i++) {
						ships[i][randCol].setContainsShip(true);
						coordsArrCreation(i,randCol);
					}
					countShortCompShips++;
				}
				else if(randCol > shortShipSize-2 && !ships[randRow][randCol-1].containsShip() && !ships[randRow][randCol-2].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 3;i--) {
							ships[randRow][i].setContainsShip(true);
							coordsArrCreation(randRow,i);
						}
						countShortCompShips++;
				}
				else if(!ships[randRow][randCol+1].containsShip() && !ships[randRow][randCol+2].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 3;i++) {
						ships[randRow][i].setContainsShip(true);
						coordsArrCreation(randRow,i);
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
						coordsArrCreation(i,randCol);
					}
					countLongCompShips++;
				}
				else if(randRow <= largeShipSize && !ships[randRow+1][randCol].containsShip() && !ships[randRow+2][randCol].containsShip() && !ships[randRow+3][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 4;i++) {
						ships[i][randCol].setContainsShip(true);
						coordsArrCreation(i,randCol);
					}
					countLongCompShips++;
				}
				else if(randCol > largeShipSize-2 && !ships[randRow][randCol-1].containsShip() && !ships[randRow][randCol-2].containsShip() && !ships[randRow][randCol-3].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 4;i--) {
							ships[randRow][i].setContainsShip(true);
							coordsArrCreation(randRow,i);
						}
						countLongCompShips++;
				}
				else if(randCol <= largeShipSize && !ships[randRow][randCol+1].containsShip() && !ships[randRow][randCol+2].containsShip() && !ships[randRow][randCol+3].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 4;i++) {
						ships[randRow][i].setContainsShip(true);
						coordsArrCreation(randRow,i);
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
						coordsArrCreationComp(i,randCol);
					}
					countShortCompShips++;
				}
				else if(!compships[randRow+1][randCol].containsShip() && !compships[randRow+2][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 3;i++) {
						compships[i][randCol].setContainsShip(true);
						coordsArrCreationComp(i,randCol);
					}
					countShortCompShips++;
				}
				else if(randCol > shortShipSize-2 && !compships[randRow][randCol-1].containsShip() && !compships[randRow][randCol-2].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 3;i--) {
							compships[randRow][i].setContainsShip(true);
							coordsArrCreationComp(randRow,i);
						}
						countShortCompShips++;
				}
				else if(!compships[randRow][randCol+1].containsShip() && !compships[randRow][randCol+2].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 3;i++) {
						compships[randRow][i].setContainsShip(true);
						coordsArrCreationComp(randRow,i);
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
						coordsArrCreationComp(i,randCol);
					}
					countLongCompShips++;
				}
				else if(randRow <= largeShipSize && !compships[randRow+1][randCol].containsShip() && !compships[randRow+2][randCol].containsShip() && !ships[randRow+3][randCol].containsShip()){
					// activate vertical in downward direction
					for(int i = randRow; i < randRow + 4;i++) {
						compships[i][randCol].setContainsShip(true);
						coordsArrCreationComp(i,randCol);
					}
					countLongCompShips++;
				}
				else if(randCol > largeShipSize-2 && !compships[randRow][randCol-1].containsShip() && !compships[randRow][randCol-2].containsShip() && !ships[randRow][randCol-3].containsShip()) {
						// activate horizontal in leftward directions
						for(int i = randCol; i > randCol - 4;i--) {
							compships[randRow][i].setContainsShip(true);
							coordsArrCreationComp(randRow,i);
						}
						countLongCompShips++;
				}
				else if(randCol <= largeShipSize && !compships[randRow][randCol+1].containsShip() && !compships[randRow][randCol+2].containsShip() && !ships[randRow][randCol+3].containsShip()){
					// activate horizontal in rightward direction
					for(int i = randCol; i < randCol + 4;i++) {
						compships[randRow][i].setContainsShip(true);
						coordsArrCreationComp(randRow,i);
					}
					countLongCompShips++;
				}
					//ships[randRow][randCol].setContainsShip(true);
					//ships[randRow][randCol].setTreasureValue(5+(int)(Math.random() * 16));
			}
		}
	}
	public void computerTurn() {
		this.compships = frontend.getCompBoard();
		if(!smartComp) {
			//System.out.println("Here");
			int selRow = (int)(Math.random()*compships.length);
			int selCol = (int)(Math.random()*compships[selRow].length);	
			printMessageAndReturnComp(selRow,selCol);
			this.computerCoords[0] = selRow;
			this.computerCoords[1] = selCol;
			
				if(compships[selRow][selCol].containsShip()) {
					compships[selRow][selCol].setRevealed(true);
					compships[selRow][selCol].setContainsShip(false);
					frontend.setCompBoard(compships);
				}
				else {
					compships[selRow][selCol].setMiss(true);
					frontend.setCompBoard(compships);
				}
		}
		
		else {
			potRow1 = selRow - 1;
			potRow2 = selRow + 1;
			potCol1 = selCol - 1;
			potCol2 = selCol + 1;
			
			// int[][] potCoords = new int[4][2]; -- maybe use a 2D array for potential coordinates
			//HIT IN FOLLOWING ORDER: N-E-S-W
			
			chooseCompLogic(compLogicNum);
			//copy bottom add to if up top
			if(isVertical) {
				if(compships[potRow1][selCol].containsShip() && potRow1 > 0) {
					compships[potRow1][selCol].setRevealed(true);
					compships[potRow1][selCol].setContainsShip(false);
					frontend.setCompBoard(compships);
					this.computerCoords[0] = potRow1;
					this.computerCoords[1] = selCol;
					compLogicNum = 0;
				}
				else {
					compships[potRow1][selCol].setMiss(true);
					frontend.setCompBoard(compships);
					this.computerCoords[0] = potRow1;
					this.computerCoords[1] = selCol;
					compLogicNum = 2;
				}
			}
			else {
				if(compships[selRow][potCol1].containsShip() && potCol1 > 0 ) {
					compships[selRow][potCol1].setRevealed(true);
					compships[selRow][potCol1].setContainsShip(false);
					frontend.setCompBoard(compships);
					this.computerCoords[0] = selRow;
					this.computerCoords[1] = potCol1;
					compLogicNum = 1;
				}
				else {
					compships[potRow1][selCol].setMiss(true);
					frontend.setCompBoard(compships);
					this.computerCoords[0] = potRow1;
					this.computerCoords[1] = selCol;
					compLogicNum = 3;
				}
			}
		}
		frontend.setCompBoard(compships);
	}
	public AlexErikFleet[][] getCompBoard() {
		return compships;
	}

	public int[] getComputerCoords() {
		return computerCoords;
	}

	/*
	 * STEPS TO TRACK SHIPS(FOR USER AND COMPUTER)
	 * when placing ships, insert coordinates into a 2d array(first 3 coordinates belong to the 3-ship, next four to the 4-ship, last four to the 4-ship)
	 * when the user's ship coordinates match those in the array(hence the ship is being hit), keep track of the number of hits
	 * track the number of hits so Erik can inform the user when the ship has sunk
	 * */
	public void chooseCompLogic(int num) {
		if(num == 0) {
			if(potRow1 > 0 && potRow1 < 7) {
				printMessageAndReturnComp(potRow1,selCol);
				if(compships[potRow1][selCol].containsShip()) {
					// launch missiles in vertical positions
					isVertical = true;
				}
			}
			else {
				compLogicNum = 2;
			}
		}
		if(num == 1) {
			if(potCol1 > 0 && potCol1 < 7) {
				printMessageAndReturnComp(selRow,potCol1);
				if(compships[selRow][potCol1].containsShip()) {
					// launch missiles in vertical positions
					isVertical = false;
				}
			}
			else {
				compLogicNum = 3;
			}
		}
		if(num == 2) {
			if(potRow2 > 0 && potRow2 < 7) {
				printMessageAndReturnComp(potRow2,selCol);
				if(compships[potRow2][selCol].containsShip()) {
					// launch missiles in vertical positions
					isVertical = true;
				}
			}
			else {
				compLogicNum = 0;
			}
		}
		if(num == 3) {
			if(potCol2 > 0 && potCol2 < 7) {
				printMessageAndReturnComp(selRow,potCol2);
				if(compships[selRow][potCol2].containsShip()) {
					// launch missiles in vertical positions
					isVertical = false;
				}
			}
			else {
				compLogicNum = 1;
			}
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
		return this.userShips;
	}

	public int getCompShips() {
		return this.compShips;
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