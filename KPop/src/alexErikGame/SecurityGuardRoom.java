package alexErikGame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

public class SecurityGuardRoom extends NPCRoom {

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
	
	public String getDescription() {
		if(containsGuard()) {
			return "There is a guard blocking your path.";
		}
		return "The place where you defeated the guard.";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsGuard() && presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
	}	
}
