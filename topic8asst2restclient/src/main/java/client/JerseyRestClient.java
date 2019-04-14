package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.EmployeeEntity;

public class JerseyRestClient {
	
	private static final String REST_URI = "http://localhost:9090/topic7asst1empapi";
	
	private Client client = ClientBuilder.newClient();
	
	//Test- a. Retrieve all employee
	public String getAllEmployee() {
        return client
          .target(REST_URI)
          .path("webapi/empresource/getEmployee")
          .request(MediaType.APPLICATION_XML)
          .get()
          .readEntity(String.class);
    }
	
	//Test-  b. Retrieve all employee details based on a particular “empLocation”
	public String getAllEmployeeByLocation(String empLocation) {
        return client
          .target(REST_URI)
          .path("webapi/empresource/getEmployeeByLocation").path(empLocation)
          .request(MediaType.APPLICATION_XML)
          .get()
          .readEntity(String.class);
    }
	
	//Test- c. Retrieve all employee details based on a particular “empBand”
	public String getAllEmployeeByBand(String empBand) {
        return client
          .target(REST_URI)
          .path("webapi/empresource/getEmployeeByBand").path(empBand)
          .request(MediaType.APPLICATION_XML)
          .get()
          .readEntity(String.class);
    }
	
	
	//Test d. Add a new Employee entry (“POST” method).
	public EmployeeEntity createEmployee(EmployeeEntity empEntity) {
        return client
          .target(REST_URI)
          .path("webapi/empresource/createEmployee")
          .request(MediaType.APPLICATION_XML)
          .post(Entity.entity(empEntity, MediaType.APPLICATION_XML))
          .readEntity(EmployeeEntity.class);
    }

	// Test e. Edit an existing Employee entry (“PUT” method).
	public Response updateEmployeeById(String empId,EmployeeEntity empEntity) {
        return client
          .target(REST_URI)
          .path("webapi/empresource/updateEmployee").path(empId)
          .request(MediaType.APPLICATION_XML)
          .put(Entity.entity(empEntity, MediaType.APPLICATION_XML));
          
    }
	

	//Test f. Deleting an existing Employee
	public Response deleteEmployeeById(String empId) {
        return client
          .target(REST_URI)
          .path("webapi/empresource/deleteEmployee").path(empId)
          .request(MediaType.TEXT_PLAIN)
          .delete();
          
    }
	

}
