package com.learning.problems.jukebox.model;

public class Publisher extends User{

    public Publisher(String name,long id){
        super(name, id);
    }
    @Override
    public User addUser(String name, long id) {
        return new Publisher(name, id);
    }
}
