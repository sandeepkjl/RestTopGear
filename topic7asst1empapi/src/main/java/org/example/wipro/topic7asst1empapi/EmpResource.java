package org.example.wipro.topic7asst1empapi;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.example.wipro.topic7asst1empapi.model.EmployeeEntity;
import org.example.wipro.topic7asst1empapi.service.EmployeeServcie;

@Path("empresource")
public class EmpResource {
	
	
	// a. Retrieve all employee
	//endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/getEmployee
	@GET
	@Path("/getEmployee")
	@Produces({"application/xml", "application/json"})
	public List<EmployeeEntity> getAllEmployee()
	{
		return EmployeeServcie.getEmployee();
	}
	
	
	// b. Retrieve all employee details based on a particular “empLocation” 
	//endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/getEmployeeByLocation/{empLocationValue}
	@GET
	@Path("/getEmployeeByLocation/{empLocation}")
	@Produces({"application/xml", "application/json"})
	public List<EmployeeEntity> getAllEmployeeByLocation(@PathParam(value = "empLocation") String empLocation)
	{
		return EmployeeServcie.getEmployeesByLocation(empLocation);
	}
	
	// c. Retrieve all employee details based on a particular “empBand”
	//endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/getEmployeeByBand/{empBandValue}
	
	@GET
	@Path("/getEmployeeByBand/{empBand}")
	@Produces({"application/xml", "application/json"})
	public List<EmployeeEntity> getAllEmployeeByBand(@PathParam(value = "empBand") String empBand)
	{
		return EmployeeServcie.getEmployeesByBand(empBand);
	}
	
	
	// d. Add a new Employee entry (“POST” method).
	//Post Method endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/createEmployee
	@POST
	@Path("/createEmployee")
	@Produces({"application/xml", "application/json"})
	@Consumes(MediaType.APPLICATION_XML)
	public EmployeeEntity createNewEmployee(EmployeeEntity empEntity)
	{
		return EmployeeServcie.saveEmployeeDeatils(empEntity);
	}
	
	// e. Edit an existing Employee entry (“PUT” method).
	//endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/updateEmployee
	@PUT
	@Path("/updateEmployee/{empId}")
	@Produces({"application/xml", "application/json"})
	@Consumes(MediaType.APPLICATION_XML)
	public EmployeeEntity updateEmployee(@PathParam(value = "empId") String empId, EmployeeEntity empEntity)
	{
		return EmployeeServcie.updateEmployeeDeatils(empId, empEntity);
	}
	
	
	// f. Deleting an existing Employee
	// //endpoint-http://localhost:9090/topic7asst1empapi/webapi/empresource/deleteEmployee/{empIdValue}
	@DELETE
	@Path("/deleteEmployee/{empId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeById(@PathParam(value = "empId") String empId)
	{
		return EmployeeServcie.deleteEmployee(empId);
	}

}
