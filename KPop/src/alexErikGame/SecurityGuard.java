package alexErikGame;

import caveExplorer.NPC;
import caveExplorer.NPCRoom;
import caveExplorer.CaveExplorer;


public class SecurityGuard extends NPC{

	//fields relating to character
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	private SecurityGuardRoom currentRoom;
	
	public SecurityGuard() {
		this.active = true;
		this.activeDescription = "Stop right there!";
		this.inactiveDescription = "Hmmphh.";
		this.currentRoom = null;
	}

	public boolean isActive() {
		return active;
	}
	
	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getActiveDescription() {
		return activeDescription;
	}
	
	public void interact() {
		if(active) {
			//play game
		}
		System.out.println(activeDescription);
	}
	
	public void setPosition(int row, int col) {
		currentRoom = (SecurityGuardRoom) CaveExplorer.caves[row][col];
		currentRoom.enterPerson(this);
	}
	
}
/*
 * 
	
	private boolean active;
	private String description;
	private IdolRoom currentRoom;

	public Idol() {
		active = true;
		description = "\nYour favorite idol is here omg. \nPress 'e' to talk to them.";
		this.currentRoom = null;
	}

	public String returnDescription() {
		return description;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		if(active) {
			if(Inventory.isPaper() && Inventory.isPen()) {
				CaveExplorer.print("Here is your signature!! :)");
				CaveExplorer.setPlaying(false);
			}else {
				CaveExplorer.print("I would love to give you a signature, but you don't seem to have all the materials...");
			}
		}
	}

	public void setPosition(int row, int col) {
		currentRoom = (IdolRoom) CaveExplorer.caves[row][col];
		currentRoom.enterPerson(this);
	}

}





 */