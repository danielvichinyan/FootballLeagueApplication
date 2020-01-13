package org.com1028.dv00139.footbll_classes;
import static org.junit.Assert.*;

import org.com1028.dv00139.footbll_classes.FootballPlayer;
import org.com1028.dv00139.footbll_classes.FootballTeam;
import org.com1028.dv00139.footbll_classes.PositionType;
import org.junit.Test;
/**
 * Tests for the FootballPlayer class.
 * 
 * @author Daniel Vichinyan
 */
@SuppressWarnings("unused")
public class FootballPlayerTest {

	/**
	 * Creating a FootballPlayer object with valid input parameters for the player. 
	 * Test that the toString() can be retrieved correctly.
	 * 
	 */
	@Test
	public void testFootballPlayerConstruction() {
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", new FootballTeam("Barcelona"), 9, PositionType.CF);
		assertEquals("Daniel", player.getFirstName().toString());
		assertEquals("Vichinyan", player.getLastName().toString());
		assertEquals("Barcelona", player.getPlayerTeam().getTeamName());
		assertEquals(9, player.getNumberOfJersey());
		assertEquals("Centre Forward", player.getPosition().toString());
	}
	
	/**
	 * Creating a FootballPlayer object with invalid input parameter for player's name
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPlayerInvalidConstruction() {
		FootballPlayer player = new FootballPlayer("daniel", "Vichinyan", new FootballTeam("Barcelona"), 9, PositionType.CF);
	}
	
	/**
	 * Creating a FootballPlayer object with invalid input parameter for player's jersey number
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPlayerInvalidConstruction2() {
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", new FootballTeam("Barcelona"), 100, PositionType.CF);
	}
	
	/**
	 * Creating a FootballPlayer object with invalid input parameter for player's team
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testPlayerInvalidConstruction3() {
		FootballPlayer player = new FootballPlayer("Daniel", "Vichinyan", null, 9, PositionType.CF);
	}
	
}
