package com.prac.jira.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prac.jira.Connection.DBUtil;
import com.prac.jira.Exception.USException;
import com.prac.jira.Model.UserStoryModel;

public class UserStoryDao {

	static Connection connection=null;
	static PreparedStatement ps=null;
	static String query=null;
	
	public boolean createUserStory(UserStoryModel userStory) throws USException {
		try {
			connection=DBUtil.getConnection();
			query="insert into user_story values (?,?,?,?,?,?);";
			ps= connection.prepareStatement(query);
			ps.setString(1, "US-"+userStory.getUScode());
			ps.setString(2, userStory.getUSname());
			ps.setString(3, userStory.getUSpriority());
			ps.setInt(4, userStory.getUSpoints());
			ps.setString(5, userStory.getUSstatus());
			ps.setString(6, userStory.getProject_code());
			int n=ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUserStory(UserStoryModel userStory) throws USException {
		try {
			
			connection=DBUtil.getConnection();
			query="update user_story set US_name=?,US_priority=?,US_points=?, US_status=? where US_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, userStory.getUSname());
			ps.setString(2, userStory.getUSpriority());
			ps.setInt(3, userStory.getUSpoints());
			ps.setString(4, userStory.getUSstatus());
			ps.setString(5, "US-"+userStory.getUScode());
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			throw new USException("Project not found!");
		}
	}
	
	public boolean updateUserStoryStatus(String usCode, String status) throws USException {
		try {
			
			connection=DBUtil.getConnection();
			query="update user_story set us_status=? where us_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, status);
			ps.setString(2, usCode);
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
		}catch(Exception e) {
			throw new USException("User Story not found!");
		}
	}
	
	public boolean deleteUserStory(String userStoryCode) throws USException {
		
		try {
			
			connection=DBUtil.getConnection();
			query="delete from user_story where us_code=?;";
			ps=connection.prepareStatement(query);
			ps.setString(1, "US-"+userStoryCode);
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			throw new USException("Project not found!!");
		}
	}
	
	public UserStoryModel getUserStoryById(String userStoryCode) throws USException {
		try {
			
			connection=DBUtil.getConnection();
			UserStoryModel userStory= new UserStoryModel();
			query="select * from user_story where us_code=?";
			ps= connection.prepareStatement(query);
			ps.setString(1, "US-"+userStoryCode);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				userStory= new UserStoryModel(rs.getString(1),rs.getNString(2),rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6));
			}
			ps.close();
			connection.close();
			if(userStory!=null)
				return userStory;
			return null;
		}catch(Exception e) {
			throw new USException("Project not found!!");
			
		}
	}
	
	public List<UserStoryModel> getUserStoryByProjectCode(String projectCode) throws USException{
		
		try {
			
			connection=DBUtil.getConnection();
			List<UserStoryModel> userStoryList= new ArrayList<UserStoryModel>();
			query="select * from user_story where project_code=?";
			ps= connection.prepareStatement(query);
			ps.setString(1, projectCode);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				UserStoryModel us= new UserStoryModel(rs.getString(1),rs.getNString(2),rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6));
				userStoryList.add(us);
			}
			ps.close();
			connection.close();
			if(userStoryList.size()>0)
				return userStoryList;
			return null;
			
		}catch(Exception e) {
			throw new USException("No user stories found for this project!!");
			
		}
	}
	
	public List<UserStoryModel> listUserStory() throws USException{
		
		try {
			
			connection=DBUtil.getConnection();
			List<UserStoryModel> userStoryList= new ArrayList<UserStoryModel>();
			query="select * from user_story";
			ps= connection.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				UserStoryModel us= new UserStoryModel(rs.getString(1),rs.getNString(2),rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6));
				userStoryList.add(us);
			}
			ps.close();
			connection.close();
			if(userStoryList.size()>0)
				return userStoryList;
			return null;
			
		}catch(Exception e) {
			throw new USException("No user stories found!!");
			
		}
	}
	
	
//	public static void main(String args[]) throws USException {
//		UserStoryModel userStory= new UserStoryModel("75645","LNS1212 Content change","Medium",2,"To Do","ABCB20246511");
//		System.out.println(listUserStory());
//	}
}
