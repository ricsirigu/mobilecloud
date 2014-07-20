package com.mobilecloud.echo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Riccardo Sirigu
 */
public class EchoServiceTest {
    
    private static final String targetUrl = "http://localhost:8080/1-echoservice/echo";
    private Client client;
    private WebTarget target;

    @Before
    public void setUp() {
        this.client = ClientBuilder.newClient();
        target = this.client.target(targetUrl);        
    }

     @Test
     public void isEchoed() {
         String responseBody = target.queryParam("msg", "Hello Coursera!")
                 .request()
                 .get(String.class);
         
         assertEquals(responseBody, "Hello Coursera!");
     }
}
