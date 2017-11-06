package alexErikGame;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class ErikRoom extends CaveRoom{

	private boolean visited;
	
	public ErikRoom(String description) {
		super(description);
		visited = false;
	}

	public String getDescription() {
		if(!visited) {
			visited = true;
			return "You are in the back of the crowd. Between all the heads you can spot them, your idols."
					+ "You notice a note on the floor.\n Press SpaceBar to read it.";
		}else {
			return "The back of the concert. Where you found the note. Press SpaceBar if you want to read it again.";
		}
	}
	
	public String getContents() {
		return "E";
	}
	
	public String validKeys() {
		return "wdsa ";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D to move or SpaceBar to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
				CaveExplorer.print("The note on the floor says that there are 3 items to collect.");
			}else {
			printAllowedEntry();
		}
	}
}	
