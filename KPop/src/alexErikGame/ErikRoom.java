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
			return "You are in the back of the crowd. Between all the heads you can spot them, your idols. "
					+ "You notice a note on the floor.\nPress SpaceBar to read it.";
		}else {
			return "The back of the concert. Where you found the note. Press SpaceBar if you want to read it.";
		}
	}
	
	public String getContents() {
		return "N";
	}
	
	public String validKeys() {
		return "wdsa ";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only input W A S D to move or SpaceBar to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
				System.err.println("The note on the floor says that you will go through many challenges today.\n"
						+ " To help you succeed remember, 9,9 and Nockles always knows the answer.");
			}else {
			printAllowedEntry();
		}
	}
}	
