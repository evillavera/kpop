package alexErikGame;

public interface AlexSupport {
	void displayFleet(AlexErikFleet[][] ships);
	void displayShipsSunk(AlexErikFleet p);
	void displayHints();
	void displayResult();
	int getCompShips();
	int getUserShips();
}
