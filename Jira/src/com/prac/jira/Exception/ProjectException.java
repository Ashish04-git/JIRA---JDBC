package com.prac.jira.Exception;

public class ProjectException extends Exception{
	
	public ProjectException(String str) {
//		super(str);
		super.getMessage();
		System.out.println(str);
	}

}
