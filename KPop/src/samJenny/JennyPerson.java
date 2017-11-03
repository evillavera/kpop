package samJenny;

public class JennyPerson {

	private boolean active;
	private String[] objects;
	
	public JennyPerson() {
		active = true;
		
		String[] temp = {"book", "pen", "piece of paper"};
		objects = temp;
		num = (int) (Math.random() * temp.length);
	}
	
	public void act() {
		CaveExplorer.print("Hi there! I am a merchant. I only have a " + item + "on me right now. Press 'i' for more information!");
		String s = CaveExplorer.in.nextLine();
	}

}
