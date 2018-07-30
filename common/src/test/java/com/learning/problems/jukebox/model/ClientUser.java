package com.learning.problems.jukebox.model;

public class ClientUser extends User{

    public ClientUser(String name, long id){
        super(name, id);
    }
    @Override
    public User addUser(String name, long id) {
        return new ClientUser(name, id);
    }
}
