package com.learning.problems.jukebox.model;

public class Artist extends User{

    private String role; //singer,music,violin,drummist,

    public Artist(String name, long id, String role){
        super(name, id); this.role = role;
    }

    public User addUser(String name, long id, String role) {
        return new Artist(name, id, role);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public User addUser(String name, long id) {
        return new Artist(name, id, "singer");
    }
}
