package alexErikGame;

import caveExplorer.CaveExplorer;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	private int userShips = 3;
	private int compShips = 3;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[7][7];
		userShips = 3;
		compShips = 3;
		getGrid();
	}
	
<<<<<<< HEAD
	public int[] getCoordInput() {
		// TODO Auto-generated method stub
		return null;
	}
	// NOCKLES : "IN ORDER FOR BACKEND TO MEET THE REQUIREMENT FOR A 5, THE AI MUST BE SMART"
	// IF THE AI HITS A SHIP, IT MUST SELECT TO HIT ANOTHER SPACE NEAR THE SHIP
	// CHECK THE RUBRIC FOR ADDITIONAL INFORMATION
=======
	public AlexErikFleet[][] getFleet(){
		return ships;
	}
	

	public void sunk() {
		// TODO Auto-generated method stub
		
	}

>>>>>>> branch 'erikAlexBranch' of https://github.com/evillavera/kpop.git
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
	public AlexErikFleet[][] getFleet(){
		return ships;
	}
	
	public void computerTakesTurn() {
		
	}
	
	public boolean sunk() {
		
	}
	

<<<<<<< HEAD
	public boolean shipSink() {
		
	}
	
	public boolean shipHit() {
		
	}
	
	public int getPlayerShipsSunk() {
=======
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
>>>>>>> branch 'erikAlexBranch' of https://github.com/evillavera/kpop.git
		return 0;
	}
	
	public int getComputerShipsSunk() {
		return 0;
	}
	
	public boolean PlayerWon() {
		
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