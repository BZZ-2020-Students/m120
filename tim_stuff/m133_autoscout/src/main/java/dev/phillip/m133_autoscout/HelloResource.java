package dev.phillip.m133_autoscout;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("application/json")
    @Path("/1")
    public String hello() {
        return "{\"message\": \"Hello, World!\"}";
    }

    @GET
    @Produces("text/plain")
    @Path("/2")
    public String helloIdiot() {
        return "Hello, Idiot!";
    }
}