package entity;

public class Team {
	
	private String team_name;
	private String location;
	
	public Team(String team_name, String location) {
		this.setTeam_name(team_name);
		this.setLocation(location);
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

