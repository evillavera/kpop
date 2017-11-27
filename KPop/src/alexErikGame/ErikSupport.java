package alexErikGame;

public interface ErikSupport {
	int getShipsSunk();
	boolean sunk();
	int[] getCoordInput();
	
	
	AlexErikFleet[][] getFleet();
	int getUserShips();
	int getCompShips();
	void computerTurn();
	void setCompShips(int i);
	AlexErikFleet[][] getCompFleet();
	AlexErikFleet[][] getCompBoard();
	void trackShipsHits(int[] lastCoords, int player);
	int[] getComputerCoords();
}
