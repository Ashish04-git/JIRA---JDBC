package com.prac.jira.Service;

import java.util.ArrayList;
import java.util.List;

import com.prac.jira.Dao.UserStoryDao;
import com.prac.jira.Exception.USException;
import com.prac.jira.Model.UserStoryModel;

public class UserStoryService {
	
	UserStoryDao dao= new UserStoryDao();
	boolean flag;
	
	public boolean createUserStory(UserStoryModel userStory) throws USException {
		
		flag= dao.createUserStory(userStory);
		return flag;		
	}
	
	public boolean updateUserStory(UserStoryModel userStory) throws USException{
		
		flag= dao.updateUserStory(userStory);
		return flag;
	}
	
	public boolean updateUserStoryStatus(String usCode, String status) throws USException {
		
		flag= dao.updateUserStoryStatus(usCode, status);
		return flag;
	}
	
	public boolean deleteUserStory(String userStoryCode) throws USException {
		
		flag= dao.deleteUserStory(userStoryCode);
		return flag;
		
	}
	
	public UserStoryModel getUserStoryById(String userStoryCode) throws USException {
		
		UserStoryModel userStory= new UserStoryModel();
		userStory= dao.getUserStoryById(userStoryCode);
		return userStory;
	}
	
	public List<UserStoryModel> getUserStoryByProjectCode(String projectCode) throws USException{
		
		List<UserStoryModel> userStoryList= new ArrayList<UserStoryModel>();
		userStoryList= dao.getUserStoryByProjectCode(projectCode);
		return userStoryList;
	}
	
	public List<UserStoryModel> listUserStory() throws USException{
		
		List<UserStoryModel> userStoryList= new ArrayList<UserStoryModel>();
		userStoryList= dao.listUserStory();
		return userStoryList;
	}
}
