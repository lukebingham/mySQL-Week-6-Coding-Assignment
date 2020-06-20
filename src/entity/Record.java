package entity;

public class Record {
	
	private String team_name;
	private int year;
	private String record;
	
	public Record(String team_name, int year, String record) {
		this.setTeam_name(team_name);
		this.setYear(year);
		this.setRecord(record);
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String teamName) {
		this.team_name = teamName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	
}

