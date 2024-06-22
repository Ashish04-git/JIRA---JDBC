package com.prac.jira.Model;

public class ProjectModel {

	String ProjectCode, ProjectName, Project_startDate, Project_endDate, Project_status;

	public ProjectModel(String projectCode, String projectName, String project_startDate, String project_endDate,
			String project_status) {
		super();
		ProjectCode = projectCode;
		ProjectName = projectName;
		Project_startDate = project_startDate;
		Project_endDate = project_endDate;
		Project_status = project_status;
	}

	public ProjectModel() {
		super();
	}

	public String getProjectCode() {
		return ProjectCode;
	}

	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getProject_startDate() {
		return Project_startDate;
	}

	public void setProject_startDate(String project_startDate) {
		Project_startDate = project_startDate;
	}

	public String getProject_endDate() {
		return Project_endDate;
	}

	public void setProject_endDate(String project_endDate) {
		Project_endDate = project_endDate;
	}

	public String getProject_status() {
		return Project_status;
	}

	public void setProject_status(String project_status) {
		Project_status = project_status;
	}

	@Override
	public String toString() {
		return "ProjectModel [ProjectCode=" + ProjectCode + ", ProjectName=" + ProjectName + ", Project_startDate="
				+ Project_startDate + ", Project_endDate=" + Project_endDate + ", Project_status=" + Project_status
				+ "]";
	}
	
	
	
	
}
