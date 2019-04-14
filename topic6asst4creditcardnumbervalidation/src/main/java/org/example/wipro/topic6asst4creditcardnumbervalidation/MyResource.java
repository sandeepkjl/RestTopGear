package org.example.wipro.topic6asst4creditcardnumbervalidation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("cardresource")
public class MyResource {

	
	//endponit:- http://localhost:9090/topic6asst4creditcardnumbervalidation/webapi/cardresource/validteCreditCard?cardNumber={cardNumber}
    @GET
    @Path("/validteCreditCard")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean validateCreditCard(@QueryParam(value = "cardNumber") long creditCardNumber) {
    	if(creditCardNumber%2==0)
    		return true;
    	else
    		return false;
    }
}
