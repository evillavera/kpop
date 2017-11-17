package alexErikGame;

public interface ErikSupport {
	int getShipsSunk();
	boolean sunk();
	int[] getCoordInput();
	
	
	AlexErikFleet[][] getFleet();
	int getUserShips();
	int getCompShips();
}
