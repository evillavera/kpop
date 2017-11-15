package samJenny;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class JennyFrontEnd implements SamSupport {

	private static JennySupport backend;
	private static JennySamPlot[][] plots;
	private static int response;

	public JennyFrontEnd() {
		backend = new SamBackEnd(this);
		plots = backend.getPlots();
		response = 0;
	}

	public static void main(String[] args) {
		CaveExplorer.in = new Scanner(System.in);
		JennyFrontEnd demo = new JennyFrontEnd();
		play();
	}

	public static void play() {
		while(backend.stillPlaying()){
			displayField(plots);
			displayScore();
			int[] input = backend.getValidUserInput();
			respondToInput(input);
		}

	}

	public static void respondToInput(int[] input) {
		response++;
		plots[input[0]][input[1]].setRevealed(true);
		if(response%2 == 0) {
			//second response
			if(!backend.isEqual(plots)) {
				displayField(plots);
				CaveExplorer.print("Your cards did not match.");
				backend.hide(plots);
			}else
				CaveExplorer.print("ITS A MATCH!");
		}else {
			CaveExplorer.print("Please input your next coordinates.");
		}
	}

	public static void displayScore() {
		
	}

	public static void displayField(JennySamPlot[][] plot) {
		String rows = "0123";
		String columns = "   0  1  2  3  4";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row + 1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()) {
					System.out.print("["+ plots[row][col].getValue() + "]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns);
	}

}
