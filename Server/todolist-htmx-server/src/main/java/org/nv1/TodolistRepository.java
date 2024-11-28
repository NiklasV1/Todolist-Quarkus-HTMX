package org.nv1;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class TodolistRepository implements PanacheRepositoryBase<Todo, UUID> {

    public UUID addTodo(String text) {
        Todo todo = new Todo(text);
        this.persist(todo);
        return todo.getId();
    }

    public List<Todo> getAllTodos() {
        return this.listAll();
    }

    public boolean deleteTodo(UUID id) {
        return this.deleteById(id);
    }
}
