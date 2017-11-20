package samJenny;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class IdolRoom extends CaveRoom {

	private Idol idol;

	public IdolRoom(String description) {
		super(description);
		idol = null;
	}
	
	public String getContents() {
		return "I";
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input 'W', 'A', 'S', 'D' to move or 'E' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			idol.interact();
		}
		else {
			super.performAction(direction);
		}
	}
	
	public String getDescription() {
		return super.getDescription() + "\n"+ idol.returnDescription();
	}

	public void enterPerson(Idol i) {
		idol = i;
	}
}
