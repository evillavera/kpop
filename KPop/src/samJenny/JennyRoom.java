package samJenny;

public class JennyRoom extends CaveRoom {
	
	private JennyPerson person;

	public JennyRoom(String description) {
		super(description);
	}
	
	public void enterPerson(JennyPerson j) {
		person = j;
	}
}
