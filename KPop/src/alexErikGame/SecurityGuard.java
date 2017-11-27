package alexErikGame;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class SecurityGuard {

	private boolean active;
	private String description;
	private SecurityGuardRoom currentRoom;
	private String s;
	private ErikFrontEnd game;

	public SecurityGuard() {
		active = true;
		description = "\nThere is a big security guard in your way. Press 'e' to talk to him.";
		this.currentRoom = null;
		game = new ErikFrontEnd();
	}

	public String returnDescription() {
		return description;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		while(active && !(game.isWin())) {
			CaveExplorer.print("No one is allowed through, but if you beat me in battleship I will grant you access. Press 'q' if you want to fight.");
			s = CaveExplorer.in.nextLine();
			while(!(s.equals("q"))) {
				CaveExplorer.print("I'm sorry, but your only option is to fight me. Press 'q' to fight.");
				s = CaveExplorer.in.nextLine();
			}
			CaveExplorer.print("Let's fight!");
			game.directions();
			if(game.isWin()) {
				CaveRoom.openPassage();
			}
		}
			CaveExplorer.print("You beat me!\n"
					+ "I open the door North. Go on kiddo.");
	}

	public void setPosition(int row, int col) {
		currentRoom = (SecurityGuardRoom) CaveExplorer.caves[row][col];
		currentRoom.enterPerson(this);
	}

	
}

