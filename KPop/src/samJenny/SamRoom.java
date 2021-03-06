package samJenny;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class SamRoom extends CaveRoom {

	private String validKeys;
	private boolean active;
	private int fail;

	public SamRoom(String description) {
		super(description);
		validKeys = "wdsae";
		active = true;
		fail = 0;
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
				fail++;
				if(fail >=5) {
					move(6,3);
					break;
				}
				s = CaveExplorer.in.nextLine();
			}
			if(CaveExplorer.currentRoom == CaveExplorer.caves[6][3]){
				CaveExplorer.print("The wave of fans pushed you back!");
			}
			else {
				CaveExplorer.print("You manage to find a hole in the crowd.\n*You have been freed*");
				move(2,3);
				this.active = false;
			}
		}
		else {
			super.performAction(direction);
		}

	}

	public void move(int a, int b) {
		CaveExplorer.currentRoom.leave();
		CaveExplorer.currentRoom = CaveExplorer.caves[a][b];
		CaveExplorer.currentRoom.enter();
		CaveExplorer.inventory.updateMap();
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
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's', 'd' or 'e'.");
	}

}
