package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.RecordDao;
import dao.TeamsDao;
import entity.Record;
import entity.Team;

public class Menu {
	
	//private RecordDao recordDao = new RecordDao();
	//private TeamsDao teamsDao = new TeamsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Team Records",
			"Display a Team Record",
			"Add a Team Record",
			"Delete a Team Record",
			"Display Teams",
			"Display a Team",
			"Create a Team",
			"Delete a Team",
			"Update a Team Location"
			);
	
	public void start() { //throws SQLException {
		String selection = "";
		
		//System.out.println("test one");
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayTeamRecords();
				} else if (selection.equals("2")) {
					displayRecord();
				} else if (selection.equals("3")) {
					addARecord();
				} else if (selection.equals("4")) {
					deleteRecord();
				} else if (selection.equals("5")) {
					displayTeams();
				} else if (selection.equals("6")) {
					displayTeam();
				} else if (selection.equals("7")) {
					createTeam();
				} else if (selection.equals("8")) {
					deleteTeam();
				} else if (selection.equals("9")) {
					updateLocation();
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue.");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option");
		for (int i =0; i<options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displayTeamRecords() throws SQLException {
		RecordDao recordDao = new RecordDao();
		List<Record> records = recordDao.getRecords();
		for (Record record : records) {
			System.out.println("Team: " + record.getTeam_name() + " Year: " + record.getYear() + " Record: " 
										+ record.getRecord());
		}
	}
	
	private void displayRecord() throws SQLException {
		System.out.println("Enter Team:");
		String string = scanner.nextLine();
		RecordDao recordDao = new RecordDao();
		Record record = recordDao.getATeamRecord(string);
		System.out.println("Team: " + record.getTeam_name() + " Year: " + record.getYear() + " Record: " + record.getRecord());
		
	}
	
	private void addARecord() throws SQLException {
		System.out.println("Enter team name: ");
		String team_name = scanner.nextLine();
		System.out.println("Enter year: ");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter record: ");
		String record = scanner.nextLine();
		RecordDao recordDao = new RecordDao();
		recordDao.addaTeamRecord(team_name,year,record);
		
	}
	
	private void deleteRecord() throws SQLException {
		System.out.println("Enter Team Name to delete record:");
		String string = scanner.nextLine();
		RecordDao recordDao = new RecordDao();
		recordDao.deleteTeamRecord(string);
	}
	
	private void displayTeams() throws SQLException {
		TeamsDao teamsDao = new TeamsDao();
		List<Team> teams = teamsDao.getTeams();
		for (Team team : teams) {
			System.out.println("Team Name: " + "'" + team.getTeam_name() + "'" + " Location: " + team.getLocation());
		}
	}
			
	private void displayTeam() throws SQLException {
		System.out.println("Enter Team:");
		String string = scanner.nextLine();
		TeamsDao teamsDao = new TeamsDao();
		Team team = teamsDao.getTeam(string);
		System.out.println("Team: " + team.getTeam_name() + " Location: " + team.getLocation());		
	}
	
	private void createTeam() throws SQLException {
		System.out.println("Enter team name: ");
		String team_name = scanner.nextLine();
		System.out.println("Enter Location: ");
		String location = scanner.nextLine();
		TeamsDao teamsDao = new TeamsDao();
		teamsDao.createTeam(team_name,location);
			
	}
		
	private void deleteTeam() throws SQLException {
		System.out.println("Enter Team Name:");
		String string = scanner.nextLine();
		TeamsDao teamsDao = new TeamsDao();
		teamsDao.deleteTeam(string);
			
	}
		
	private void updateLocation() throws SQLException {
		System.out.println("Enter Team Name: ");
		String team_name = scanner.nextLine();
		System.out.print("Enter New Location: ");
		String location = scanner.nextLine();
		TeamsDao teamsDao = new TeamsDao();
		teamsDao.updateTeamLocation(team_name, location);
			
	}
	
}
