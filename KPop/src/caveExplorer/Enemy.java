package caveExplorer;

public class Enemy extends NPC {
	private int hp;
	private boolean battling; 
	//fields relating to navigation
		private CaveRoom[][] floor;//where the npc roams
		private int currentRow;
		private int currentCol;
		private NPCRoom currentRoom;
		
		//fields relating to character
		private boolean active;
		private String activeDescription;
		private String inactiveDescription;
	public Enemy() {
		hp = 10;
		battling = false;
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is an enemy waiting to talk to you.";
		this.inactiveDescription = "The enemy you fought earlier is standing here";
		//to indicate the NPC doesn't have a position yet, use coordinates -1,-1
		this.currentCol = -1;
		this.currentRow = -1;
		this.currentRoom = null;
		this.active = true;
	}
	
	public void battle() {
		battling = true;
		CaveExplorer.print("Hi, I'm an Enemy!" + " Try to kill me by pressing b\nHP: " + hp );
		String s = CaveExplorer.in.nextLine();
		while(battling) {
			if(!s.equalsIgnoreCase("b")) {
				CaveExplorer.print("Hahaha you suck");
				s = CaveExplorer.in.nextLine();
			}
			else {
				hp = 0;
				CaveExplorer.print("HP :"+ hp + "\nAJHGJKSDFHJKLDFHKLAJSDH\nYou obtained 10 dollars after killing the enemy!");
				Inventory.updateMoney(10);
				battling = false;
				
			}
		}
		active = false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setPosition(int row, int col) {
		if(row>= 0 && row < floor.length && col >= 0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			//remove the enemy from current room
			if(currentRoom != null) {
				currentRoom.leaveEnemy();
			}
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom) floor[row][col];
			currentRoom.enterEnemy(this);
		}
	}
	
	public int[] calculateMovement() {
		int[] moves = new int[2];
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}, {0,0}};
		int rand = (int)(Math.random() *possibleMoves.length-1);
		
		moves[0] = possibleMoves[rand][0]+currentRow;
		moves[1] = possibleMoves[rand][1]+currentCol;
		
		while(currentRoom.getDoor(rand)== null || !(CaveExplorer.caves[moves[0]][moves[1]] instanceof NPCRoom) ) {
			rand = (int)(Math.random()*possibleMoves.length-1);
			moves[0] = possibleMoves[rand][0]+currentRow;
			moves[1] = possibleMoves[rand][1]+currentCol;
		}
		return moves;
	}
	
	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getActiveDescription() {
		return activeDescription;
	}
}
