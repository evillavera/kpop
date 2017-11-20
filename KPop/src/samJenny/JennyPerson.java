package samJenny;

import caveExplorer.CaveExplorer;
import caveExplorer.Inventory;

public class JennyPerson {

	private boolean active;
	private String item;
	private String description;
	private JennyRoom currentRoom;
	private String s;

	public JennyPerson() {
		active = true;
		item = "pen";
		description = "\nThere is a merchant here. Press 'e' if you want to interact.";
		this.currentRoom = null;
	}

	public String returnDescription() {
		return description;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		CaveExplorer.print("Annyeong! I am a merchant.");
		if(active) {
			CaveExplorer.print("If you want that signature you need a " + item + ". Press 'i' for more information, or say 'bye' to stop talking.");
			s = CaveExplorer.in.nextLine();
			while(!s.equalsIgnoreCase("bye") && !s.equalsIgnoreCase("i")) {
				CaveExplorer.print("You can only say 'i' or 'bye'.");
				s = CaveExplorer.in.nextLine();
			}
			if(s.equalsIgnoreCase("i")) {
				actI();
			}else if(s.equalsIgnoreCase("bye")) {
				CaveExplorer.print("BYE THEN");
			}
		}else
			CaveExplorer.print("I had a " + item + " before, but I ran out. Try again later!");
	}

	public void setPosition(int row, int col) {
		currentRoom = (JennyRoom) CaveExplorer.caves[row][col];
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
