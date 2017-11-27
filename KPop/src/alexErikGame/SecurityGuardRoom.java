package alexErikGame;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;

public class SecurityGuardRoom extends CaveRoom {

	private SecurityGuard presentNPC;
	
	public SecurityGuardRoom(String description) {
		super(description);
		presentNPC = null;
	}

	public boolean containsGuard() {
		return presentNPC == null;
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
			if(presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
	}

	public void enterPerson(SecurityGuard securityGuard) {
		presentNPC = securityGuard;
	}	
	
	/*
	 * public class IdolRoom extends CaveRoom {

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
	 */
	
	
}
