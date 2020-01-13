package org.com1028.dv00139.footbll_classes;

import java.util.Comparator;

public class TeamComparator implements Comparator<FootballTeam> {

	/**
	 * Methods which compares teams 
	 * The team with most points is first 
	 * The rest of the teams follow it respectively down the table 
	 * If 2 teams have equal points, they are compared by their goal difference 
	 * Whichever team has a better goal difference goes before the other 
	 * We will use it to sort our table later on.
	 **/
	@Override
	public int compare(FootballTeam homeTeam, FootballTeam awayTeam) {
		if (homeTeam.getTeamPoints() > awayTeam.getTeamPoints()) {
			return -1;
		} else if (homeTeam.getTeamPoints() < awayTeam.getTeamPoints()) {
			return 1;
		} else {
			int goalsDifferenceHomeTeam = homeTeam.getGoalsScored() - homeTeam.getReceivedGoals();
			int goalsDifferenceAwayTeam = awayTeam.getReceivedGoals() - awayTeam.getReceivedGoals();

			if (goalsDifferenceHomeTeam > goalsDifferenceAwayTeam) {
				return -1;
			} else if (goalsDifferenceHomeTeam < goalsDifferenceAwayTeam) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}

