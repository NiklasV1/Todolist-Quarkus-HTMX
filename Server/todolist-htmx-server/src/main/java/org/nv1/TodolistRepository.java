package org.nv1;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

public class TodolistRepository implements PanacheRepositoryBase<Todo, UUID> {

}
