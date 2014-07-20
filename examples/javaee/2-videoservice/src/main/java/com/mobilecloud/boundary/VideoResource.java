package com.mobilecloud.boundary;

import com.mobilecloud.entity.Video;
import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ejb.Singleton;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * A simple resource that accept requests for storing and retrieving
 * Video objects. In this example it's a singleton becouse it holds state.
 * In a real scenario VideoResource would interact with a database and 
 * could be made per-request, thus stateless. 
 * 
 * @author Riccardo Sirigu
 */
@Singleton
@Path("/videos")
public class VideoResource {
    
    private final Map<Integer, Video> videosDB = new ConcurrentHashMap<>();
    private final AtomicInteger videoId = new AtomicInteger();
    
    @GET
    public Response videos(){
        if(!videosDB.isEmpty()){
            Collection<Video> videos = videosDB.values();
            GenericEntity entity = new GenericEntity<Collection<Video>>(videos) {};
            return Response.ok(entity).build();
        }
        return Response.noContent().build();
    }
    
    @POST
    public Response addVideo(@Valid Video video, @Context UriInfo uriInfo){
        int id = videoId.incrementAndGet();
        videosDB.put(id, video);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(uri).build();
    }
    
}
