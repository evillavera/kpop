package caveExplorer;

import java.util.Scanner;

import alexErikGame.SecurityGuard;
import samJenny.JennyPerson;
import samJenny.JennyRoom;
import samJenny.SamRoom;

public class CaveExplorer {

	public static CaveRoom[][]caves; //every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on how the user navigated 
	public static Inventory inventory;// where all objects found in cave are kept
	public static boolean playing = true;
	public static NPC[] npcs;
	public static JennyPerson[] jenny;
	public static SecurityGuard[] erik;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory(); 
		
		
		startExploring();
	}

	private static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	
	public static void initScanner(){
		in = new Scanner(System.in);
	}

	private static void npcActions() {
		for(NPC n: npcs) {
			n.act();
		}
		inventory.updateMap();
	}

	public static void print(String s) {
		//NOTE: later, you can replace this line with the more sophisticated "multiLinePrint" function from ChatBot
		System.out.println(s);
	}
}
