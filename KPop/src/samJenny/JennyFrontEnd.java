package samJenny;

public class JennyFrontEnd implements SamSupport {
	
	private static JennySupport backend;

	public JennyFrontEnd() {
		backend = new SamBackEnd(this);
	}

	public static void main(String[] args) {
		JennyFrontEnd demo = new JennyFrontEnd();
		JennySamPlot[][] plots = backend.getPlots();
		displayField(plots);
	}

	public static void displayField(JennySamPlot[][] plot) {
		String rows = "0123456789";
		String columns = "  0123456789";
	}

	public void play() {
		
	}

}
