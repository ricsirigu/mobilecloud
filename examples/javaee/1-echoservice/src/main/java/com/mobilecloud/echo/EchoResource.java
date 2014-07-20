package com.mobilecloud.echo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * A simple resource that echoes what receives as parameter.
 * 
 * @author Riccardo Sirigu
 */
@Path("/echo")
public class EchoResource {
    
    @GET
    public Response echo(@QueryParam("msg") String msg){
        return Response.ok(msg).build();
    }
    
}
