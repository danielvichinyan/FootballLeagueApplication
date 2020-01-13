package org.com1028.dv00139.footbll_classes;

import java.util.ArrayList;

/** 
 * Defines the properties and behavior of a football team
 *  
 * @author Daniel Vichinyan 
 */ 
public class FootballTeam {
	private String teamName = null;
	private int matchesWon = 0;
	private int matchesLost = 0;
	private int matchesDrawn = 0;
	private int matchesPlayed = 0;
	private int teamPoints = 0;
	private int goalsScored = 0;
	private int receivedGoals = 0;

	private ArrayList<FootballPlayer> players = null;

	 /** 
	   * Constructor. Sets the field values. 
	   *  
	   * @param teamName
	   */ 
	public FootballTeam(String teamName) throws IllegalArgumentException {
		super();
		if (teamName.length() == 0 || Character.isLowerCase(teamName.charAt(0))) {
			throw new IllegalArgumentException("Team name must start with a capital letter!");
		}
		this.teamName = teamName;
		this.matchesWon = 0;
		this.matchesLost = 0;
		this.matchesDrawn = 0;
		this.matchesPlayed = 0;
		this.teamPoints = 0;
		this.goalsScored = 0;
		this.receivedGoals = 0;
		this.players = new ArrayList<FootballPlayer>();
	}

	public String getTeamName() {
		return this.teamName;
	}

	public int getMatchesWon() {
		return this.matchesWon;
	}

	public int getMatchesLost() {
		return this.matchesLost;
	}

	public int getMatchesDrawn() {
		return this.matchesDrawn;
	}

	public int getMatchesPlayed() {
		return this.matchesPlayed;
	}

	public int getTeamPoints() {
		return this.teamPoints;
	}

	public int getGoalsScored() {
		return this.goalsScored;
	}

	public int getReceivedGoals() {
		return this.receivedGoals;
	}

	public void addGoalsScored(int goalsScored) {
		this.goalsScored += goalsScored;
	}

	public void addReceivedGoals(int receivedGoals) {
		this.receivedGoals += receivedGoals;
	}

	public void incMatchesWon() {
		this.matchesWon++;
	}

	public void incMatchesLost() {
		this.matchesLost++;
	}
	
	public void incMatchesDrawn() {
		this.matchesDrawn++;
	}

	public void incMatchesPlayed() {
		this.matchesPlayed++;
	}

	public void addTeamPoints(int teamPoints) {
		this.teamPoints += teamPoints;
	}

	public ArrayList<FootballPlayer> getPlayers() {
		return this.players;
	}

	/**
	 * Method to add a player to an array list of players
	 *  
	 */
	public void addPlayer(FootballPlayer player) throws IllegalArgumentException {
		if (players.size() > 11 || players.size() < 0) {
			throw new IllegalArgumentException("Sports team must consist of maximum of 11 players!");
		}
		if (players.contains(player)) {
			throw new IllegalArgumentException("Player already existing!");
		}
		players.add(player);
	}

	/**
	 * Method to remove a player from an array list of players
	 *  
	 */
	public void removePlayer(FootballPlayer player) throws IllegalArgumentException {
		if (!players.remove(player)) {
			throw new IllegalArgumentException("There is no such player!");
		}
	}

	public String checkExistence(FootballPlayer player) throws IllegalArgumentException {
		StringBuffer buffer = new StringBuffer();
		if (players.contains(player)) {
			buffer.append("Player found: " + player.getFirstName() + player.getLastName());
			return buffer.toString();
		} else {
			throw new IllegalArgumentException("No players found!");
		}
	}

	/** 
	 * Method to display players in a football team
	 * (if there are existent players)
	 * 
	 */
	public String displayPlayersInTeam() {
		StringBuffer buffer = new StringBuffer();
		for (FootballPlayer player : players) {
			buffer.append("Name: " + player.getFirstName() + " " + player.getLastName() + ", Team: " + player.getPlayerTeam().getTeamName() + ", Position: "
					+ player.getPosition() + ", Number: " + player.getNumberOfJersey() + "%n");
		}

		return buffer.toString();
	}
}
