package org.example.wipro.topic6asst2studentapi.reposiotry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.example.wipro.topic6asst2studentapi.model.StudentEntity;



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
	
	public static StudentEntity createStudent(String studentId, String studentName, String studentClass, float tMark)
	{
		StudentEntity studentEntity = new StudentEntity(studentId, studentName, studentClass, tMark);
		if(studentEntities.add(studentEntity))
		{
			return studentEntity;
		}
		
		//if return null it means student not added succesfully
		return null;	
		
	}
	
	public static StudentEntity updateExistingStudent(String studentId, StudentEntity studEntity)
	{
		for(StudentEntity  e: studentEntities)
		{
			if(e.getStudentId().equals(studentId))
			{
				e.setStudentId(studEntity.getStudentId());
				e.setStudentName(studEntity.getStudentName());
				e.setStudentClass(studEntity.getStudentClass());
				e.setStudentTotalMarks(studEntity.getStudentTotalMarks());
				return e;
			}		
		}	
		//return null if there is no Student for given ID
		return null;
		
	}
	
	public static StudentEntity deleteStudentById(String id)
	{
		Iterator<StudentEntity> itr = studentEntities.iterator();
		while(itr.hasNext())
		{
			StudentEntity entity = (StudentEntity)itr.next();
			if(entity.getStudentId().equals(id))
			{
				itr.remove();
				return entity;
			}
		}
		//return null if there is no student for this id
		return null;
		
	}
}
