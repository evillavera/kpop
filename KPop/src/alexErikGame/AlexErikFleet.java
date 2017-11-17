package alexErikGame;

public class AlexErikFleet {
	
	private int row;
	private int col;
	private int shortShip = 3;
	private int longShip = 4;
	private boolean isRevealed;
	private boolean isMiss;
	private boolean containsShip;
	
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

	public boolean isMiss() {
		return isMiss;
	}

	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}

	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

	public void setContainsShip(boolean containsShip) {
		this.containsShip = containsShip;
	}
	
}
