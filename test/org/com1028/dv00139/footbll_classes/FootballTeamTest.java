package org.com1028.dv00139.footbll_classes;
import static org.junit.Assert.*;

import org.com1028.dv00139.footbll_classes.FootballPlayer;
import org.com1028.dv00139.footbll_classes.FootballTeam;
import org.com1028.dv00139.footbll_classes.PositionType;
import org.junit.Test;
/**
 * Tests for the FootballTeam class.
 * 
 * @author Daniel Vichinyan
 */
@SuppressWarnings("unused")

public class FootballTeamTest {
	/**
	 * Creating a FootballTeam object with valid input parameters for the team.
	 * 
	 * 
	 */
	@Test
	public void testFootballTeamConstruction() {
		FootballTeam team = new FootballTeam("Barcelona");
		assertEquals("Barcelona", team.getTeamName());
		assertEquals(0, team.getMatchesWon());
		assertEquals(0, team.getMatchesLost());
		assertEquals(0, team.getMatchesDrawn());
		assertEquals(0,	team.getMatchesPlayed());
		assertEquals(0, team.getTeamPoints());
	}
	
	/**
	 * Creating a FootballTeam object with invalid input parameter for the name
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTeamInvalidConstruction() {
		FootballTeam team = new FootballTeam("liverpool");
	}
	
	/**
	 * Creating a FootballTeam object with ONE player
	 * Testing if a player object is added to the list
	 * 
	 */
	@Test
	public void testListOfPlayers() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", new FootballTeam("Barcelona"), 6, PositionType.CF);
		team.addPlayer(player);
		assertEquals(team.getPlayers().size(), 1);
	}
	
	/**
	 * Creating a FootballTeam object
	 * Adding two SAME players to the list
	 * Checking if exception is thrown
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidAddPlayer() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", new FootballTeam("Barcelona"), 6, PositionType.CF);
		team.addPlayer(player);
		team.addPlayer(player);
	}

	/**
	 * Creating a FootballTeam object with ONE player
	 * Testing if a player object is removed from the list
	 * 
	 */
	@Test
	public void testRemovePlayer() {
		FootballTeam team = new FootballTeam("Barcelona");
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", new FootballTeam("Barcelona"), 6, PositionType.CF);
		team.addPlayer(player);
		team.removePlayer(player);
		assertEquals(team.getPlayers().size(), 0);
	}
}
