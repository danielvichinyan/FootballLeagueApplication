package org.com1028.dv00139.footbll_classes;

/** 
 * Defines the properties and behavior of a football player
 *  
 * @author Daniel Vichinyan 
 */ 
public class FootballPlayer {
	private String firstName = null;
	private String lastName = null;
	private FootballTeam playerTeam = null;
	private int numberOfJersey = 0;
	private PositionType position = null;
	
	 /** 
	   * Constructor. Sets the field values. 
	   *  
	   * @param firstName
	   * @param lastName
	   * @param playerTeam
	   * @param numberOfJersey
	   * @param position
	   */ 
	public FootballPlayer(String firstName, String lastName, FootballTeam playerTeam, int numberOfJersey, PositionType position) throws IllegalArgumentException {
		super();
		if(Character.isLowerCase(firstName.charAt(0)) || Character.isLowerCase(lastName.charAt(0))) {
			throw new IllegalArgumentException("Name and surname should start with an uppercase letter!");
		}
		if(numberOfJersey <= 0 || numberOfJersey > 99) {
			throw new IllegalArgumentException("Number of player's jersey should be between 1 and 99!");
		}
		if(firstName == null || lastName == null) {
			throw new NullPointerException("Invalid name of player!");
		}
		if(playerTeam == null) {
			throw new NullPointerException("Invalid team!");
		}
		if(position == null) {
			throw new NullPointerException("Invalid position!");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerTeam = playerTeam;
		this.numberOfJersey = numberOfJersey;
		this.position = position;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getNumberOfJersey() {
		return this.numberOfJersey;
	}

	public String getPosition() {
		return this.position.getPositionName();
	}
	
	public FootballTeam getPlayerTeam() {
		return this.playerTeam;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " - " + playerTeam + ", Number: " + numberOfJersey + ", Position:" + position;
	}
	
	
}
