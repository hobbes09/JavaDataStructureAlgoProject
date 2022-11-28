package com.app.design.splitwise.models;

import java.util.ArrayList;

public class Group {
    ArrayList<User> users;

    public Group() {
        this.users = new ArrayList<>();
    }

    public Group(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        if (!checkUserAlreadyInGroup(user)){
            this.users.add(user);
        }
    }

    private boolean checkUserAlreadyInGroup(User user) {
        return false;
    }
}
