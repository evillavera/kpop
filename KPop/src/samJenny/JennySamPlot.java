package samJenny;

public class JennySamPlot {
	private int row;
	private int col;
	private boolean isRevealed;
	private int value;
	private boolean containsValue;
	
	public JennySamPlot(int row, int col) {
		this.row = row;
		this.col = col;
		this.containsValue = false;
		this.isRevealed = true;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean containsValue() {
		return containsValue;
	}

	public void setContainsValue(boolean b) {
		containsValue = b;
		
	}

	public boolean isRevealed() {
		return isRevealed;
	}

	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}
	
}
