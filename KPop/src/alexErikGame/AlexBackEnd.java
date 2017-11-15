package alexErikGame;

public class AlexBackEnd implements ErikSupport {
	
	private AlexSupport frontend;
	private AlexErikFleet[][] ships;
	private int shipsSunk;
	
	public AlexBackEnd(AlexSupport frontend) {
		this.frontend = frontend;
		ships = new AlexErikFleet[6][6];
	}
	
	public void shipShape() {
		// TODO Auto-generated method stub
		
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}

	public void sunk() {
		// TODO Auto-generated method stub
		
	}

	public void placeMarker() {
		// TODO Auto-generated method stub
		
	}

	public int[] getCoordInput() {
		// TODO Auto-generated method stub
		return null;
	}

	public AlexErikFleet[][] getFleet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void checkUserInput() {
		// this method should only be used while the user is typing coordinates
		
	}
	
}