package org.com1028.dv00139.footbll_classes;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * Defines the properties and behavior of a football league
 *  
 * @author Daniel Vichinyan 
 */ 
public class FootballLeague {
	private String nameOfLeague = null;
	private ArrayList<FootballTeam> league = null;
	private ArrayList<FootballPlayer> players = null;
	private ArrayList<Match> matches = null;

	 /** 
	   * Constructor. Sets the field values. 
	   *  
	   * @param nameOfLeague
	   */ 
	public FootballLeague(String nameOfLeague) throws IllegalArgumentException {
		super();
		if (nameOfLeague == null || Character.isLowerCase(nameOfLeague.charAt(0))) {
			throw new IllegalArgumentException("Invalid league name!");
		}
		this.nameOfLeague = nameOfLeague;
		this.league = new ArrayList<FootballTeam>();
		this.players = new ArrayList<FootballPlayer>();
		this.matches = new ArrayList<Match>();
	}

	public String getNameOfLeague() {
		return this.nameOfLeague;
	}

	public ArrayList<FootballTeam> getLeague() {
		return this.league;
	}

	public ArrayList<FootballPlayer> getPlayers() {
		return this.players;
	}

	public ArrayList<Match> getMatches() {
		return this.matches;
	}

	/** 
	 * Method to add a team to a league
	 * 
	 */
	public void addTeam(FootballTeam team) throws IllegalArgumentException {
		if (league.contains(team)) {
			throw new IllegalArgumentException("Team is already in the league!");
		}
		if (team == null) {
			throw new NullPointerException("Invalid team");
		}
		if (league.size() > 10) {
			throw new IllegalArgumentException("Maximum of 10 teams must be in a league!");
		}
		league.add(team);
	}

	/** 
	 * Method to remove a team from a league
	 * 
	 */
	public void removeTeam(FootballTeam team) throws IllegalArgumentException {
		if (league.contains(team)) {
			league.remove(team);
		} else {
			throw new IllegalArgumentException("No teams found in the league!");
		}
	}

	public void checkTeamExistence(FootballTeam team) {
		if (league.contains(team)) {
			System.out.printf("%s found!", team.getTeamName());
		} else {
			throw new IllegalArgumentException("No team found!");
		}
	}

	/** 
	 * Method to add a match to a league
	 * 
	 */
	public void addMatch(Match match) throws IllegalArgumentException {
		if (match == null) {
			throw new IllegalArgumentException("Invalid match!");
		}
		matches.add(match);

	}

	/** 
	 * Method to remove a match from a league
	 *
	 */
	public void removeMatch(Match match) throws IllegalArgumentException {
		if (!matches.remove(match)) {
			throw new IllegalArgumentException("There is no such match!");
		}
	}

	/** 
	 * Method to display team statistics
	 * append the details of the team then
	 * @return buffer.toString()
	 * 
	 */
	public String displayStatistics(FootballTeam team) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(team.getTeamName() + ":%nMatches won:" + team.getMatchesWon() + "%nMatches lost:"
				+ team.getMatchesLost() + "%nMatches drawn:" + team.getMatchesDrawn() + "%nMatches played:"
				+ team.getMatchesPlayed() + "%nTeam points:" + team.getTeamPoints());

		return buffer.toString();
	}

	/** 
	 * Method to display the league table
	 * append the details of the teams then
	 * @return buffer.toString()
	 * 
	 */
	public String displayLeagueTable() {
		StringBuffer buffer = new StringBuffer();
		Collections.sort(league, new TeamComparator());
		for (FootballTeam team : league) {
			buffer.append(team.getTeamName() + " - points:" + team.getTeamPoints() + ", goals scored"
					+ team.getGoalsScored() + ", goals received:" + team.getReceivedGoals() + ", goal difference:"
					+ (team.getGoalsScored() - team.getReceivedGoals()));
		}

		return buffer.toString();
	}
}
