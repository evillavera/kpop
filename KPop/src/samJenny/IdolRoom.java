package samJenny;

import caveExplorer.NPCRoom;
import caveExplorer.NPC;

public class IdolRoom extends NPCRoom {

	private NPC presentIdol;

	public IdolRoom(String description) {
		super(description);
		presentIdol = null;
	}
	
	public String getContents() {
		if(containsNPC()&& presentIdol.isActive()) {
			return "M";
		}
		else {
			return  super.getContents();
		}
	}
	

}
