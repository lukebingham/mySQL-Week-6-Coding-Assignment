package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Record;

public class RecordDao {
	private Connection connection;
	
	private final String DISPLAY_TEAMS_RECORDS_QUERY = "SELECT * FROM season_records";
	private final String DISPLAY_A_TEAM_RECORDS_QUERY = "SELECT * FROM season_records WHERE team_name = ?";
	private final String ADD_A_TEAM_RECORD_QUERY = "INSERT INTO season_records(team_name, year, record) VALUES(?,?,?)";
	private final String DELETE_A_TEAM_RECORD_QUERY = "DELETE FROM season_records WHERE team_name = ?";
	 
	
	public RecordDao() {
		//System.out.println("RecordDao Constructor");
		connection = DBconnection.getConnection();
	}
	
	public List<Record> getRecords() throws SQLException {
		//System.out.println("TEST THREE");
		ResultSet rs = connection.prepareStatement(DISPLAY_TEAMS_RECORDS_QUERY).executeQuery();
		List<Record> records = new ArrayList<Record>();
		
		while (rs.next()) {
			records.add(populateRecord(rs.getString(1), rs.getInt(2), rs.getString(3)));
		}
		return records;
		
	}
	
	public Record getATeamRecord(String team_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DISPLAY_A_TEAM_RECORDS_QUERY);
		ps.setString(1, team_name);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		return populateRecord(rs.getString(1), rs.getInt(2), rs.getString(3));
	}
	
	private Record populateRecord(String team_name, int year, String record ) {
		return new Record(team_name, year, record);
	}
	
	public void addaTeamRecord(String team_name, int year, String record) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_A_TEAM_RECORD_QUERY);
		ps.setString(1, team_name);
		ps.setInt(2, year);
		ps.setString(3, record);
		ps.executeUpdate();
		
		
	}
	
	public void deleteTeamRecord(String team_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_A_TEAM_RECORD_QUERY);
		ps.setString(1, team_name);
		ps.executeUpdate();
	}

}

