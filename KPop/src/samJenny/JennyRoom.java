package samJenny;

import caveExplorer.CaveRoom;
import caveExplorer.CaveExplorer;

public class JennyRoom extends CaveRoom {
	
	private JennyPerson person;

	public JennyRoom(String description) {
		super(description);
	}

	public String getContents() {
		return "J";
	}

	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D to move or E to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			person.interact();
		}
		else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public String getDescription() {
		return super.getDescription() + "\n"+ person.returnDescription();
	}

	public void enterPerson(JennyPerson p) {
		person = p;
	} 
}
