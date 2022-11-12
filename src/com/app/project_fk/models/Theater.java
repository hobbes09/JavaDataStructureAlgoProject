package com.app.project_fk.models;

import java.util.List;

public class Theater {

    String name;
    List<Screen> screenList;

    public Theater(String name, List<Screen> screenList) {
        this.name = name;
        this.screenList = screenList;
    }
}
