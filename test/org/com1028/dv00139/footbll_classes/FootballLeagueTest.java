package org.com1028.dv00139.footbll_classes;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.com1028.dv00139.footbll_classes.FootballLeague;
import org.com1028.dv00139.footbll_classes.FootballTeam;
import org.com1028.dv00139.footbll_classes.Match;
import org.junit.Test;
/**
 * Tests for the FootballLeague class.
 * 
 * @author Daniel Vichinyan
 */
public class FootballLeagueTest {

	/**
	 * Creating a FootballLeague object with a valid parameter for the name
	 * 
	 * 
	 */
	@Test
	public void testFootballLeagueConstruction() {
		FootballLeague league = new FootballLeague("Premier League");
		assertEquals("Premier League", league.getNameOfLeague());
	}
	
	/**
	 * Creating a FootballLeague object with an invalid parameter for the name
	 * 
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFootballLeagueInvalidConstruction() {
		FootballLeague league = new FootballLeague("premier League");
		assertEquals("premier League", league.getNameOfLeague());
	}

	/**
	 * Creating a FootballTeam object
	 * Testing if the team object is added to the list
	 * 
	 */
	@Test
	public void testAddTeamToLeague() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballLeague league = new FootballLeague("Premier League");
		league.addTeam(team);
		assertEquals(league.getLeague().size(), 1);
	}

	/**
	 * Creating a FootballTeam object
	 * Testing if the team object is added to the list
	 * 
	 */
	@Test
	public void testRemoveTeamFromLeague() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballLeague league = new FootballLeague("Premier League");
		league.addTeam(team);
		league.removeTeam(team);
		assertEquals(league.getLeague().size(), 0);
	}
	
	/**
	 * Creating a Match object
	 * Testing if the match object is added to the list
	 * 
	 */
	@Test
	public void testAddMatchToLeague() {
		Match match = new Match(new FootballTeam("Barcelona"),new FootballTeam("Liverpool"), 0, 0, LocalDate.of(2019, 1, 12));
		FootballLeague league = new FootballLeague("Premier League");
		league.addMatch(match);
		assertEquals(league.getMatches().size(), 1);
	}

	/**
	 * Creating a Match object
	 * Testing if the match object is removed from the list
	 * 
	 */
	@Test
	public void testRemoveMatchFromLeague() {
		Match match = new Match(new FootballTeam("Barcelona"),new FootballTeam("Liverpool"), 0, 0, LocalDate.of(2019, 1, 12));
		FootballLeague league = new FootballLeague("Premier League");
		league.addMatch(match);
		league.removeMatch(match);
		assertEquals(league.getMatches().size(), 0);
	}
	
	/**
	 * Creating a FootballTeam object
	 * Creating a league object
	 * Testing if the the team statistics are displayed correctly
	 * 
	 */
	@Test
	public void testDisplayTeamStatistics() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballLeague league = new FootballLeague("Premier League");
		league.addTeam(team);
		assertEquals(league.displayStatistics(team), team.getTeamName() + ":%nMatches won:" + team.getMatchesWon() + "%nMatches lost:"
				+ team.getMatchesLost() + "%nMatches drawn:" + team.getMatchesDrawn() + "%nMatches played:"
				+ team.getMatchesPlayed() + "%nTeam points:" + team.getTeamPoints());
	}
	
	/**
	 * Creating a team object
	 * Creating a league object
	 * Testing if the league table is displayed correctly
	 * 
	 */
	@Test
	public void testDisplayLeagueTable() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballLeague league = new FootballLeague("Premier League");
		league.addTeam(team);
		assertEquals(league.displayLeagueTable(), team.getTeamName() + " - points:" + team.getTeamPoints() + ", goals scored"
				+ team.getGoalsScored() + ", goals received:" + team.getReceivedGoals() + ", goal difference:"
				+ (team.getGoalsScored() - team.getReceivedGoals()));
	}
	
	/**
	 * Creating a team object
	 * Creating a league object
	 * Testing if the league table is displayed correctly
	 * 
	 */
	@Test
	public void testDisplayLeagueTable2() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballLeague league = new FootballLeague("Premier League");
		league.addTeam(team);
		assertEquals(league.displayLeagueTable(), team.getTeamName() + " - points:" + team.getTeamPoints() + ", goals scored"
				+ team.getGoalsScored() + ", goals received:" + team.getReceivedGoals() + ", goal difference:"
				+ (team.getGoalsScored() - team.getReceivedGoals()));
	}
}
