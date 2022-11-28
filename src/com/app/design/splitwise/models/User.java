package com.app.design.splitwise.models;

public class User {
    String name;
    String email;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return this.name+"-"+this.email;
    }
}
