package samJenny;

public class JennyPerson {

	private boolean active;
	String item;

	public JennyPerson() {
		active = true;
		item = "pen";
	}

	public void act() {
		CaveExplorer.print("Hi there! I am a merchant.");
		if(active) {
			CaveExplorer.print("I only have a " + item + " on me right now. Press 'i' for more information, or say 'bye' to stop talking.");
			String s = CaveExplorer.in.nextLine();
		}else
			CaveExplorer.print("I had a " + item + " before, but I ran out. Try again later!");
	}

}
