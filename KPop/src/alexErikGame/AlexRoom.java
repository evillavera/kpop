package alexErikGame;

import caveExplorer.CaveRoom;
import caveExplorer.Inventory;
import caveExplorer.CaveExplorer;

public class AlexRoom extends CaveRoom {

	private String[] trollResponse;
	private boolean active;

	public AlexRoom(String description) {
		super(description);
		String[] temp = {"Hoot Hoot, I'm an owl.", "Don't talk to me if you don't have food.", "Talk to me at night.", "Why are you even here????"}; 
		trollResponse = temp;
		active = true;
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
				+ "you can type 'o' to talk to the owl.");
	}

	public void performAction(int direction) {
		if(active) {
			if(direction == 4) {
				int count = 0;
				while(count < 5) {
					troll();
					count++;
				}
				CaveExplorer.print("Sorry for trolling you. Here is a piece of paper!");
				Inventory.setPaper(true);
				active = false;
			}
		}
		else {
			System.out.println("I already gave you a piece of paper. Go away!");
		}
	}

	public void troll() {
		int num = (int)(Math.random() * trollResponse.length);
		CaveExplorer.print(trollResponse[num]);
		CaveExplorer.in.nextLine();
	}

	public String getDescription() {
		return "Do you want to learn more about fun music and talk to an owl. Enter 'o' to do so.";
	}
}

