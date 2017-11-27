package alexErikGame;

import caveExplorer.CaveExplorer;
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
	}

	public String returnDescription() {
		return description;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		if(active) {
			CaveExplorer.print("No one is allowed through, but if you beat me in battleship I will grant you access. Press 'q' if you want to fight.");
			s = CaveExplorer.in.nextLine();
			while(!(s.equals("q"))) {
				CaveExplorer.print("I'm sorry, but your only option is to fight me. Press 'q' to fight.");
				s = CaveExplorer.in.nextLine();
			}
			//playGame
			CaveExplorer.print("Let's fight!");
		}else
			CaveExplorer.print("You beat me!");
	}

	public void setPosition(int row, int col) {
		currentRoom = (SecurityGuardRoom) CaveExplorer.caves[row][col];
		currentRoom.enterPerson(this);
	}

	public void actI() {
		CaveExplorer.print("This is special " + item + ".");
		CaveExplorer.print("If you want to purchase this item, say 'p'");
		s = CaveExplorer.in.nextLine();
		if(s.equalsIgnoreCase("p")) {
			actP();
		}
		else
			CaveExplorer.print("Hm, seems like you don't want this item. Bye then.");

	}

	public void actP() {
		if(Inventory.getMoney() < 10) {
			CaveExplorer.print("You do not have enough money to purchase this item.\nPlease come back when you have at least 10 dollars!");
		}else {
			CaveExplorer.print("I took 10 dollars from you. Thank you. Have a nice day!");
			Inventory.updateMoney(-10); 
			Inventory.setPen(true);
			active = false;
		}

	}
}

