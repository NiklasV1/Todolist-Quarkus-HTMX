package org.nv1;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/todolist")
@ApplicationScoped
public class TodolistResource {

    @Inject
    TodolistRepository todolistRepository;

    @GET
    @Path("/healthTest")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthTest() {
        return "Health Test";
    }

}
