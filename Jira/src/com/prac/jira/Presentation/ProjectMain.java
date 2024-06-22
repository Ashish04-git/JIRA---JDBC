package com.prac.jira.Presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prac.jira.Exception.DefectException;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Exception.USException;
import com.prac.jira.Model.ProjectModel;
import com.prac.jira.Service.ProjectService;

public class ProjectMain {

	
	public ProjectMain() throws ProjectException, USException, InterruptedException, DefectException {
		
		ProjectService service= new ProjectService();
		ProjectModel project;
		String projectCode, projectName, projectStartDate, projectEndDate, projectStatus;
		boolean flag;
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Project");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("1. Create Project\n2. Update Project\n3. Update Project Status\n4. Delete Project\n5. Project List\n6. Project By ID\n7. Exit\n\n");
			System.out.print("Enter your choice: ");
			int choice= sc.nextInt();
			System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.printf("\n\n");
			
			
			switch(choice) {
			
			case 1: 
					System.out.println("Create Project");
					System.out.printf("--------------------------------------------------------------------------------------\n\n");
					System.out.print("Enter Project Code: ");
					projectCode= sc.next();
					System.out.println();
					System.out.print("Enter Project Name: ");
					projectName= sc.next();
					System.out.println();
					System.out.print("Enter Project Start Date (In DD/MM/YYYY): ");
					projectStartDate= sc.next();
					System.out.println();
					System.out.print("Enter Project End Date (In DD/MM/YYYY): ");
					projectEndDate= sc.next();
					System.out.println();
					
					project= new ProjectModel(projectCode, projectName, projectStartDate, projectEndDate, "To Do");
					flag= service.createProject(project);
					if(flag) {
						System.out.println("Project Added Successfully!!");
					}else if(service.getProjectById(projectCode).getProjectCode()==projectCode) {
						System.out.println("Project Already Exist!");
					}else {
						System.out.println("Project Failed!");
					}
					System.out.printf("\n\n");
					
					break;
			case 2:
					System.out.println("Update Project");
					System.out.printf("--------------------------------------------------------------------------------------\n\n");
					System.out.print("Enter Project Code (Enter Existing Project Code): ");
					projectCode= sc.next();
					System.out.println();
					System.out.print("Enter Project Name: ");
					projectName= sc.next();
					System.out.println();
					System.out.print("Enter Project Start Date (In DD/MM/YYYY): ");
					projectStartDate= sc.next();
					System.out.println();
					System.out.print("Enter Project End Date (In DD/MM/YYYY): ");
					projectEndDate= sc.next();
					System.out.println();
					System.out.print("Enter Project Status: ");
					projectStatus= sc.next();
					System.out.println();
					
					project= new ProjectModel(projectCode, projectName, projectStartDate, projectEndDate, projectStatus);
					flag= service.updateProject(project);
					if(flag) {
						System.out.println("Project Updated Successfully!!");
					}else if(service.getProjectById(projectCode).getProjectCode()!=project.getProjectCode()) {
						System.out.println("Project does not exist!");
					}else {
						System.out.println("Unable to update project");
					}
					System.out.printf("\n\n");
					
					break;
					
			case 3:
					System.out.println("Update Project Status");
					System.out.printf("--------------------------------------------------------------------------------------\n\n");
					System.out.print("Enter Project Code: ");
					projectCode= sc.next();
					System.out.println();
					System.out.print("Enter Project Status: ");
					projectStatus= sc.next();
					System.out.println();
					flag= service.updateProjectStatus(projectStatus, projectCode);
					if(flag) {
						System.out.println("Project Updated Successfully!!");
					}else {
						System.out.println("Unable to update project");
					}
					System.out.printf("\n\n");
				
					break;
				
			case 4:
					System.out.println("Delete Project");
					System.out.printf("--------------------------------------------------------------------------------------\n\n");
					System.out.print("Enter Project Code: ");
					projectCode= sc.next();
					System.out.println();
					flag= service.deleteProject(projectCode);
					if(flag) {
						System.out.println("Project Deleted Successfully!!");
					}else {
						System.out.println("Project Not Found!");
					}
					System.out.printf("\n\n");
				
					break;
				
			case 5:
					List<ProjectModel> projectList= new ArrayList<ProjectModel>();
					projectList= service.listAllProjects();
//					System.out.printf("Project_code\tProject_name\t\tProject_startdate\tProject_enddate\t\tProject_status\n");
//					System.out.printf("--------------------------------------------------------------------------------------\n");
					if(projectList.size()>0) {
						System.out.println("Project List");
						System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
						for(ProjectModel projects:projectList) {
	//						System.out.printf(projects.getProjectCode()+"\t"+projects.getProjectName()+"\t\t"+projects.getProject_startDate()+"\t"+projects.getProject_endDate()+"\t"+projects.getProject_status()+"\n");
							System.out.println("Project Code : "+projects.getProjectCode()+"| Project Name : "+projects.getProjectName()+"| Project Start Date : "+projects.getProject_startDate()+"| Project End Date : "+projects.getProject_endDate()+"| Project Status : "+projects.getProject_status());
						}
					}else {
						System.out.println("No projects found!");
					}
					System.out.printf("\n\n");
					
					break;
					
			case 6:
				System.out.print("Enter Project Code: ");
				projectCode= sc.next();
				System.out.println();
				
				project= new ProjectModel();
				project=service.getProjectById(projectCode);
				if(project!=null) {
					System.out.println("Project Code : "+project.getProjectCode()+"| Project Name : "+project.getProjectName()+"| Project Start Date : "+project.getProject_startDate()+"| Project End Date : "+project.getProject_endDate()+"| Project Status : "+project.getProject_status());
				}else {
					System.out.println("No projects found!");
				}
				System.out.printf("\n\n");
				
				break;
				
				
			case 7: 
					System.out.printf("\n\n");
					JiraMain jiraMain= new JiraMain();
					
			default:
				System.out.println("Invalid choice!");
				System.out.printf("\n\n");
				break;
			}
		
		
		}
		

	}
	public static void main(String args[]) throws ProjectException, USException, InterruptedException, DefectException {
		
		ProjectMain project= new ProjectMain();
	}
	
	
}
