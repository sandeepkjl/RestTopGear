package org.example.wipro.topic7asst1empapi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.wipro.topic7asst1empapi.dbutil.DBUtil;
import org.example.wipro.topic7asst1empapi.model.EmployeeEntity;
public class EmployeeServcie {
	
	public static  PreparedStatement pstmt =null;
	
	public static List<EmployeeEntity> getEmployee()
	{
		Connection con=DBUtil.getDBConnection();

		List<EmployeeEntity> empEntities = new ArrayList<EmployeeEntity>();
		try {
			pstmt= con.prepareStatement("Select * from Employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String empId = rs.getString(1);		    	
				String empFirstName = rs.getString(2);
				String empLastName = rs.getString(3);
				String empLocation = rs.getString(4);
			    String empBand = rs.getString(5);
			    
			    empEntities.add(new EmployeeEntity(empId, empFirstName, empLastName, empLocation, empBand));
			}
		    	
			return empEntities;
		} 
			catch (SQLException e) {
			e.printStackTrace();
			return empEntities;
		
		}
	}
		
	public static List<EmployeeEntity> getEmployeesByLocation(String employeeLocation)
	{
		Connection con=DBUtil.getDBConnection();

		List<EmployeeEntity> empEntities = new ArrayList<EmployeeEntity>();
		try {
			pstmt= con.prepareStatement("Select * from Employee where empLocation=?");
			pstmt.setString(1, employeeLocation);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String empId = rs.getString(1);		    	
				String empFirstName = rs.getString(2);
				String empLastName = rs.getString(3);
				String empLocation = rs.getString(4);
			    String empBand = rs.getString(5);
			    
			    empEntities.add(new EmployeeEntity(empId, empFirstName, empLastName, empLocation, empBand));
			}
		    	
			return empEntities;
		} 
			catch (SQLException e) {
			e.printStackTrace();
			return empEntities;
		
		}
	}
	
	public static List<EmployeeEntity> getEmployeesByBand(String employeeBand)
	{
		Connection con=DBUtil.getDBConnection();

		List<EmployeeEntity> empEntities = new ArrayList<EmployeeEntity>();
		try {
			pstmt= con.prepareStatement("Select * from Employee where empBand=?");
			pstmt.setString(1, employeeBand);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String empId = rs.getString(1);		    	
				String empFirstName = rs.getString(2);
				String empLastName = rs.getString(3);
				String empLocation = rs.getString(4);
			    String empBand = rs.getString(5);
			    
			    empEntities.add(new EmployeeEntity(empId, empFirstName, empLastName, empLocation, empBand));
			}
		    	
			return empEntities;
		} 
			catch (SQLException e) {
			e.printStackTrace();
			return empEntities;
		
		}
	}
	
	//save a new employee Record
		public static EmployeeEntity saveEmployeeDeatils(EmployeeEntity empEntity)
		{
			try {
				
				Connection con = DBUtil.getDBConnection();
				
			    pstmt= con.prepareStatement("insert into Employee values(?,?,?,?,?)");
				
				//saving customer Record;
			    pstmt.setString(1, empEntity.getEmpId());
			    pstmt.setString(2, empEntity.getEmpFirstName());
			    pstmt.setString(3, empEntity.getEmpLastName());
			    pstmt.setString(4, empEntity.getEmpLocation());
			    pstmt.setString(5, empEntity.getEmpBand());
				
			    
			    pstmt.executeUpdate();
			    
			    pstmt.close();
			    con.close();
				return empEntity;
			} catch (SQLException e) {
				System.out.println(e);
				//return null if there i error in saving data
				return null;
			}
			
		}
		
		//update employee by Id
		public static EmployeeEntity updateEmployeeDeatils(String id,EmployeeEntity empEntity)
		{
			try {
				
				Connection con = DBUtil.getDBConnection();
				
			    pstmt= con.prepareStatement("update Employee set empId=?, empFirstName=? , empLastName=?, empLocation=?, empBand=? where empId=?");
				
				//updating customer Record;
			    pstmt.setString(1, empEntity.getEmpId());
			    pstmt.setString(2, empEntity.getEmpFirstName());
			    pstmt.setString(3, empEntity.getEmpLastName());
			    pstmt.setString(4, empEntity.getEmpLocation());
			    pstmt.setString(5, empEntity.getEmpBand());
			    
			    pstmt.setString(6,id );
				
			    
			    pstmt.executeUpdate();
			    
			    pstmt.close();
			    con.close();
				return empEntity;
			} catch (SQLException e) {
				System.out.println(e);
				//return null if there is  error in updating data
				return null;
			}
			
		}
		
		
		//delete employee by Id
		public static String deleteEmployee(String empId)
		 {
			try {
						
					Connection con = DBUtil.getDBConnection();
						
					  pstmt= con.prepareStatement("delete from employee where empId=?");
						
						//saving customer Record;
					    pstmt.setString(1, empId);
				
					    if(pstmt.executeUpdate()>0)
					    {
					    	return "deleted succesfully";
					    }
					    
					    
					    pstmt.close();
					    con.close();
						return "Error in deleting";
					} catch (SQLException e) {
						System.out.println(e);
						//return null if there is  error in deleting data
						return "Error in deleting";
					}
					
				}
				


}
