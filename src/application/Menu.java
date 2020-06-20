package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.RecordDao;
import entity.Record;

public class Menu {
	
	private RecordDao recordDao = new RecordDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Team Records",
			"Display a Team Record",
			"Add a Team Record",
			"Delete a Team Record"
			);
	
	public void start() throws SQLException {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if(selection.equals("1")) {
				displayTeamRecords();
			} else if (selection.equals("2")) {
				displayRecord();
			} else if (selection.equals("3")) {
				addARecord();
			} else if (selection.equals("4")) {
				deleteRecord();
			}
			
			System.out.println("Press enter to continue.");
			scanner.nextLine();
		} while (!selection.contentEquals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option");
		for (int i =0; i<options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}

	
	private void displayTeamRecords() throws SQLException {
		List<Record> records = recordDao.getRecords();
		for (Record record : records) {
			System.out.println("Team: " + record.getTeam_name() + " Year: " + record.getYear() + " Record: " 
										+ record.getRecord());
		}
	}
	
	private void displayRecord() throws SQLException {
		System.out.println("Enter Team:");
		String string = scanner.nextLine();
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
		recordDao.addaTeamRecord(team_name,year,record);
		
	}
	
	private void deleteRecord() throws SQLException {
		System.out.println("Enter Team Name to delete record:");
		String string = scanner.nextLine();
		recordDao.deleteTeamRecord(string);
	}
	
}
