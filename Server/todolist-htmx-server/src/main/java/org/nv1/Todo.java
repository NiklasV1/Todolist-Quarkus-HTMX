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
}
