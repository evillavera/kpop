package alexErikGame;

public interface AlexSupport {
	void displayShipsSunk(AlexErikFleet p);
	void displayHints();
	void displayResult();
	int getCompShips();
	int getUserShips();
	AlexErikFleet[][] getCompBoard();
	void setCompBoard(AlexErikFleet[][] compships);
}
