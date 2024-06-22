package com.prac.jira.Presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.prac.jira.Exception.DefectException;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Exception.USException;
import com.prac.jira.Model.DefectsModel;
import com.prac.jira.Service.DefectService;

public class DefectsMain {

	DefectService service= new DefectService();
	DefectsModel defect;
	String defectDesc, defectPriority, defectStatus, userStoryCode;
	Integer defectID;
	boolean flag;
	Scanner sc= new Scanner(System.in);
	
	public DefectsMain() throws InterruptedException, DefectException, ProjectException, USException {
		
		while(true) {
			System.out.println("Defects");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("1. Create Defect\n2. Update Defect\n3. Update Defect Status\n4. Delete Defect\n5. List Defects\n6. List Defects By US\n7. Exit\n\n");
			System.out.print("Enter your choice: ");
			int choice= sc.nextInt();
			System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.printf("\n\n");
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Create Defect");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter Defect ID: ");
				defectID= sc.nextInt();
				System.out.println();
				System.out.print("Enter Defect Description: ");
				defectDesc= sc.next();
				System.out.println();
				System.out.print("Enter Defect Priority: ");
				defectPriority= sc.next();
				System.out.println();
				System.out.print("Enter Defect Status: ");
				defectStatus= sc.next();
				System.out.println();
				System.out.print("Enter US Code: ");
				userStoryCode= sc.next();
				System.out.println();
				
				defect= new DefectsModel(defectID, defectDesc, defectPriority, defectStatus, userStoryCode);
				flag= service.createDefect(defect);
				if(flag) {
					System.out.println("Defect Added Successfully!");
				}else if(service.showDefect(defectID)!=null) {
					System.out.println("Defect Already Exist");
				}else {
					System.out.println("Unable to add defect");
				}
				TimeUnit.SECONDS.sleep(5);
				System.out.printf("\n\n");
				
				break;
				
			case 2:
				
				System.out.println("Update Defect");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter Defect ID (Enter Existing Defect ID): ");
				defectID= sc.nextInt();
				System.out.println();
				System.out.print("Enter Defect Description: ");
				defectDesc= sc.next();
				System.out.println();
				System.out.print("Enter Defect Priority: ");
				defectPriority= sc.next();
				System.out.println();
				System.out.print("Enter Defect Status: ");
				defectStatus= sc.next();
				System.out.println();
				System.out.print("Enter US Code: ");
				userStoryCode= sc.next();
				System.out.println();
				
				defect= new DefectsModel(defectID, defectDesc, defectPriority, defectStatus, userStoryCode);
				flag= service.updateDefect(defect);
				if(flag) {
					System.out.println("Defect Updated Successfully!");
				}else if(service.showDefect(defectID)==null) {
					System.out.println("No Defect Found with ID "+defectID);
				}else {
					System.out.println("Unable to updae defect");
				}
				TimeUnit.SECONDS.sleep(5);
				System.out.printf("\n\n");
				
				break;
				
			case 3:
				
				System.out.println("Update Defect Status");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter Defect ID: ");
				defectID= sc.nextInt();
				System.out.println();
				System.out.print("Enter Defect Status: ");
				defectStatus= sc.next();
				System.out.println();
				
				flag= service.updateDefectStatus(defectStatus, defectID);
				if(flag) {
					System.out.println("Defect Status Updated Successfully!");
				}else if(service.showDefect(defectID)==null) {
					System.out.println("No Defect Found with ID "+defectID);
				}else {
					System.out.println("Unable to updae defect");
				}
				TimeUnit.SECONDS.sleep(5);
				System.out.printf("\n\n");
				
				break;
				
			case 4:
				System.out.println("Delete Defect");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter Defect ID: ");
				defectID= sc.nextInt();
				System.out.println();
				
				flag= service.deleteDefect(defectID);
				if(flag) {
					System.out.println("Defect Deleted Successfully!");
				}else if(service.showDefect(defectID)==null) {
					System.out.println("No Defect Found with ID "+defectID);
				}else {
					System.out.println("Unable to updae defect");
				}
				TimeUnit.SECONDS.sleep(5);
				System.out.printf("\n\n");
				
				break;
			
			case 5:
				
				List<DefectsModel> defectsList= new ArrayList<DefectsModel>();
				defectsList= service.listDefects();
				if(defectsList.size()>0) {
					System.out.println("Defects List");
					System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
					for(DefectsModel defect:defectsList) {
						System.out.println("Defect ID: "+defect.getDefectID()+"| Defect Desc: "+defect.getDefectDesc()+"| Defect Priority: "+defect.getDefectpriority()+"| Defect Status: "+defect.getDefectstatus()+"| US Code: "+defect.getUScode());
					}
				}else {
					System.out.println("No Defects Found!");
				}
				TimeUnit.SECONDS.sleep(5);
				System.out.printf("\n\n");
				
				break;
				
			case 6:
				
				System.out.println("Defects List By US Code");
				System.out.printf("--------------------------------------------------------------------------------------\n\n");
				System.out.print("Enter User Story Code: ");
				userStoryCode= sc.next();
				System.out.println();
				List<DefectsModel> defectsLists= new ArrayList<DefectsModel>();
				defectsLists= service.listDefects();
				if(defectsLists.size()>0) {
					System.out.println("Defects List");
					System.out.printf("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
					for(DefectsModel defect:defectsLists) {
						System.out.println("Defect ID: "+defect.getDefectID()+"| Defect Desc: "+defect.getDefectDesc()+"| Defect Priority: "+defect.getDefectpriority()+"| Defect Status: "+defect.getDefectstatus()+"| US Code: "+defect.getUScode());
					}
				}else {
					System.out.println("No Defects Found!");
				}
				TimeUnit.SECONDS.sleep(5);
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

}
