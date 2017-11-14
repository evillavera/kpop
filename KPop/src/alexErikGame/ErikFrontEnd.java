package alexErikGame;

public class ErikFrontEnd implements AlexSupport{

	private ErikSupport backend;
	private int ships;
	private String message;
	
	public static void main(String[] args) {
		ErikFrontEnd game = new ErikFrontEnd();
		game.play();
	}
	
	public ErikFrontEnd() {
			backend = new AlexBackEnd(this);
			ships = 3;
			message = "";
	}
	
	private void startGame() {
		AlexErikFleet[][] ships = backend.getFleet();
		AlexErikFleet p = null;
		while(userShips > 0 && compShips > 0) {
			displayFleet(ships);
			displayShipsSunk(p);
			displayHints();
			System.out.println("Where do you want to shoot?");
			int[] coords = backend.getCoordInput();
			
			userships = getUserShips();
			compShips = getCompShips();
			
		//	p = ships[coords[0]][coords[1]];
		}
		displayResult();
		System.out.println("GAME OVER\n");
	}
}
