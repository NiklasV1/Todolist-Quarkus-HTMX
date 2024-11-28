package org.nv1;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 2000)
    private String text;

    private boolean completed;

    public Todo() {
    }

    public Todo(String text) {
        this.text = text;
        this.completed = false;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
