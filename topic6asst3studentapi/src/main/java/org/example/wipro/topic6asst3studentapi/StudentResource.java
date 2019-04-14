package org.example.wipro.topic6asst3studentapi;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.example.wipro.topic6asst3studentapi.model.StudentEntity;
import org.example.wipro.topic6asst3studentapi.repository.StudentRepository;




@Path("studentresource")
public class StudentResource {

	//endpoint-http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudent
    @GET
    @Path("/getStudent")
    @Produces(MediaType.APPLICATION_XML)
    public List<StudentEntity> getAllStudentInXML() {
        return StudentRepository.getAllStudent();
    }
    
    //endpont-http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudentById/{id}
    @GET
    @Path("/getStudentById/{studentId}")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity getStudentByIdPathParam(@PathParam(value = "studentId") String Id) {
        return StudentRepository.getStudentById(Id);
    }
    
    
   // endpoint-http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudentByIdQueryParam?studentId={value}
    @GET
    @Path("/getStudentByIdQueryParam")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity getStudentByIdQueryParam(@QueryParam(value = "studentId") String Id) {
        return StudentRepository.getStudentById(Id);
    }
    
    // http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudentByIdMatrixParam;studentId={value}
    @GET
    @Path("/getStudentByIdMatixParam")
    @Produces(MediaType.APPLICATION_XML)
    public StudentEntity getStudentByIdMatrixParam(@MatrixParam(value = "studentId") String Id) {
        return StudentRepository.getStudentById(Id);
    }
    
    @GET
    @Path("/getStudentsbyMark/{totalmark}")
    @Produces(MediaType.APPLICATION_XML)
    public List<StudentEntity> getStudentByMark(@PathParam(value = "totalmark") float mark) {
    	System.out.println(mark);
    	System.out.println(StudentRepository.getAllStudentsAboveMark(mark));
        return StudentRepository.getAllStudentsAboveMark(mark);
    }
    
    
    //endpoint-http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudentsbyMarkQueryParam?totalmark={value}
    @GET
    @Path("/getStudentsbyMarkQueryParam")
    @Produces(MediaType.APPLICATION_XML)
    public List<StudentEntity> getStudentByMarkQueryParam(@QueryParam(value = "totalmark") float mark) {
        return StudentRepository.getAllStudentsAboveMark(mark);
    }
    
    
    //endpont-http://localhost:9090/topic6asst3studentapi/webapi/studentresource/getStudentsbyMarkMatrixParam;totalmark={value}
    @GET
    @Path("/getStudentsbyMarkMatirxParam")
    @Produces(MediaType.APPLICATION_XML)
    public List<StudentEntity> getStudentByMarkMatrixParam(@MatrixParam(value = "totalmark") float mark) {
        return StudentRepository.getAllStudentsAboveMark(mark);
    }
    
}