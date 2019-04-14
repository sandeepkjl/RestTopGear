package org.example.wipro.topic6asst3studentapi.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.example.wipro.topic6asst3studentapi.model.StudentEntity;





public class StudentRepository {
	
	
static List<StudentEntity> studentEntities;
	
	static{
		
		studentEntities=new ArrayList<StudentEntity>();
		
		studentEntities.add(new StudentEntity("S001", "Ayush", "B1" , 90f));
		studentEntities.add(new StudentEntity("S002", "Rohan", "A1" , 95f));
		studentEntities.add(new StudentEntity("S003", "Sandeep", "C1" , 85f));
		studentEntities.add(new StudentEntity("S004", "Kajal", "A1" , 80f));
		
	}
	
	public static List<StudentEntity> getAllStudent()
	{
		return studentEntities;
	}
	
	public static StudentEntity getStudentById(String id)
	{
		for(StudentEntity  e: studentEntities)
		{
			if(e.getStudentId().equals(id))
			{
				return e;
			}
			
		}
		
		return null;
	}
	
	public static List<StudentEntity> getAllStudentsAboveMark(float mark)
	{
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		for(StudentEntity  e: studentEntities)
		{
			if(e.getStudentTotalMarks()>mark)
			{
				studentList.add(e);
			}
			
		}
		return studentList;
	}
	
}
