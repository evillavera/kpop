package alexErikGame;

public class AlexErikFleet {
	
	private int row;
	private int col;
	private int shortShip = 3;
	private int longShip = 4;
	private boolean isRevealed;
	private boolean containsShip;
	private String miss = "o";
	private String hit = "x";
	private String sunk = "X";
	private String ship = "+";
	
	public AlexErikFleet(int row, int col) {
		isRevealed = false;
		containsShip = false;
		this.row = row;
		this.col = col;
	}

	public boolean containsShip() {
		return containsShip;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void reveal(){
		isRevealed = true;
	}

	public boolean isRevealed() {
		return isRevealed;
	}

	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}

}
