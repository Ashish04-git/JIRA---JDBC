package com.prac.jira.Presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.prac.jira.Exception.DefectException;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Exception.USException;
import com.prac.jira.Model.UserStoryModel;
import com.prac.jira.Service.ProjectService;
import com.prac.jira.Service.UserStoryService;

public class UserStoryMain {
	
	public UserStoryMain() throws USException, InterruptedException, ProjectException, DefectException {
		
		UserStoryService service= new UserStoryService();
//		ProjectService projectService= new ProjectService();
		UserStoryModel userStory;
		String userStoryCode, userStoryName, userStoryPriority, userStoryStatus, projectCode;
		Integer userStoryPoints;
		boolean flag;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("User Story");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("1. Create User Story\n2. Update User Story\n3. Update User Story Status\n4. Delete User Story\n5. User Story List\n6. User Story By ID\n7. User Story By Project Code\n8. Exit\n\n");
			System.out.print("Enter your choice: ");
			int choice= sc.nextInt();
			System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.printf("\n\n");
			
			switch(choice) {
			case 1:
				System.out.println("Create User Story");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code (Enter Existing US Code): ");
				userStoryCode= sc.next();
				System.out.println();
				System.out.print("Enter User Story Name: ");
				userStoryName=sc.next();
				System.out.println();
				System.out.print("Enter User Story Priority: ");
				userStoryPriority=sc.next();
				System.out.println();
				System.out.print("Enter User Story Points: ");
				userStoryPoints=sc.nextInt();
				System.out.println();
				System.out.print("Enter User Story Status: ");
				userStoryStatus=sc.next();
				System.out.println();
				System.out.print("Enter Project Code: ");
				projectCode=sc.next();
				System.out.println();
				userStory= new UserStoryModel(userStoryCode, userStoryName, userStoryPriority, userStoryPoints, userStoryStatus, projectCode);
				flag= service.createUserStory(userStory);
				TimeUnit.SECONDS.sleep(5);
				if(flag) {
					System.out.println("User Story Added Successfully!!");
				}else if(service.getUserStoryById(userStoryCode).getUScode()==userStoryCode) {
					System.out.println("User Story Already Exist!");
				}else {
					System.out.println("User Story Failed!");
				}
				System.out.printf("\n\n");
				break;
				
			case 2:
				System.out.println("Update User Story");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code: ");
				userStoryCode= sc.next();
				System.out.println();
				System.out.print("Enter User Stoy Name: ");
				userStoryName=sc.next();
				System.out.println();
				System.out.print("Enter User Stoy Priority: ");
				userStoryPriority=sc.next();
				System.out.println();
				System.out.print("Enter User Stoy Points: ");
				userStoryPoints=sc.nextInt();
				System.out.println();
				System.out.print("Enter User Stoy Status: ");
				userStoryStatus=sc.next();
				System.out.println();
				System.out.print("Enter Project Code: ");
				projectCode=sc.next();
				System.out.println();
				userStory= new UserStoryModel(userStoryCode, userStoryName, userStoryPriority, userStoryPoints, userStoryStatus, projectCode);
				flag= service.updateUserStory(userStory);
				TimeUnit.SECONDS.sleep(5);
				if(flag) {
					System.out.println("User Story Updated Successfully!!");
				}else if(service.getUserStoryById(projectCode).getUScode()!=userStoryCode) {
					System.out.println("User Story does not exist!");
				}else {
					System.out.println("Unable to update user story");
				}
				System.out.printf("\n\n");
				
				break;
				
			case 3:
				System.out.println("Update User Story Status");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code: ");
				userStoryCode= sc.next();
				System.out.println();
				System.out.print("Enter User Stoy Status: ");
				userStoryStatus=sc.next();
				System.out.println();
				flag= service.updateUserStoryStatus(userStoryCode, userStoryStatus);
				TimeUnit.SECONDS.sleep(5);
				if(flag) {
					System.out.println("Status Updated Successfully!");
				}else {
					System.out.println("Project Not Found!");
				}
				System.out.printf("\n\n");
				
				break;
			
			case 4:
				System.out.println("Delete User Story");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code: ");
				userStoryCode= sc.next();
				System.out.println();
				flag= service.deleteUserStory(userStoryCode);
				TimeUnit.SECONDS.sleep(5);
				if(flag) {
					System.out.println("User Story Deleted Successfully!");
				}else if(service.getUserStoryById(userStoryCode) == null) {
					System.out.println("No User Story Found!");
				}else {
					System.out.println("Unable to delete User Story");
				}
				System.out.printf("\n\n");
				
				break;
			
			case 5:
					List<UserStoryModel> userStoryList= new ArrayList<UserStoryModel>();
					userStoryList= service.listUserStory();
					
					if(userStoryList.size()>0) {
						System.out.println("User Story List");
						System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
						for(UserStoryModel userStorys:userStoryList) {
							System.out.println("US Code: "+userStorys.getUScode()+"| US Name: "+userStorys.getUSname()+"| US Priority: "+userStorys.getUSpriority()+"| US Points: "+userStorys.getUSpoints()+"| US Status: "+userStorys.getUSstatus()+"| Project Code: "+userStorys.getProject_code());
						}
						
					}else {
						System.out.println("No user stories found!");
					}
					TimeUnit.SECONDS.sleep(5);
					System.out.printf("\n\n");
					
					break;
					
			case 6:
				System.out.println("User Story By ID");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code: ");
				userStoryCode= sc.next();
				System.out.println();
				userStory= service.getUserStoryById(userStoryCode);
				if(userStory!=null) {
					System.out.println("US Code: "+userStory.getUScode()+"| US Name: "+userStory.getUSname()+"| US Priority: "+userStory.getUSpriority()+"| US Points: "+userStory.getUSpoints()+"| US Status: "+userStory.getUSstatus()+"| Project Code: "+userStory.getProject_code());
				}else {
					System.out.println("No user stories found!");
				}
				TimeUnit.SECONDS.sleep(5);
				
				System.out.printf("\n\n");
				
				break;
				
			case 7:
					System.out.println("User Story By Project Code");
					System.out.printf("--------------------------------------------------------------------------------------\n\n");
					System.out.print("Enter Project Code: ");
					projectCode= sc.next();
					System.out.println();
					List<UserStoryModel> userStoryLists= new ArrayList<UserStoryModel>();
					userStoryLists= service.getUserStoryByProjectCode(projectCode);
					if(userStoryLists.size()>0) {
						for (UserStoryModel userStorys:userStoryLists) {
							System.out.println("US Code: "+userStorys.getUScode()+"| US Name: "+userStorys.getUSname()+"| US Priority: "+userStorys.getUSpriority()+"| US Points: "+userStorys.getUSpoints()+"| US Status: "+userStorys.getUSstatus()+"| Project Code: "+userStorys.getProject_code());
						}
					}else {
						System.out.println("No user stories found!");
					}
					TimeUnit.SECONDS.sleep(5);
				
					System.out.printf("\n\n");
				
					break;
			
			case 8:

				System.out.printf("\n\n");
				JiraMain jiraMain= new JiraMain();
				
			default:
				System.out.println("Invalid choice!");
				System.out.printf("\n\n");
				break;
			}
			
		}
	}
	
	
	

}
