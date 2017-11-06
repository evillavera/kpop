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
				CaveExplorer.print("You are now stuck in a crowd of people!\nTo get out try every key");
				String s = CaveExplorer.in.nextLine();
				while(!s.equalsIgnoreCase("l")) {
					CaveExplorer.print("That won't work try again.");
					s = CaveExplorer.in.nextLine();
				}
				CaveExplorer.print("You manage to find a hole in the crowd.\n*You have been freed*");
				this.active = false;
				
		}
		else {
			CaveExplorer.print("That key does nothing.");
		}
		
	}
	
	public String getDescription() {
		if(active) {
			return super.getDescription() + "\nPress e for a shortcut";
		}
		else {
			return super.getDescription() + "\nThis is where you got stuck";
		}
	}
	
	public String getContents() {
		return "*";
	}
	
}
