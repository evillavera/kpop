package samJenny;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class JennyFrontEnd implements SamSupport {

	private static JennySupport backend;
	private static JennySamPlot[][] plots;
	private static int response;
	private static int score;

	public JennyFrontEnd() {
		backend = new SamBackEnd(this);
		plots = backend.getPlots();
		response = 0;
		score = 0;
	}

	public static void main(String[] args) {
		CaveExplorer.in = new Scanner(System.in);
		JennyFrontEnd demo = new JennyFrontEnd();
		play();
	}

	public static void play() {
		CaveExplorer.print("Try to find all the matches!\nWhen you flip one card, the cards around it will also be flipped. :)");
		while(backend.stillPlaying()){
			displayField(plots);
			displayScore();
			int[] input = backend.getValidUserInput();
			respondToInput(input);
		}
		displayField(plots);
		displayScore();
		CaveExplorer.print("WOW YOU WON!");

	}

	public static void respondToInput(int[] input) {
		if(input == null) {
			setScore(10);
		}
		else {
			response++;
			plots[input[0]][input[1]].setRevealed(true);
			plots[input[0]][input[1]].setSelected(true);
			backend.revealAdjacent(input);
			if(response%2 == 0) {
				second();
			}else {
				CaveExplorer.print("Please input your next coordinates.");
			}
		}
	}

	public static void second() {
		//second response
		displayField(plots);
		if(!backend.isEqual(plots)) {
			CaveExplorer.print("Your cards did not match.");
			hide(plots);
		}else
			CaveExplorer.print("ITS A MATCH!");
		hide(plots);

	}

	public static void displayScore() {
		CaveExplorer.print("You have " + score + " matches." );
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
	
	public static void hide(JennySamPlot[][] a) {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				if(a[row][col].isRevealed() && !a[row][col].isFound()) {
					a[row][col].setRevealed(false);
					a[row][col].setSelected(false);
				}
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void addScore() {
		score++;
	}

	public static void setScore(int i) {
		score = i;
	}

}
