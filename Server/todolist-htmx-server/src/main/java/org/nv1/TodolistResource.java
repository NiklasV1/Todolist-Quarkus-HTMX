package org.nv1;


import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Path("/api/todolist")
@ApplicationScoped
public class TodolistResource {

    private final Template test;
    private final Template todoList;

    private Filter filter = Filter.ALL;

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

    @POST
    @Path("deleteTodo/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance deleteTodo(UUID id) {
        System.out.println(id);
        // TODO sanitize input

        todolistRepository.deleteTodo(id);
        return getAllTodos();
    }

}
