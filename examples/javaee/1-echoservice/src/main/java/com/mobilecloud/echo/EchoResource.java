package com.mobilecloud.echo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * A simple resource that echoes what receives as parameter.
 * 
 * @author Riccardo Sirigu
 */
@Path("/echo")
public class EchoResource {
    
    @GET
    @Path("{msg}")
    public Response echo(@PathParam("msg") String msg){
        return Response.ok(msg).build();
    }
    
}
