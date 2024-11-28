package org.nv1;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/todolist")
@ApplicationScoped
public class TodolistResource {

    @GET
    @Path("/healthTest")
    public String healthTest() {
        return "Health Test";
    }


}
