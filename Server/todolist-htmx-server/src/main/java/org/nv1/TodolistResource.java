package org.nv1;


import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/api/todolist")
@ApplicationScoped
public class TodolistResource {

    private final Template test;
    private final Template todoList;

    @Inject
    TodolistRepository todolistRepository;

    public TodolistResource(Template test, Template todoList) {
        this.test = requireNonNull(test, "test page is required");
        this.todoList = requireNonNull(todoList, "test page is required");
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

    @GET
    @Path("/getAllTodos")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getAllTodos() {
        return todoList.data("todos", todolistRepository.getAllTodos());
    }

    @POST
    @Path("/addTodo")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance addTodo(@FormParam("text") String text) {
        System.out.println(text);
        // TODO sanitize input
        todolistRepository.addTodo(text);
        return getAllTodos();
    }

}
