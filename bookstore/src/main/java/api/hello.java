package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class hello {
	@GET
	@Path("/print") 
    @Produces({ MediaType.APPLICATION_JSON })
	public String getHelloWorld() {
		return "Voici une api fonctionnelle";
	}
}
