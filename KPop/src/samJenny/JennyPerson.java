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
			while(!s.equalsIgnoreCase("bye") || !s.equalsIgnoreCase("i")) {
				CaveExplorer.print("You can only say 'i' or 'bye'");
				s = CaveExplorer.in.nextLine();
			}
			if(s.equalsIgnoreCase("i")) {
				CaveExplorer.print("This is just a regular " + item + ".");
				CaveExplorer.print("Say 'p' if you want to purchase this item.");
				s = CaveExplorer.in.nextLine();
				if(s.equalsIgnoreCase("p")) {
					CaveExplorer.print("I took 10 dollars from you. Thank you. Have a nice day!");
					active = false;
				}
				else
					CaveExplorer.print("Hm, seems like you don't want this item. Bye then.");
			}else if(s.equalsIgnoreCase("bye")) {
				CaveExplorer.print("BYE THEN");
			}
		}else
			CaveExplorer.print("I had a " + item + " before, but I ran out. Try again later!");
	}

}
