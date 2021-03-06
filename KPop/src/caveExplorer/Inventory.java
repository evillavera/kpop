package caveExplorer;

public class Inventory {

	private String map;
	private static int money;
	private static boolean pen;
	private static boolean paper;
	private static int hp;
	
	public Inventory() {
		pen = false;
		paper = false;
		hp = 100;
		updateMap();
		updateMoney(0);
	}
	
	public static int getHp() {
		return hp;
	}

	public static void updateHp(int num) {
		hp += num;
	}
	
	public static boolean isPen() {
		return pen;
	}

	public static void setPen(boolean p) {
		pen = p;
	}

	public static boolean isPaper() {
		return paper;
	}

	public static void setPaper(boolean p) {
		paper = p;
	}

	public static int getMoney() {
		return money;
	}

	public static void updateMoney(int mula) {
		money = money + mula;
	}

	public void updateMap() {
		map = " ";
		//create line across top:
		for(int i = 0; i < CaveExplorer.caves[0].length -1; i++) {
			map += "____"; //4 underscores
		}
		map += "___\n"; //3 underscores, makes the corner look symmetrical
		for(CaveRoom[] row : CaveExplorer.caves) {
			//3 rows of text
			for(int i = 0; i < 3;i++) {
				String text = "";
				for(CaveRoom cr : row) {
					//if door is open, leave open
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()) {
						text += " ";
					}else {
						text += "|";
					}
					//contents of room depend on what row this is
					if(i == 0) {
						text += "   "; //3 spaces
					}else if(i ==1) {
						text += " "+cr.getContents()+" ";
					}else if(i == 2) {
						//draw space if door to south is open
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text += "   ";//3 spaces
						}else {
							text += "___";//3 underscores
						}
					}
				}//last caveroom in row
				text += "|";
				map += text + "\n";
			}
		}
	}

	public String getDescription() {
		return map + "\nYou have " + money + " dollars." + "\nYour health: " + hp;
//		return "You have nothing in your inventory.";
	}

}
