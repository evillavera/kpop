package alexErikGame;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class AlexCaveRoom extends CaveRoom {
	/*
	public static Scanner in;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		
	     Scanner sc = new Scanner(System.in);
	     int i = sc.nextInt();
	}*/
	
	
	public AlexCaveRoom(String description) {
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
			CaveExplorer.print("Talk to the owl to learn about k-pop.");
		}
		else {
			CaveExplorer.print("That key does nothing.");
	}
}

}
