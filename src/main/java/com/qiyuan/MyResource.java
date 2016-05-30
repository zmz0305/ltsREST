package com.qiyuan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.qiyuan.database.LTSConnectionPool;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	LTSConnectionPool p = LTSConnectionPool.get();
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    
    @GET
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name) {
		String output = "Hi from Jersey REST Service: " + name;
		return output;
	}

}
