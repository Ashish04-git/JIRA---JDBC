package com.prac.jira.Model;

public class UserStoryModel {
	
	private String UScode, USname, USpriority, USstatus, Project_code;
	private Integer USpoints;

	public UserStoryModel(String uScode, String uSname, String uSpriority, Integer uSpoints, String uSstatus,
			String project_code) {
		super();
		UScode = uScode;
		USname = uSname;
		USpriority = uSpriority;
		USpoints = uSpoints;
		USstatus = uSstatus;
		Project_code = project_code;
	}

	public UserStoryModel() {
		super();
	}

	public String getUScode() {
		return UScode;
	}

	public void setUScode(String uScode) {
		UScode = uScode;
	}

	public String getUSname() {
		return USname;
	}

	public void setUSname(String uSname) {
		USname = uSname;
	}

	public String getUSpriority() {
		return USpriority;
	}

	public void setUSpriority(String uSpriority) {
		USpriority = uSpriority;
	}

	public Integer getUSpoints() {
		return USpoints;
	}

	public void setUSpoints(Integer uSpoints) {
		USpoints = uSpoints;
	}

	public String getUSstatus() {
		return USstatus;
	}

	public void setUSstatus(String uSstatus) {
		USstatus = uSstatus;
	}

	public String getProject_code() {
		return Project_code;
	}

	public void setProject_code(String project_code) {
		Project_code = project_code;
	}

	@Override
	public String toString() {
		return "UserStoryModel [UScode=" + UScode + ", USname=" + USname + ", USpriority=" + USpriority + ", USpoints="
				+ USpoints + ", USstatus=" + USstatus + ", Project_code=" + Project_code + "]";
	}
	
	

}
