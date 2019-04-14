package client;

import java.util.Scanner;

import javax.ws.rs.core.Response;

import model.EmployeeEntity;


/*
 I have taken all the employee data(empid,emploaction,empBand,etc) according to the data that are stored in my database for testing purpose
 if any one they can choose according to themself
 */
public class TestClient {

	public static void main(String[] args) {
		
		
		JerseyRestClient restClient = new JerseyRestClient();
		Scanner scan = new Scanner(System.in);	
		
		String condition ="y";
		while(condition.equalsIgnoreCase("y"))
		{
			System.out.println("Press 1 for testing:- a. Retrieve all employee");
			System.out.println("Press 2 for testing:- b. Retrieve all employee details based on a particular empLocation");
			System.out.println("Press 3 for testing:- c. Retrieve all employee details based on a particular empBand");
			System.out.println("press 4 for testing:- d. Add a new Employee entry (“POST” method)");
			System.out.println("press 5 for testing:- e. Edit an existing Employee entry (“PUT” method)");
			System.out.println("press 6 for testing:- f. Deleting an existing Employee");
			int option = scan.nextInt();
			switch(option)
			{
				case 1:
					testConditionA(restClient);
					break;
				case 2:
					testConditionB(restClient, scan);
					break;
					
				case 3:
					testConditionC(restClient, scan);
					break;
				case 4:
					testConditionD(restClient);
					break;
				case 5 :
					testConditionE(restClient);
					break;
				case 6:
					testConditionF(restClient);
					break;
				default:
					System.out.println("please enter correct option");
					
			}
			System.out.println("if you want to test again anyother method press y else press any button");
			
			condition=scan.next();
		}
		
	}
		
		public static void  testConditionA(JerseyRestClient restClient)
		{
			System.out.println(restClient.getAllEmployee());
			
		}
		
		public static void  testConditionB(JerseyRestClient restClient, Scanner scan)
		{
			System.out.println("Enter location for getting all Employee for that location");
			String empLocation =scan.next();
			System.out.println(restClient.getAllEmployeeByLocation(empLocation));
			
		}
		
		public static void  testConditionC(JerseyRestClient restClient, Scanner scan)
		{
			System.out.println("Enter Band for getting all Employee for that Band");
			String empBand =scan.next();
			System.out.println(restClient.getAllEmployeeByBand(empBand));
			
		}
		
		public static void  testConditionD(JerseyRestClient restClient)
		{
			System.out.println(restClient.createEmployee(new EmployeeEntity("S10091","Rahul","Singh","Pune","B2")));
			
		}
		
		public static void  testConditionE(JerseyRestClient restClient)
		{
			
			//I have taken all the data according to data stored in my database
			EmployeeEntity empEntity = new EmployeeEntity(
					"EM00016","Rohit", "Kumar", "banglore", "B2");
			Response response =restClient.updateEmployeeById("EM00013", empEntity);
			System.out.println(response.readEntity(String.class));
			System.out.println(response.getStatus());
			
		}
		
		public static void  testConditionF(JerseyRestClient restClient)
		{
			//I ahve taken empid accoding to data that stored in my databse
			Response response = restClient.deleteEmployeeById("S10091");
			System.out.println(response.readEntity(String.class));
			System.out.println(response.getStatus());
			
		}
		
		
	}


