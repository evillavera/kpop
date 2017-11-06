package alexErikGame;

import java.util.Scanner;

public class AlexCaveRoom extends NPCRoom {
	
	//public static Scanner in;
	
	public static void main(String[] args){
		//in = new Scanner(System.in);
		

	     Scanner sc = new Scanner(System.in);
	     int i = sc.nextInt();
	}
	
	public AlexCaveRoom() {
		String response;
		int output;
		System.out.println("Please type in a number");
		response = in.nextLine();
		output = (parseInt(response)*2);
		//response = new Scanner(System.in);
		//response = in.nextLine();
	}
}
