package samJenny;

public interface JennySupport {

	JennySamPlot[][] getPlots();

	boolean stillPlaying();

	int[] getValidUserInput();

	boolean isEqual(JennySamPlot[][] plots);

	void revealAdjacent(int[] input);

}
