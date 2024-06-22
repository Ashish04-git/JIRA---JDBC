package com.prac.jira.Service;

import java.util.ArrayList;
import java.util.List;

import com.prac.jira.Dao.DefectsDao;
import com.prac.jira.Exception.DefectException;
import com.prac.jira.Model.DefectsModel;

public class DefectService {

	DefectsDao dao= new DefectsDao();
	boolean flag;
	
	public boolean createDefect(DefectsModel defect) throws DefectException {
		
		flag= dao.createDefect(defect);
		return flag;
	}
	
	public boolean updateDefect(DefectsModel defect) throws DefectException{
		
		flag= dao.updateDefect(defect);
		return flag;
	}
	
	public boolean updateDefectStatus(String status, Integer defectID) throws DefectException{
		
		flag= dao.updateDefectStatus(status, defectID);
		return flag;
	}
	
	public boolean deleteDefect(Integer defectId) throws DefectException {
		
		flag=dao.deleteDefect(defectId);
		return flag;
	}
	
	public DefectsModel showDefect(Integer defectID) throws DefectException {
		
		DefectsModel defect= new DefectsModel();
		defect= dao.showDefect(defectID);
		return defect;
	}
	
	public List<DefectsModel> listDefects() throws DefectException{
		
		List<DefectsModel> defectsList= new ArrayList<DefectsModel>();
		defectsList= dao.listDefects();
		return defectsList;
	}
	
	public List<DefectsModel> listDefectsOfUS(String US_code) throws DefectException{
		
		List<DefectsModel> defectsList= new ArrayList<DefectsModel>();
		defectsList= dao.listDefectsOfUS(US_code);
		return defectsList;
	}
}
