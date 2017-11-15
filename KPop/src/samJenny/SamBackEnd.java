package samJenny;

import caveExplorer.CaveRoom;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class SamBackEnd implements JennySupport {
	
	private SamSupport frontend;
	private JennySamPlot[][] plots;
	
	public SamBackEnd(SamSupport frontend) {
		this.frontend = frontend;
		plots = new JennySamPlot[4][5];
		createPlots();
	}

	public JennySamPlot[][] getPlots() {
		return plots;
	}

	@Override
	public boolean stillPlaying() {
		return true;
	}

	@Override
	public int[] getValidUserInput() {
		String input = CaveExplorer.in.nextLine();
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n          <row>,<col>"
					+ "\n<row> and <col> should be integers."
					+"\n They can also not exceed the limit.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
		}
		return coords;
	}
	
	public int[] toCoords(String input) {
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() ==3){
				int[] coords = {a, b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	public void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new JennySamPlot(row, col);
			}
		}
		//assigns random values to the plot
		String check = "00112233445566778899";
		while( check.length() > 0){
			int randRow = (int)(Math.random() * plots.length);
			int randCol = (int)(Math.random() * plots[randRow].length);
			int rand1 = (int)(Math.random()*check.length());
			if(!plots[randRow][randCol].containsValue()){
				plots[randRow][randCol].setContainsValue(true);
				plots[randRow][randCol].setValue(Integer.parseInt(check.substring(rand1, rand1+1)));
				if(check.length() == 1) {
					check = "";
				}
				else {
					check = check.substring(0, rand1) + check.substring(rand1+1) ;
				}
			}
		}
	}
	
	public boolean isEqual(JennySamPlot[][] a) {
		int value1 = -1;
		int value2 = -1;
		int[] coord1 = new int[2];
		int[] coord2 = new int[2];
		for(int row = 0; row < a.length; row++){
			for(int col = 0; col < a[row].length; col++){
				if((a[row][col].isRevealed() && value1 == -1) && !a[row][col].isFound()) {
					value1 = a[row][col].getValue();
					coord1[0] = row;
					coord1[1] = col;
				}
				else if((a[row][col].isRevealed() && value2 == -1) && !a[row][col].isFound()){
					value2 = a[row][col].getValue();
					coord2[0] = row;
					coord2[1] = col;
				}
			}
		}
		if(value1 == value2) {
			plots[coord1[0]][coord1[1]].setFound(true);
			plots[coord2[0]][coord2[1]].setFound(true);
		}
		return value1 == value2;
	}
	
	public void hide(JennySamPlot[][] a) {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				if(a[row][col].isRevealed() && !a[row][col].isFound()) {
					a[row][col].setRevealed(false);
				}
			}
		}
	}
}
