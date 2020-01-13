package org.com1028.dv00139.footbll_classes;

import java.time.LocalDate;

/** 
 * Defines the properties and behavior of a football match
 *  
 * @author Daniel Vichinyan 
 */ 
public class Match {
	
	private FootballTeam homeTeam = null;
	private FootballTeam awayTeam = null;
	private int homeTeamScoredGoals = 0;
	private int awayTeamScoredGoals = 0;
	private LocalDate date = null;
	
	 /** 
	   * Constructor. Sets the field values. 
	   *  
	   * @param homeTeam
	   * @param awayTeam
	   * @param homeTeamScoredGoals
	   * @param awayTeamScoredGoals
	   * @param date
	   */ 
	public Match(FootballTeam homeTeam, FootballTeam awayTeam, int homeTeamScoredGoals, int awayTeamScoredGoals, LocalDate date) throws IllegalArgumentException {
		if(homeTeam == null || awayTeam == null) {
			throw new NullPointerException("Invalid home or away team!");
		}
		if(homeTeamScoredGoals < 0 || awayTeamScoredGoals < 0) {
			throw new IllegalArgumentException("Score can't be a negative number!");
		}
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScoredGoals = homeTeamScoredGoals;
		this.awayTeamScoredGoals = awayTeamScoredGoals;
		this.date = date;
		homeTeam.addGoalsScored(homeTeamScoredGoals);
		homeTeam.addReceivedGoals(awayTeamScoredGoals);
		awayTeam.addGoalsScored(awayTeamScoredGoals);
		awayTeam.addReceivedGoals(homeTeamScoredGoals);
		if (homeTeamScoredGoals > awayTeamScoredGoals) {
			homeTeam.addTeamPoints(3);
			homeTeam.incMatchesWon();
			homeTeam.incMatchesPlayed();
			awayTeam.incMatchesLost();
			awayTeam.incMatchesPlayed();
		} else if (homeTeamScoredGoals == awayTeamScoredGoals) {
			homeTeam.addTeamPoints(1);
			awayTeam.addTeamPoints(1);
			homeTeam.incMatchesPlayed();
			awayTeam.incMatchesPlayed();
			homeTeam.incMatchesDrawn();
			awayTeam.incMatchesDrawn();
		} else {
			awayTeam.addTeamPoints(3);
			awayTeam.incMatchesPlayed();
			awayTeam.incMatchesWon();
			homeTeam.incMatchesLost();
			homeTeam.incMatchesPlayed();
		}
	}

	public FootballTeam getHomeTeam() {
		return this.homeTeam;
	}

	public FootballTeam getAwayTeam() {
		return this.awayTeam;
	}

	public int getHomeTeamScoredGoals() {
		return this.homeTeamScoredGoals;
	}

	public int getAwayTeamScoredGoals() {
		return this.awayTeamScoredGoals;
	}

	public LocalDate getDate() {
		return this.date;
	}

	@Override
	public String toString() { 
		return "[" + date + "]" + " " + homeTeam.getTeamName() + " " + homeTeamScoredGoals + "-" + awayTeamScoredGoals + " " + awayTeam.getTeamName();
	}
	
	
}
