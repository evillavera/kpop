package alexErikGame;

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}

	/**8
	 * NPCs can enter a room if no other NPC is there
	 */
	
	public boolean canEnter() {
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	
	public void leaveNPC() {
		presentNPC = null;
	}
	
	/**
	 * there is already a method like this, but to me it is 
	 * helpful to have this other way of referring to it,
	 * ESPECIALLY if I decide to change the rules of "canEnter"
	 * 
	 * distinct methods- canEnter and containNPC
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}
		
	//The above methods are NEW features to a CaveRoom 
	//the methods below REPLACE CaveRoom methods (override)
	
	//e is there as an action key
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's' or 'd' to move or"
				+ "you can type 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with right now.");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "N";
		}else {
			//return what would be returned otherwise
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n" +presentNPC.getInactiveDescription();
		}else {
			String npcDesc = "";
			if(presentNPC != null) {
				npcDesc = presentNPC.getActiveDescription();
			}
			return super.getDescription() + "\n"+ npcDesc;
		}
	}
	
	
	
	
	
	
}
