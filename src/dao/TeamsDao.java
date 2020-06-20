package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Team;

public class TeamsDao {
private Connection connection;
	
	private final String DISPLAY_TEAMS_QUERY = "select * from teams";
	private final String DISPLAY_TEAM_QUERY = "select * from teams where team_name = ?";
	private final String CREATE_TEAM_QUERY = "insert into teams(team_name, location) values(?,?)";
	private final String UPDATE_TEAM_LOCATION_QUERY = "update teams set location = ? where team_name = ?";
	private final String DELETE_TEAM_QUERY = "delete from teams where team_name = ?";
	
	public TeamsDao() {
		connection = DBconnection.getConnection();
	}
		
	public List<Team> getTeams() throws SQLException {
		ResultSet rs = connection.prepareStatement(DISPLAY_TEAMS_QUERY).executeQuery();
		List<Team> teams = new ArrayList<Team>();
			
		while (rs.next()) {
			teams.add(populateTeam(rs.getString(1), rs.getString(2)));
		}
		
		return teams;
	}
	
	public Team getTeam(String team_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DISPLAY_TEAM_QUERY);
		ps.setString(1, team_name);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTeam(rs.getString(1), rs.getString(2));
	}
	
	private Team populateTeam(String team_name, String location) {
		return new Team(team_name, location);
	}
	
	public void createTeam(String team_name, String location) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_TEAM_QUERY);
		ps.setString(1, team_name);
		ps.setString(2, location);
		ps.executeUpdate();
	}
	
	public void updateTeamLocation(String team_name, String location) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TEAM_LOCATION_QUERY);
		ps.setString(1, location);
		ps.setString(2, team_name);
		ps.executeUpdate();
	
	}
	
	public void deleteTeam(String team_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TEAM_QUERY);
		ps.setString(1, team_name);
		ps.executeUpdate();
	}
	
	
	
}

