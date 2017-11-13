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
	}

	public static void displayField(JennySamPlot[][] plot) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
					System.out.print(".");
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	}

}
