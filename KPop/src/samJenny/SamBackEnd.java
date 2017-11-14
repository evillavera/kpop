package samJenny;

import caveExplorer.CaveRoom;
import caveExplorer.CaveExplorer;

public class SamBackEnd implements JennySupport {
	
	private SamSupport frontend;
	private JennySamPlot[][] plots;

	public static void main(String[] args) {

	}
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getValidUserInput() {
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
	
	private void createPlots() {
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

}
