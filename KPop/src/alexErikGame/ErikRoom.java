package alexErikGame;

public class ErikRoom extends  NPCRoom {

	private boolean visited = false;
	private NPC presentNPC;
	
	
	public ErikRoom(String description) {
		super(description);	
		presentNPC = null;
	}
	
	public String getDescription() {
		if(!visited) {
			visited = true;
			return "You are standing all the way in the back of the crowd. There is a person in front of you. Press 'e' to interact.";
		}else {
			return "This is the back of the concert.";
		}
	}
	
	
	
}
