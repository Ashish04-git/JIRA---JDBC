package com.prac.jira.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prac.jira.Connection.DBUtil;
import com.prac.jira.Exception.DefectException;
import com.prac.jira.Model.DefectsModel;

public class DefectsDao {

	static Connection connection=null;
	static String query;
	static PreparedStatement ps;
	
	public boolean createDefect(DefectsModel defect) throws DefectException {
		
		try {
			
			connection= DBUtil.getConnection();
			query="insert into defects values (?,?,?,?,?);";
			ps=connection.prepareStatement(query);
			ps.setInt(1, defect.getDefectID());
			ps.setString(2, defect.getDefectDesc());
			ps.setString(3, defect.getDefectpriority());
			ps.setString(4, "To Do");
			ps.setString(5, "US-"+defect.getUScode());
			int n=ps.executeUpdate();
			System.out.println(n);
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			throw new DefectException("Unable to create defect");
		}
	}
	
	public boolean updateDefect(DefectsModel defect) throws DefectException {
		try {
			connection=DBUtil.getConnection();
			query="update defects set defect_desc=?, defect_priority=?, defect_status=?, US_code=? where defect_id=?;";
			ps= connection.prepareStatement(query);
			ps.setString(1, defect.getDefectDesc());
			ps.setString(2, defect.getDefectpriority());
			ps.setString(3, defect.getDefectstatus());
			ps.setString(4, defect.getUScode());
			ps.setInt(5, defect.getDefectID());
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			throw new DefectException("Defect not found!!");
			//e.printStackTrace();
		}
	}
	
	public boolean updateDefectStatus(String status, Integer defectID) throws DefectException{
		
		try {
			
			connection=DBUtil.getConnection();
			query="update defects set defect_status=? where defect_id=?;";
			ps= connection.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, defectID);
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
			
		}catch(Exception e) {
			throw new DefectException("Defect not found!!");
		}
	}
	
	public boolean deleteDefect(Integer defectId) throws DefectException {
		try {
			
			connection= DBUtil.getConnection();
			query="delete from defects where defect_ID=?";
			ps= connection.prepareStatement(query);
			ps.setInt(1, defectId);
			int n= ps.executeUpdate();
			ps.close();
			connection.close();
			if(n>0)
				return true;
			return false;
			
		}catch(Exception e) {
			throw new DefectException("Defect not found!!");
		}
	}
	
	public DefectsModel showDefect(Integer defectID) throws DefectException {
		try {
			connection=DBUtil.getConnection();
			DefectsModel defect= new DefectsModel();
			query="select * from defects where Defect_id=?";
			ps.setInt(1, defectID);
			ps= connection.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				defect= new DefectsModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
			if(defect!=null)
				return defect;
			return null;
		}catch(Exception e) {
			throw new DefectException("Unable to find project");
		}
		
	}
	
	
	public List<DefectsModel> listDefects() throws DefectException{
		
		try {
			
			connection= DBUtil.getConnection();
			List<DefectsModel> defectsList= new ArrayList<DefectsModel>();
			query="select * from defects;";
			ps= connection.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				DefectsModel defect= new DefectsModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				defectsList.add(defect);
			}
			ps.close();
			connection.close();
			if(defectsList.size()>0)
				return defectsList;
			return null;
			
		}catch(Exception e) {
			throw new DefectException("No Defects found!!");
		}
	}
	
	public List<DefectsModel> listDefectsOfUS(String US_code) throws DefectException{
		
		try {
			connection= DBUtil.getConnection();
			List<DefectsModel> defectsList= new ArrayList<DefectsModel>();
			query="select * from defects where us_code=?;";
			ps= connection.prepareStatement(query);
			ps.setString(1, US_code);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				DefectsModel defect= new DefectsModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				defectsList.add(defect);
			}
			ps.close();
			connection.close();
			if(defectsList.size()>0)
				return defectsList;
			return null;
			
		}catch(Exception e) {
			throw new DefectException("No Defects found!!");
		}
	}
	
	
	
//	public static void main(String args[]) throws DefectException {
//		
//		DefectsModel defect= new DefectsModel(5656, "Invalid MA para", "High", "Accepted", "US-75645");
//		System.out.println(listDefectsOfUS("US-75645"));
//	}
}
