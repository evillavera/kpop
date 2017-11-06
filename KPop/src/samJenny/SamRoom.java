package samJenny;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class SamRoom extends CaveRoom {

	private String validKeys;
	private boolean active;
	
	public SamRoom(String description) {
		super(description);
		validKeys = "wdsae";
		active = true;
	}

	public String validKeys() {
		return validKeys;
	}
	
	public void performAction(int direction) {
		if(direction == 4 && active) {
				CaveExplorer.print("You are now stuck in this room MUAHAHAHAHAHAHA!\nTo get out try every key");
				String s = CaveExplorer.in.nextLine();
				while(!s.equalsIgnoreCase("l")) {
					CaveExplorer.print("HAHAHHAHAHAHA YOU IDIOT");
					s = CaveExplorer.in.nextLine();
				}
				CaveExplorer.print("WHAT IMPOSSIBLE\n*You have been freed*");
				this.active = false;
				
		}
		else {
			CaveExplorer.print("That key does nothing.");
		}
		
	}
	
	public String getDescription() {
		if(active) {
			return super.getDescription() + "\nPress e for gifts";
		}
		else {
			return super.getDescription() + "\nThis is the room with the fake free gifts";
		}
	}
	
	public String getContents() {
		return "*";
	}
	
}
