package org.nv1;


import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/api/todolist")
@ApplicationScoped
public class TodolistResource {

    private final Template test;

    @Inject
    TodolistRepository todolistRepository;

    public TodolistResource(Template test) {
        this.test = requireNonNull(test, "test page is required");
    }

    @GET
    @Path("/healthTest")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthTest() {
        return "Health Test";
    }

    @GET
    @Path("/htmxTest")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance htmxTest() {
        return test.data("test");
    }

}
