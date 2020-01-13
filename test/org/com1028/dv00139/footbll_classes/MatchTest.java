package org.com1028.dv00139.footbll_classes;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.com1028.dv00139.footbll_classes.FootballTeam;
import org.com1028.dv00139.footbll_classes.Match;
import org.junit.Test;
/**
 * Tests for the Match class.
 * 
 * @author Daniel Vichinyan
 */
@SuppressWarnings("unused")
public class MatchTest {
	
	/**
	 * Creating a Match object with valid input parameters for the match.
	 * Test that the toString() can be retrieved correctly.
	 * 
	 */
	@Test
	public void testMatchConstruction() {
		Match match = new Match(new FootballTeam("Liverpool"), new FootballTeam("Chelsea"), 0, 0, LocalDate.of(2019, 1, 12));
		assertEquals("Liverpool", match.getHomeTeam().getTeamName());
		assertEquals("Chelsea", match.getAwayTeam().getTeamName());
		assertEquals(0, match.getHomeTeamScoredGoals());
		assertEquals(0, match.getAwayTeamScoredGoals());
		assertTrue(match.getDate().equals(LocalDate.of(2019, 1, 12)));
	}


	/**
	 * Creating a Match object with invalid input for goals scored by HOME team for the match.
	 * Test if negative goals are detected as an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMatchInvalidConstruction() {
		Match match = new Match(new FootballTeam("Liverpool"), new FootballTeam("Chelsea"), -1, 0, LocalDate.of(2019, 1, 12));
	}
	
	/**
	 * Creating a Match object with invalid input for goals scored by AWAY team for the match.
	 * Test if negative goals are detected as an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testMatchInvalidConstruction2() {
		Match match = new Match(new FootballTeam("Liverpool"), new FootballTeam("Chelsea"), 0, -1, LocalDate.of(2019, 1, 12));
	}
	
	/**
	 * Creating a Match object with invalid input for HOME team.
	 * Tests if a invalid team is detected as an exception.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatchInvalidConstruction3() {
		Match match = new Match(null, new FootballTeam("Chelsea"), 0, 0, LocalDate.of(2019, 1, 12));
	}
	
	/**
	 * Creating a Match object with invalid input for AWAY team.
	 * Tests if a invalid team is detected as an exception.
	 */
	@Test(expected = NullPointerException.class)
	public void testMatchInvalidConstruction4() {
		Match match = new Match(new FootballTeam("Liverpool"), null, 0, 0, LocalDate.of(2019, 1, 12));
	}
}
