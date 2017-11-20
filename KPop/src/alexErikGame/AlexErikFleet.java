package alexErikGame;

public class AlexErikFleet {
	
	private int row;
	private int col;
	private boolean containsShip;
	private boolean isRevealed;
	
	//shortShip = 3;
	//longShip = 4;
	
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
	
	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}
	
}
