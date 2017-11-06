package alexErikGame;

public class ErikRoom extends CaveRoom{

	private boolean visited;
	
	public ErikRoom(String description) {
		super(description);
		visited = false;
	}

	public String getDescription() {
		if(!visited) {
			visited = true;
			return "You are in the back of the crowd. Between all the heads you can spot them, your idols.";
		}else {
			return "Where you started, all the way in the back.";
		}
	}
}
