package alexErikGame;

public interface ErikSupport {
	void shipShape();
	int getShipsSunk();
	void sunk();
	void placeMarker();
	int[] getCoordInput();
	
	
	AlexErikFleet[][] getFleet();
}
