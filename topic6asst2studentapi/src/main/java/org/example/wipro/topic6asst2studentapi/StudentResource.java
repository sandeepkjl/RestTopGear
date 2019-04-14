package org.example.wipro.topic6asst2studentapi;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.wipro.topic6asst2studentapi.model.StudentEntity;
import org.example.wipro.topic6asst2studentapi.reposiotry.StudentRepository;



@Path("studentresource")
public class StudentResource {
	
	//1. “GET” method that returns all the existing student details in XML/JSON format
	//endpoint:- http://localhost:9090/topic6asst2studentapi/webapi/studentresource/getStudent
	@GET
    @Path("/getStudent")
    @Produces({"application/xml", "application/json"})
    public List<StudentEntity> getAllStudentInTextXML() {
        return StudentRepository.getAllStudent();
    }
    
	
	// 2. “GET” student based on studentId
	//enpoint:- http://localhost:9090/topic6asst2studentapi/webapi/studentresource/getStudentById/{studIdValue}
    @GET
    @Path("/getStudentById/{studentId}")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity getStudentByID(@PathParam(value = "studentId") String Id) {
        return StudentRepository.getStudentById(Id);
    }
    
    
    // 3. “GET” student have mark greater than passed mark
    //http://localhost:9090/topic6asst2studentapi/webapi/studentresource/getStudentsbymark/{markValue}
    @GET
    @Path("/getStudentsbymark/{totalmark}")
    @Produces(MediaType.APPLICATION_XML)
    public List<StudentEntity> getStudentByMark(@PathParam(value = "totalmark") float mark) {
    	System.out.println(mark);
    	System.out.println(StudentRepository.getAllStudentsAboveMark(mark));
        return StudentRepository.getAllStudentsAboveMark(mark);
    }
    
    
    //4.  “POST” method that allows us to insert/add a new student entry Student details are passed through a form.
    //endpoint:- http://localhost:9090/topic6asst2studentapi/webapi/studentresource/createStudent.
    @POST
    @Path("/createStudent")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity createNewStudent(@FormParam(value = "studentId") String studentId,
    		                              @FormParam(value = "studentName") String studentName,
    		                              @FormParam(value = "studentClass") String studentClass,
    		                              @FormParam(value = "studentTotalMark") float totalMarks){
    	
    	
    	return StudentRepository.createStudent(studentId, studentName, studentClass, totalMarks);
    	
    }
    
    
    // 5. “PUT” method that allows us to update/edit an existing student.
    /*
     *endpoint:-http://localhost:9090/topic6asst2studentapi/webapi/studentresource/updateStudent/{studIdValue}
     *In your RestCLient pass header content-type as application/xml.
     *and pass a StudentEntity requestBody in Xml format.
     * */
    @PUT
    @Path("/updateStudent/{studentId}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public StudentEntity updateStudent(@PathParam(value = "studentId") String studentId, StudentEntity studentEntity){
    	
    	
    	return StudentRepository.updateExistingStudent(studentId, studentEntity);
    	
    }
    
    //5. “DELETE” method that allows us to delete an existing student entry
    //endpoint http://localhost:9090/topic6asst2studentapi/webapi/studentresource/deleteStudent/{studIdValue}
    @DELETE
    @Path("/deleteStudent/{studentId}")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity deleteStudent(@PathParam("studentId") String id)
    {
    	return  StudentRepository.deleteStudentById(id);
    	    	
    }

}
