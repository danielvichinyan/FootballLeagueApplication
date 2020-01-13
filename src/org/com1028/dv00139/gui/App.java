package org.com1028.dv00139.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.com1028.dv00139.footbll_classes.FootballPlayer;
import org.com1028.dv00139.footbll_classes.FootballTeam;
import org.com1028.dv00139.footbll_classes.Match;
import org.com1028.dv00139.footbll_classes.PositionType;
import org.com1028.dv00139.footbll_classes.TeamComparator;

public class App {

	private JFrame frame;
	private JPanel panelMenu;
	private JTextField playerTeam;
	private JTextField playerSurname;
	private JTextField playerName;
	private JTextField addTeam;
	private JComboBox<PositionType> playerPosition;
	private JTextField jerseyNumber;
	private ArrayList<FootballPlayer> players = new ArrayList<>();
	private ArrayList<FootballTeam> teams = new ArrayList<>();
	private ArrayList<Match> matches = new ArrayList<>();
	private JTextArea textAreaPlayers;
	private JTextArea textAreaTeams;
	private JTextArea textAreaLeague;
	private JTextArea textAreaInvalidPlayerDetails;
	private JButton btnDisplayPlayers;
	private JTextArea textAreaCreatedTeam;
	private JTextField textFieldAwayTeam;
	private JTextField textFieldDateOfMatch;
	private JTextField textFieldHomeTeam;
	private JComboBox<Integer> comboBoxGoalsHomeTeam;
	private JComboBox<Integer> comboBoxAwayTeamGoals;
	private JTextArea textAreaMatches;
	private JTextArea textAreaInvalidMatchDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Football Application");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_1461983241651847");
		panelMenu.setLayout(null);

		JPanel panelPlayers = new JPanel();
		frame.getContentPane().add(panelPlayers, "name_1462013145045494");
		panelPlayers.setLayout(null);

		JPanel panelTeams = new JPanel();
		frame.getContentPane().add(panelTeams, "name_1464532346044007");
		panelTeams.setLayout(null);

		JPanel panelMatches = new JPanel();
		frame.getContentPane().add(panelMatches, "name_1990258470655598");
		panelMatches.setLayout(null);

		JButton btnBackMatches = new JButton("Back");
		btnBackMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMatches.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnBackMatches.setBounds(12, 13, 97, 25);
		panelMatches.add(btnBackMatches);

		textFieldHomeTeam = new JTextField();
		textFieldHomeTeam.setBounds(12, 130, 116, 22);
		panelMatches.add(textFieldHomeTeam);
		textFieldHomeTeam.setColumns(10);

		JLabel lblHomeTeam = new JLabel("Pick home team:");
		lblHomeTeam.setBounds(12, 103, 116, 25);
		panelMatches.add(lblHomeTeam);

		JLabel lblAwayTeam = new JLabel("Pick away team:");
		lblAwayTeam.setBounds(12, 162, 116, 25);
		panelMatches.add(lblAwayTeam);

		textFieldAwayTeam = new JTextField();
		textFieldAwayTeam.setBounds(12, 188, 116, 22);
		panelMatches.add(textFieldAwayTeam);
		textFieldAwayTeam.setColumns(10);

		textAreaMatches = new JTextArea();
		textAreaMatches.setBackground(UIManager.getColor("Button.background"));
		textAreaMatches.setEditable(false);
		textAreaMatches.setBounds(274, 82, 296, 358);
		panelMatches.add(textAreaMatches);

		JLabel lblDataOfMatch = new JLabel("Date\r\n(dd/mm/yyyy):");
		lblDataOfMatch.setBounds(12, 223, 165, 25);
		panelMatches.add(lblDataOfMatch);

		textFieldDateOfMatch = new JTextField();
		textFieldDateOfMatch.setBounds(12, 249, 116, 22);
		panelMatches.add(textFieldDateOfMatch);
		textFieldDateOfMatch.setColumns(10);

		textAreaInvalidMatchDetails = new JTextArea();
		textAreaInvalidMatchDetails.setBackground(UIManager.getColor("Button.background"));
		textAreaInvalidMatchDetails.setEditable(false);
		textAreaInvalidMatchDetails.setBounds(12, 82, 236, 22);
		panelMatches.add(textAreaInvalidMatchDetails);

		JButton btnCreateMatch = new JButton("Create match!");
		btnCreateMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMatch();
			}
		});
		btnCreateMatch.setBounds(12, 296, 172, 39);
		panelMatches.add(btnCreateMatch);

		comboBoxGoalsHomeTeam = new JComboBox<Integer>();
		comboBoxGoalsHomeTeam.setBounds(146, 130, 38, 22);
		for (int i = 0; i <= 10; i++) {
			comboBoxGoalsHomeTeam.addItem(new Integer(i));
		}
		panelMatches.add(comboBoxGoalsHomeTeam);

		comboBoxAwayTeamGoals = new JComboBox<Integer>();
		comboBoxAwayTeamGoals.setBounds(146, 188, 38, 22);
		for (int i = 0; i <= 10; i++) {
			comboBoxAwayTeamGoals.addItem(new Integer(i));
		}
		panelMatches.add(comboBoxAwayTeamGoals);

		JLabel lblHomeTeamGoals = new JLabel("Goals:");
		lblHomeTeamGoals.setBounds(140, 107, 56, 16);
		panelMatches.add(lblHomeTeamGoals);

		JLabel lblAwayTeamGoals = new JLabel("Goals:");
		lblAwayTeamGoals.setBounds(140, 166, 56, 16);
		panelMatches.add(lblAwayTeamGoals);

		JButton btnDisplayAllMatches = new JButton("Display all matches!");
		btnDisplayAllMatches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayAllMatches();
			}
		});
		btnDisplayAllMatches.setBounds(12, 401, 172, 39);
		panelMatches.add(btnDisplayAllMatches);

		JButton btnRemoveMatch = new JButton("Remove match!");
		btnRemoveMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeMatch();
			}
		});
		btnRemoveMatch.setBounds(12, 349, 172, 39);
		panelMatches.add(btnRemoveMatch);

		JPanel panelLeague = new JPanel();
		frame.getContentPane().add(panelLeague, "name_1465922703425391");
		panelLeague.setLayout(null);

		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLeague.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnBack_2.setBounds(12, 13, 97, 25);
		panelLeague.add(btnBack_2);

		textAreaLeague = new JTextArea();
		textAreaLeague.setBackground(UIManager.getColor("Button.background"));
		textAreaLeague.setEditable(false);
		textAreaLeague.setBounds(12, 51, 440, 342);
		panelLeague.add(textAreaLeague);

		JButton btnDisplayLeague = new JButton("Display League!");
		btnDisplayLeague.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayLeagueTable();
			}
		});
		btnDisplayLeague.setBounds(78, 406, 132, 34);
		panelLeague.add(btnDisplayLeague);

		JLabel lblTeamName = new JLabel("Team name:");
		lblTeamName.setBounds(12, 107, 82, 39);
		panelTeams.add(lblTeamName);

		addTeam = new JTextField();
		addTeam.setBounds(95, 113, 132, 27);
		panelTeams.add(addTeam);
		addTeam.setColumns(10);

		JButton addTeamButton = new JButton("Create team!");
		addTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeam();
			}
		});
		addTeamButton.setBounds(12, 169, 137, 32);
		panelTeams.add(addTeamButton);

		JButton btnNewButton_3 = new JButton("Delete team!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTeam();
			}
		});
		btnNewButton_3.setBounds(161, 169, 137, 32);
		panelTeams.add(btnNewButton_3);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeams.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnBack_1.setBounds(12, 24, 97, 25);
		panelTeams.add(btnBack_1);

		btnDisplayPlayers = new JButton("Display players!");
		btnDisplayPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPlayersInTeam();
			}
		});
		btnDisplayPlayers.setBounds(12, 214, 137, 32);
		panelTeams.add(btnDisplayPlayers);

		JButton btnTeamStatistics = new JButton("Display statistics!");
		btnTeamStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTeamStatistics();
			}
		});
		btnTeamStatistics.setBounds(161, 214, 137, 32);
		panelTeams.add(btnTeamStatistics);

		textAreaTeams = new JTextArea();
		textAreaTeams.setBackground(UIManager.getColor("Button.background"));
		textAreaTeams.setEditable(false);
		textAreaTeams.setBounds(302, 72, 268, 369);
		panelTeams.add(textAreaTeams);

		JButton btnDisplayAllTeams = new JButton("Display all teams!");
		btnDisplayAllTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllTeams();
			}
		});
		btnDisplayAllTeams.setBounds(12, 259, 286, 32);
		panelTeams.add(btnDisplayAllTeams);

		JButton btnNewButton_2 = new JButton("Add Players!");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (teams.isEmpty()) {
					textAreaCreatedTeam.setText("In order to add players, you should create a team first!");
				} else {
					panelTeams.setVisible(false);
					panelPlayers.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(102, 377, 125, 49);
		panelTeams.add(btnNewButton_2);

		textAreaCreatedTeam = new JTextArea();
		textAreaCreatedTeam.setBackground(UIManager.getColor("Button.background"));
		textAreaCreatedTeam.setEditable(false);
		textAreaCreatedTeam.setBounds(12, 324, 298, 39);
		panelTeams.add(textAreaCreatedTeam);

		JLabel lblChoosePosition = new JLabel("Player's position:");
		lblChoosePosition.setBounds(12, 189, 107, 31);
		panelPlayers.add(lblChoosePosition);

		playerPosition = new JComboBox<PositionType>();
		playerPosition.setModel(new DefaultComboBoxModel<PositionType>(PositionType.values()));
		playerPosition.setBounds(116, 189, 94, 26);
		panelPlayers.add(playerPosition);

		JLabel lblPlayersNumber = new JLabel("Jersey number:");
		lblPlayersNumber.setBounds(12, 238, 107, 22);
		panelPlayers.add(lblPlayersNumber);

		JLabel lblNewLabel = new JLabel("Player's team:");
		lblNewLabel.setBounds(12, 273, 107, 31);
		panelPlayers.add(lblNewLabel);

		playerTeam = new JTextField();
		playerTeam.setBounds(116, 277, 116, 27);
		panelPlayers.add(playerTeam);
		playerTeam.setColumns(10);

		JLabel lblPlayersName = new JLabel("Player's surname:");
		lblPlayersName.setBounds(12, 150, 107, 26);
		panelPlayers.add(lblPlayersName);

		playerSurname = new JTextField();
		playerSurname.setBounds(116, 150, 116, 26);
		panelPlayers.add(playerSurname);
		playerSurname.setColumns(10);

		playerName = new JTextField();
		playerName.setBounds(116, 111, 116, 26);
		panelPlayers.add(playerName);

		JLabel lblPlayersName_1 = new JLabel("Player's name:");
		lblPlayersName_1.setBounds(12, 111, 92, 26);
		panelPlayers.add(lblPlayersName_1);

		JButton addPlayer = new JButton("Add player!");
		addPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayer();
			}
		});
		addPlayer.setBounds(22, 353, 153, 68);
		panelPlayers.add(addPlayer);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPlayers.setVisible(false);
				panelMenu.setVisible(true);
			}
		});
		btnBack.setBounds(7, 13, 97, 25);
		panelPlayers.add(btnBack);

		jerseyNumber = new JTextField();
		jerseyNumber.setBounds(116, 233, 116, 27);
		panelPlayers.add(jerseyNumber);
		jerseyNumber.setColumns(10);

		JButton removePlayer = new JButton("Remove player!");
		removePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePlayer();
			}
		});
		removePlayer.setBounds(417, 353, 153, 68);
		panelPlayers.add(removePlayer);

		JLabel lblNewLabel_1 = new JLabel("Fill in the details below:");
		lblNewLabel_1.setBounds(12, 82, 558, 16);
		panelPlayers.add(lblNewLabel_1);

		textAreaPlayers = new JTextArea();
		textAreaPlayers.setBackground(UIManager.getColor("Button.background"));
		textAreaPlayers.setEditable(false);
		textAreaPlayers.setBounds(244, 84, 326, 253);
		panelPlayers.add(textAreaPlayers);

		JLabel listOfPlayers = new JLabel("List of players:");
		listOfPlayers.setBounds(244, 60, 278, 35);
		panelPlayers.add(listOfPlayers);

		JButton btnNewButton = new JButton("Display all players!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllPlayers();
			}
		});
		btnNewButton.setBounds(210, 353, 170, 68);
		panelPlayers.add(btnNewButton);

		textAreaInvalidPlayerDetails = new JTextArea();
		textAreaInvalidPlayerDetails.setBackground(UIManager.getColor("Button.background"));
		textAreaInvalidPlayerDetails.setEditable(false);
		textAreaInvalidPlayerDetails.setBounds(12, 51, 317, 26);
		panelPlayers.add(textAreaInvalidPlayerDetails);

		JButton btnClearFields = new JButton("Clear!");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerName.setText("");
				playerSurname.setText("");
				jerseyNumber.setText("");
				playerTeam.setText("");
			}
		});
		btnClearFields.setBounds(451, 13, 97, 25);
		panelPlayers.add(btnClearFields);

		JLabel label = new JLabel("Choose an option below:");
		label.setBounds(14, 165, 558, 23);
		panelMenu.add(label);

		JButton button_2 = new JButton("League");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelLeague.setVisible(true);
			}
		});
		button_2.setBounds(12, 390, 558, 50);
		panelMenu.add(button_2);

		JButton button_3 = new JButton("Matches");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelMatches.setVisible(true);
			}
		});
		button_3.setBounds(14, 303, 558, 50);
		panelMenu.add(button_3);

		JButton btnNewButton_1 = new JButton("Teams");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelTeams.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(16, 216, 556, 50);
		panelMenu.add(btnNewButton_1);

	}

	private void addPlayer() {
		try {
			String newPlayerName = this.playerName.getText();
			String newPlayerSurname = this.playerSurname.getText();
			int newJerseyNumber = Integer.parseInt(jerseyNumber.getText());
			String newPlayerTeam = this.playerTeam.getText();

			for (FootballPlayer footballPlayer : players) {
				if (footballPlayer.getFirstName().equals(newPlayerName)
						&& footballPlayer.getLastName().equals(newPlayerSurname)) {
					textAreaPlayers.setText("");
					textAreaPlayers.append("\nThe player with name " + playerName.getText() + " " + playerSurname.getText()
							+ " is already existing!");
					return;
				}
				if (footballPlayer.getNumberOfJersey() == newJerseyNumber) {
					textAreaPlayers.setText("");
					textAreaInvalidPlayerDetails.setText("");
					textAreaPlayers.append("\nA player with number of jersey [" + footballPlayer.getNumberOfJersey()
							+ "] already exists!");
					return;
				}
			}
			if (newPlayerName.equals("") || newPlayerSurname.equals("") || String.valueOf(jerseyNumber).equals("")
					|| newPlayerTeam.equals("")) {
				textAreaInvalidPlayerDetails.setText("Please make sure you fill in every text box!");
			}
			FootballPlayer player = new FootballPlayer(playerName.getText(), playerSurname.getText(),
					new FootballTeam(playerTeam.getText()), Integer.parseInt(jerseyNumber.getText()),
					(PositionType) playerPosition.getSelectedItem());

			players.add(player);
			textAreaPlayers.setText("");
			textAreaPlayers
					.append("\n" + playerName.getText() + " " + playerSurname.getText() + " - Club:" + playerTeam.getText()
							+ " Number:" + jerseyNumber.getText() + " Position:" + playerPosition.getSelectedItem());
		} catch (Exception e) {
			textAreaPlayers.setText(e.getMessage());
		}

	}

	private void removePlayer() {
		try {
			String newPlayerName = this.playerName.getText();
			String newPlayerSurname = this.playerSurname.getText();

			FootballPlayer player = null;
			for (FootballPlayer footballPlayer : players) {
				if (footballPlayer.getFirstName().equals(playerName.getText())) {
					player = footballPlayer;
					break;
				}
			}

			if (player == null) {
				textAreaPlayers.setText("No such existing player!");
			}
			if (newPlayerName.equals("") || newPlayerSurname.equals("")) {
				textAreaInvalidPlayerDetails.setText("Please make sure you fill in every text box!");
			}
			if(Character.isLowerCase(playerName.getText().charAt(0))) {
				textAreaPlayers.setText("Player name and surname should start with an upper-case letter!");
			}
			players.remove(player);
			textAreaPlayers.setText("");
			textAreaPlayers.append("\n" + player.getFirstName() + " " + player.getLastName() + " has been removed!");
			textAreaInvalidPlayerDetails.setText("");
		} catch (Exception e) {
			textAreaPlayers.setText(e.getMessage());
		}
		
	}

	private void addTeam() {
		try {
			String newTeamName = this.addTeam.getText();
			for (FootballTeam footballTeam : teams) {
				if (footballTeam.getTeamName().equals(newTeamName)) {
					textAreaCreatedTeam.setText("");
					textAreaTeams.setText("The team with name " + addTeam.getText() + " is already existing!");
					return;
				}
			}
			FootballTeam team = new FootballTeam(addTeam.getText());
			teams.add(team);
			textAreaTeams.setText("Team " + addTeam.getText() + " has been created!");
			textAreaCreatedTeam.setText("Congratulations!\nYou can now add players to team " + team.getTeamName() + "!");
		} catch (Exception e) {
			textAreaTeams.setText(e.getMessage());
		}
	}

	private void removeTeam() {
		try {
			FootballTeam team = null;
			for (FootballTeam footballTeam : teams) {
				if (footballTeam.getTeamName().equals(addTeam.getText())) {
					team = footballTeam;
					break;
				}
			}

			if (team == null) {
				textAreaTeams.setText("No such existing team!");
			}
			teams.remove(team);
			textAreaCreatedTeam.setText("");
			textAreaTeams.setText("The following teams have been removed:\n" + team.getTeamName());
		} catch (Exception e) {
			textAreaTeams.setText(e.getMessage());
		}
		
	}

	private void displayTeamStatistics() {
		FootballTeam team = null;
		for (FootballTeam footballTeam : teams) {
			if (footballTeam.getTeamName().equals(addTeam.getText())) {
				team = footballTeam;
				break;
			}
		}

		if (team == null) {
			textAreaTeams.setText("No such existing team!");

		}

		textAreaCreatedTeam.setText("");
		textAreaTeams.setText("Team statistics of " + addTeam.getText() + ":\n" + "Matches won:" + team.getMatchesWon()
				+ "\nMatchest lost:" + team.getMatchesLost() + "\nMatches drawn:" + team.getMatchesDrawn()
				+ "\nMatches played:" + team.getMatchesPlayed() + "\nGoals scored:" + team.getGoalsScored()
				+ "\nGoals received:" + team.getReceivedGoals());
	}

	private void displayLeagueTable() {
		textAreaLeague.setText(null);
		Collections.sort(teams, new TeamComparator());
		for (FootballTeam team : teams) {
			textAreaLeague.append(team.getTeamName() + " - points:" + team.getTeamPoints() + ", goals scored:"
					+ team.getGoalsScored() + ", goals received:" + team.getReceivedGoals() + ", goal difference:"
					+ (team.getGoalsScored() - team.getReceivedGoals()) + "\n");
		}

		if (teams.isEmpty()) {
			textAreaLeague.setText("No teams found in the league!");
		}
	}

	private void displayAllPlayers() {
		int count = 0;
		if (players.isEmpty()) {
			textAreaPlayers.append("\nThere are no existing players!");
		}
		textAreaPlayers.setText("");
		for (FootballPlayer player : players) {
			count += 1;
			textAreaPlayers.append("\n" + "(" + count + ") " + player.getFirstName() + " " + player.getLastName()
					+ ":\nClub:" + player.getPlayerTeam().getTeamName() + "  Number:" + player.getNumberOfJersey()
					+ "  Position:" + player.getPosition());
		}
	}

	private void displayAllTeams() {
		int count = 0;
		textAreaTeams.setText("");
		textAreaCreatedTeam.setText("");
		for (FootballTeam team : teams) {
			count += 1;
			textAreaTeams.append("\n" + "(" + count + ") " + team.getTeamName());
		}

		if (teams.isEmpty()) {
			textAreaTeams.setText("");
			textAreaTeams.append("There are no existing teams!");
		}
	}

	private void displayPlayersInTeam() {
		int count = 0;
		for (FootballPlayer player : players) {
			if (player.getPlayerTeam().getTeamName().equals(addTeam.getText())) {
				count += 1;
				textAreaTeams.setText("");
				textAreaTeams.append("(" + count + ")" + player.getFirstName() + " " + player.getLastName() + " - "
						+ player.getPlayerTeam().getTeamName() + " " + player.getPosition() + " ["
						+ player.getNumberOfJersey() + "]" + "\n");
			} else if (!player.getPlayerTeam().getTeamName().equals(addTeam.getText())) {
				textAreaTeams.setText("There are no players in team " + addTeam.getText() + " !");
			}
		}
		if (teams.isEmpty()) {
			textAreaTeams.setText("");
			textAreaTeams.setText("There are no existing teams!");
		}
	}

	private void addMatch() {
		if (textFieldHomeTeam.getText().equals("") || textFieldAwayTeam.getText().equals("")
				|| textFieldDateOfMatch.getText().equals("")) {
			textAreaInvalidMatchDetails.setText("Please make sure you fill every box below!");
		}
		String strDate = this.textFieldDateOfMatch.getText();
		Match match = new Match(this.findTeamByName(textFieldHomeTeam.getText()),
				this.findTeamByName(textFieldAwayTeam.getText()), (Integer) comboBoxGoalsHomeTeam.getSelectedItem(),
				(Integer) comboBoxAwayTeamGoals.getSelectedItem(),
				LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		matches.add(match);
		textAreaInvalidMatchDetails.setText("");
		textAreaMatches.setText("[" + match.getDate().toString() + "]\n" + match.getHomeTeam().getTeamName() + " - "
				+ match.getAwayTeam().getTeamName() + " " + match.getHomeTeamScoredGoals() + ":"
				+ match.getAwayTeamScoredGoals());
	}

	private FootballTeam findTeamByName(String name) {
		for (FootballTeam footballTeam : teams) {
			if (footballTeam.getTeamName().equals(name)) {
				return footballTeam;
			}
		}
		return null;
	}

	private void displayAllMatches() {
		textAreaMatches.setText("");
		if (teams.isEmpty()) {
			textAreaMatches.setText("There are no existing matches!");
		}
		for (Match match : matches) {
			textAreaMatches.append("[" + match.getDate().toString() + "]\n" + match.getHomeTeam().getTeamName() + " - "
					+ match.getAwayTeam().getTeamName() + " " + match.getHomeTeamScoredGoals() + ":"
					+ match.getAwayTeamScoredGoals() + "\n");
		}
	}

	private void removeMatch() {
		Match match = null;
		for (Match footballMatch : matches) {
			if (footballMatch.getHomeTeam().getTeamName().equals(textFieldHomeTeam.getText())
					|| footballMatch.getAwayTeam().getTeamName().equals(textFieldAwayTeam.getText())) {
				match = footballMatch;
				break;
			}
		}

		if (match == null) {
			textAreaTeams.setText("No such existing match!");

		}
		matches.remove(match);
		textAreaMatches.setText("");
		textAreaMatches.setText("The following matches have been removed:\n" + "[" + match.getDate().toString() + "]\n"
				+ match.getHomeTeam().getTeamName() + " - " + match.getAwayTeam().getTeamName() + " "
				+ match.getHomeTeamScoredGoals() + ":" + match.getAwayTeamScoredGoals() + "\n");
	}

}
