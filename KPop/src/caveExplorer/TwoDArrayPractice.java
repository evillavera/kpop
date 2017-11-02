package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length;row++) {
			for(int col = 0; col < pic[row].length; col++) {
				pic[row][col] = " ";
			}
		}
//		drawHorizontalLine(pic,1);
//		drawHorizontalLine(pic,3);
//		drawHorizontalLine(pic,5);
//		drawVerticalLine(pic, 2);
//		drawSlot(pic,4,5);
		drawBox(pic,0,0);
		drawBox(pic,4,5);
		print(pic);
	}

	/**
	 * Box looks like this
	 * 		___
	 * 		|*|
	 * 		|_|
	 * 
	 * but the * marks the coordinates of the box
	 * CATCH: No ArrayIndexOutOfBoundsException
	 * but draw any portion of the box that does fit on the "canvas"
	 * @param pic
	 * @param i
	 * @param j
	 */
	
	
	private static void drawBox(String[][] pic, int i, int j) {
		//DOESNT WORK
		//TOP PART
//		if(i-1 >= 0) {
//			if(j > 0 && j < pic[0].length-1) {
//				//TOP PART
//				pic[i-1][j-1] = "_";
//				pic[i-1][j] = "_";
//				pic[i-1][j+1] = "_";
//			}
//		}
//		if(i < pic.length-1)  {
//			//STAR
//			pic[i][j-1] = "|";
//			pic[i][j+1] = "|";
//		}
//		if(i < pic.length-2) {
//			//3rd Row
//			pic[i+1][j-1] = "|";
//			pic[i+1][j] = "_";
//			pic[i+1][j+1] = "|";
//		}
		
		drawSlot(pic, i ,j);
		drawSlot(pic, i+1,j);
		drawIfInBounds("_",pic,i+1,j);
		for(int col = j -1; col <= j+1; col++) {
			drawIfInBounds("_",pic, i-1,col);
		}
	}

	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		// First part checks if i (the row) exists
		//ALWAYS CHECK ROW BEFORE COLUMN
		//IOW, check row exists before checking if a column exists in the row
		if(i >= 0 && i < pic.length && j >= 0 && j < pic[i].length) {
			pic[i][j] = string;
		}
		
	}

	/**
	 * A slot looks like this:
	 * 		| |
	 * It is two vertical lines with a space between them
	 * The coordinates, i,j are the coordinates of the space
	 * In other words, a slot is a vertical line in front of i,j after the i,j
	 * CATCH: No ArrayIndexOutOfBoundExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		if(j > 0){
			pic[i][j-1] = "|";
		}
		if(j < pic[i].length -1){
			pic[i][j+1] = "|";
		}

		/**if(j - 1 >= 0 && j + 1 <= pic[0].length-1) {
			pic[i][j-1] = "|";
			pic[i][j+1] = "|";
		}
		 */


	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}

	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}

	}

	/**
	 * prints contents of pics, row by row
	 * NO BRACKETS OR COMMAS
	 * @param pic
	 */
	private static void print(String[][] pic) {
		String output = "";
		for(int row = 0; row < pic.length;row++) {
			for(int col = 0; col < pic[row].length; col++) {
				output += pic[row][col];
			}
			output += "\n";
		}
		System.out.println(output);
	}

}
