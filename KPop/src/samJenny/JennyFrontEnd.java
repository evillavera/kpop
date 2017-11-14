package samJenny;

public class JennyFrontEnd implements SamSupport {
	
	private static JennySupport backend;
	private static JennySamPlot[][] plots;

	public JennyFrontEnd() {
		backend = new SamBackEnd(this);
		plots = backend.getPlots();
	}

	public static void main(String[] args) {
		JennyFrontEnd demo = new JennyFrontEnd();
		displayField(plots);
		play();
	}

	private static void play() {
		while(backend.stillPlaying()){
	        displayField(plots);
	        displayScore();
	        int[] input = backend.getValidUserInput();
	        respondToInput(input);
	        
		}
		
	}

	private static void respondToInput(int[] input) {
		// TODO Auto-generated method stub
		
	}

	private static void displayScore() {
		// TODO Auto-generated method stub
		
	}

	public static void displayField(JennySamPlot[][] plot) {
		String rows = "0123";
		String columns = "   0  1  2  3  4";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()) {
					System.out.print("["+plots[row][col].getValue()+"]");
				}
				else {
					System.out.print("[ ]");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns);
	}

}
