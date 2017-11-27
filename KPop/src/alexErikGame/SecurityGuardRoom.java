package alexErikGame;

import caveExplorer.CaveRoom;
import caveExplorer.CaveExplorer;

public class SecurityGuardRoom extends CaveRoom {
	
	private SecurityGuard person;

	public SecurityGuardRoom(String description) {
		super(description);
	}

	public String getContents() {
		return "S";
	}

	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input 'W', 'A', 'S', 'D' to move or 'E' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			person.interact();
		}
		else {
			super.performAction(direction);
		}
	}
	
	public String getDescription() {
		return super.getDescription() + "\n"+ person.returnDescription();
	}

	public void enterPerson(SecurityGuard p) {
		person = p;
	} 
}
