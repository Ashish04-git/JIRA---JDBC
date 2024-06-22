package com.prac.jira.Service;

import java.util.ArrayList;
import java.util.List;

import com.prac.jira.Dao.ProjectDao;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Model.ProjectModel;

public class ProjectService {

	ProjectDao dao= new ProjectDao();
	boolean flag;
	
	public boolean createProject(ProjectModel project) throws ProjectException{
		
		flag=dao.createProject(project);
		return flag;
	}
	
	public boolean updateProject(ProjectModel project) throws ProjectException{
		
		flag=dao.updateProject(project);
		return flag;
	}
	
	public boolean updateProjectStatus(String status, String name) throws ProjectException {
		
		flag= dao.updateProjectStatus(status, name);
		return flag;
	}
	
	public boolean deleteProject(String projectCode) throws ProjectException{
		
		flag= dao.deleteProject(projectCode);
		return flag;
		
	}
	
	public List<ProjectModel> listAllProjects() throws ProjectException{
		
		List<ProjectModel> projectList= new ArrayList<ProjectModel>();
		projectList=dao.listAllProjects();
		return projectList;
	}
	
	public ProjectModel getProjectById(String projectCode) throws ProjectException {
		
		ProjectModel project= new ProjectModel();
		project= dao.getProjectById(projectCode);
		return project;
	}
}
