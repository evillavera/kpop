package samJenny;

public class SamBackEnd implements JennySupport {
	
	private SamSupport frontend;
	private JennySamPlot[][] plots;

	public static void main(String[] args) {

	}
	
	public SamBackEnd(SamSupport frontend) {
		this.frontend = frontend;
		plots = new JennySamPlot[4][5];
	}

	public JennySamPlot[][] getPlots() {
		return plots;
	}


}
