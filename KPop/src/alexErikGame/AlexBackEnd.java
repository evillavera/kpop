package alexErikGame;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[7][7];
	}
	
	public void shipShape() {
		// TODO Auto-generated method stub
		
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
}