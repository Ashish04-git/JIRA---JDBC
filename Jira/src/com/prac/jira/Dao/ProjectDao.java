package com.prac.jira.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prac.jira.Connection.DBUtil;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Model.ProjectModel;

public class ProjectDao {
	static Connection connection=null;
	static PreparedStatement ps=null;
	static String query=null;
	Scanner sc= new Scanner(System.in);
	
	public static Date getSqlDate(String Date) throws ProjectException{
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date date= dateFormat.parse(Date);
			Date sqlDate= new Date(date.getTime());
			return sqlDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			throw new ProjectException("Invalid Date Format. Valid format is DD/MM/YYYY");
			
		}
	}
	
	public static boolean createProject(ProjectModel project) throws ProjectException{
		
		try {
			connection=DBUtil.getConnection();
			ps = connection.prepareStatement("insert into project values (?,?,?,?,'To Do');");
			ps.setString(1, project.getProjectCode());
			ps.setString(2, project.getProjectName());
			ps.setDate(3, getSqlDate(project.getProject_startDate()));
			ps.setDate(4, getSqlDate(project.getProject_endDate()));
//			ps.setString(5,project.getProject_status());
			int n=ps.executeUpdate();
			ps.close();
//			connection.commit();
			connection.close();
			if(n>0) {
//				System.out.println("Success");
				return true;
				
			}else {
//				System.out.println("Failure");
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProjectException("Unable to add project");
//			e.printStackTrace();
		}
//		return false;
		
		
	}
	
	public boolean updateProject(ProjectModel project) throws ProjectException {
		
		try {
			connection= DBUtil.getConnection();
			query="update project set project_name=?, project_startdate=?, project_enddate=?, project_status=? where project_code=?;";
			ps = connection.prepareStatement(query);
			ps.setString(1, project.getProjectName());
			ps.setDate(2, getSqlDate(project.getProject_startDate()));
			ps.setDate(3, getSqlDate(project.getProject_endDate()));
			ps.setString(4, project.getProject_status());
			ps.setString(5, project.getProjectCode());
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProjectException("Unable to update project");
		}
		
	}
	
	public static boolean updateProjectStatus(String status, String code)  {
		try {
			connection= DBUtil.getConnection();
			query="update jira.project set project_status=? where project_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, status);
			ps.setString(2, code);
			int n=ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
//			throw new ProjectException("Project not found!!");
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deleteProject(String projectCode) throws ProjectException{
		
		try {
			
			connection= DBUtil.getConnection();
			query="delete from project where project_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, projectCode);
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProjectException("Project not found!!");
		}
	}
	
	public List<ProjectModel> listAllProjects() throws ProjectException{
		try {
			connection= DBUtil.getConnection();
			List<ProjectModel> projectList= new ArrayList<ProjectModel>();
			query="select * from project order by project_status desc";
			ps=connection.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				ProjectModel project= new ProjectModel(rs.getString(1), rs.getString(2), rs.getDate(3).toString(), rs.getDate(4).toString(), rs.getString(5));
				projectList.add(project);
			}
			ps.close();
			connection.close();
			
			if(projectList.size()>0)
				return projectList;
			return null;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProjectException("No Projects found!!");
		}
		
	}
	
	public ProjectModel getProjectById(String projectCode) throws ProjectException {
		
		try {
			connection= DBUtil.getConnection();
			ProjectModel project= new ProjectModel();
			query="select * from project where project_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, projectCode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			project= new ProjectModel(rs.getString(1),rs.getString(2),rs.getDate(3).toString(), rs.getDate(4).toString(),rs.getString(5));}
			ps.close();
			connection.close();
			if(project!=null)
				return project;
			return null;
			
		}catch(Exception e) {
			throw new ProjectException("No project exist with code "+projectCode);
			//e.printStackTrace();
			
		}
	}
	
	public static void main(String args[]) throws ProjectException {
		ProjectModel project= new ProjectModel("Sample2","Test1 Test2 Test3 Test4 Test5 Test6 Test7 Test8 Test9 Test10","01/01/2020","01/01/2024","Accepted");
		
		System.out.println(updateProjectStatus("In Progress", "Sample3"));
	}

}
