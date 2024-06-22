package com.prac.jira.Model;

public class DefectsModel {

	private String  DefectDesc, Defectpriority,Defectstatus,UScode;
	private Integer DefectID;

	public DefectsModel(Integer defectID, String defectDesc, String defectpriority, String defectstatus, String uScode) {
		super();
		DefectID = defectID;
		DefectDesc = defectDesc;
		Defectpriority = defectpriority;
		Defectstatus = defectstatus;
		UScode = uScode;
	}

	public DefectsModel() {
		super();
	}

	public Integer getDefectID() {
		return DefectID;
	}

	public void setDefectID(Integer defectID) {
		DefectID = defectID;
	}

	public String getDefectDesc() {
		return DefectDesc;
	}

	public void setDefectDesc(String defectDesc) {
		DefectDesc = defectDesc;
	}

	public String getDefectpriority() {
		return Defectpriority;
	}

	public void setDefectpriority(String defectpriority) {
		Defectpriority = defectpriority;
	}

	public String getDefectstatus() {
		return Defectstatus;
	}

	public void setDefectstatus(String defectstatus) {
		Defectstatus = defectstatus;
	}

	public String getUScode() {
		return UScode;
	}

	public void setUScode(String uScode) {
		UScode = uScode;
	}

	@Override
	public String toString() {
		return "DefectsModel [ DefectID=" + DefectID + ", DefectDesc=" + DefectDesc + ", Defectpriority=" + Defectpriority + ", Defectstatus="
				+ Defectstatus + ", UScode=" + UScode + "]";
	}
	
	
	
}
