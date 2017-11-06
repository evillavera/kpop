package alexErikGame;

import java.util.Scanner;

import caveExplorer.CaveRoom;
import caveExplorer.CaveExplorer;

public class AlexRoom extends CaveRoom {
	
	public AlexRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public String getContents() {
			return "O";
			//return what would be returned otherwise
	}
	
	public String validKeys() {
		return "wdsao";
}

	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's' or 'd' to move or "
			+ "you can type 'o' to talk to the owl to learn more about k-pop.");
}

	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("K-pop artists are fun including Girls Generation"); 
		}
		else {
			CaveExplorer.print("That key does nothing.");
	}
}
	
	public String getDescription() {
		return "Do you want to learn more about fun music and talk to an owl. Enter o to do so.";
}
}

