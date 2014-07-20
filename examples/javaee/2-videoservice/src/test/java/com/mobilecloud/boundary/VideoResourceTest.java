package com.mobilecloud.boundary;

import com.mobilecloud.entity.Video;
import javax.net.ssl.SSLEngineResult;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Riccardo Sirigu
 */
public class VideoResourceTest {
    
    private static final String targetUrl = "http://localhost:8080/2-videoservice/videos";
    private Client client;
    private WebTarget target;

    @Before
    public void setUp() {
        this.client = ClientBuilder.newClient();
        target = this.client.target(targetUrl);
    }
    
     @Test
     public void uploadVideo() {
     
         //POST
         Video video = new Video("Cool video", "www.youtube.com", 212);
         Response response = target.request(MediaType.APPLICATION_JSON)
                 .post(Entity.entity(video, MediaType.APPLICATION_JSON));

         assertThat(response.getStatus(), is(Status.CREATED.getStatusCode()));

     }
     
      @Test
     public void uploadBadUrlVideo() {
         
         //POST a video with a url size less than 10 characters
         Video video = new Video("Cool video", "www.y.com", 212);
         Response response = target.request(MediaType.APPLICATION_JSON)
                 .post(Entity.entity(video, MediaType.APPLICATION_JSON));

         assertThat(response.getStatus(), is(Status.BAD_REQUEST.getStatusCode()));

     }
     
     @Test
     public void uploadNoNameVideo() {
         
         //POST a video with a url size less than 10 characters
         Video video = new Video("", "www.youtube.com", 212);
         Response response = target.request(MediaType.APPLICATION_JSON)
                 .post(Entity.entity(video, MediaType.APPLICATION_JSON));

         assertThat(response.getStatus(), is(Status.BAD_REQUEST.getStatusCode()));

     }
     
     @Test
     public void uploadWrongDurationVideo() {
         
         //POST a video with a url size less than 10 characters
         Video video = new Video("Cool video", "www.youtube.com", 0);
         Response response = target.request(MediaType.APPLICATION_JSON)
                 .post(Entity.entity(video, MediaType.APPLICATION_JSON));

         assertThat(response.getStatus(), is(Status.BAD_REQUEST.getStatusCode()));

     }
}
