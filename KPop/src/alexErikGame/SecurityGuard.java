package alexErikGame;

import caveExplorer.NPC;

public class SecurityGuard extends NPC{

	//fields relating to character
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public SecurityGuard() {
		this.activeDescription = "Stop right there!";
		this.inactiveDescription = "Hmmphh.";
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
}
