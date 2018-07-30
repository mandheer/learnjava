package com.learning.problems.jukebox.model;

public abstract class User {
    private String name;
    private long id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getId() { return id; }
    public void setId(long id) { id = id; }

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public User getUser() {
        return this;
    }

    public abstract User addUser(String name, long id);
}
