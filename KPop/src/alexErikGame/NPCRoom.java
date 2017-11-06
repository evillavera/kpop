package alexErikGame; 

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;
	private Enemy presentEnemy;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
		presentEnemy = null;
	}

	/**
	 * NPCs can enter room if no other NPC is in the room
	 * @return
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
	 * There is already a method like this
	 * but it is helpful the other way for referring to it
	 * especially if it is to change the rules of "canEnter"
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	//the above methods are new features to a caveroom
	//the methods below replace CaveRoom methods(override)
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D to move or E to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsEnemy() && presentEnemy.isActive()) {
				presentEnemy.battle();
			}
			else if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}
			else {
				CaveExplorer.print("There is nothing to interact with.");
			}
		}
		else {
			CaveExplorer.print("That key does nothing.");
		}
		
	}
	
	private boolean containsEnemy() {
		return presentEnemy != null;
	}
	public void enterEnemy(Enemy m) {
		presentEnemy = m;
	}
	
	public void leaveEnemy() {
		presentEnemy = null;
	}

	public String getContents() {
		if(containsEnemy() && presentEnemy.isActive()) {
			return "E";
		}
		else if(containsNPC()&& presentNPC.isActive()) {
			return "M";
		}
		else {
			return  super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsEnemy() && !presentEnemy.isActive()) {
			return super.getDescription() + "\n"+presentNPC.getInactiveDescription();
		}
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n"+presentNPC.getInactiveDescription();
		}
		else {
			String npcDesc = "";
			if(presentNPC!= null) {
				npcDesc = presentNPC.getActiveDescription();
			}
			return super.getDescription() + "\n"+npcDesc;
		}
	}
}

