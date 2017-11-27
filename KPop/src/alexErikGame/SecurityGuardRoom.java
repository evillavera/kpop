package alexErikGame;

import caveExplorer.CaveRoom;
import caveExplorer.CaveExplorer;

public class SecurityGuardRoom extends CaveRoom {

	private SecurityGuard person;
	
	public SecurityGuardRoom(String description) {
		super(description);
	}

	public boolean containsGuard() {
		return person == null;
	}

	public String getContents() {
		return "S";
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public String getDescription() {
		if(containsGuard()) {
			return "There is a guard blocking your path.";
		}
		return "The place where you defeated the guard.";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(person.isActive()) {
				person.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
	}

	public void enterPerson(SecurityGuard securityGuard) {
		person = securityGuard;
	}	
	
	/*
	 *package samJenny;

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

	 */
	
	
}
