package com.prac.jira.Presentation;

import java.util.Scanner;

import com.prac.jira.Exception.DefectException;
import com.prac.jira.Exception.ProjectException;
import com.prac.jira.Exception.USException;

public class JiraMain {


	public JiraMain() throws ProjectException, USException, InterruptedException, DefectException {
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Welcome To Jira!!");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println();
			System.out.printf("1. Project\n2. User Story\n3. Defect\n4. Exit\n\n");
			System.out.print("Enter your choice: ");
			int choice= sc.nextInt();
			System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.printf("\n\n");
			
			switch(choice) {
			
			case 1:
				System.out.printf("\n\n");
				ProjectMain project= new ProjectMain();
				break;
			
			case 2:
				System.out.printf("\n\n");
				UserStoryMain userStory= new UserStoryMain();
				break;
				
			case 3:
				System.out.printf("\n\n");
				DefectsMain defect= new DefectsMain();
				break;
				
			case 4:
				System.out.println("GoodBye!!");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				System.out.printf("\n\n");
				break;
			}
		}
	}
	public static void main(String[] args) throws ProjectException, USException, InterruptedException, DefectException {
		// TODO Auto-generated method stub

		JiraMain jira= new JiraMain();
	}

}
