package com.example.quizletproject;

import java.util.List;

public class Folder {
    private String name;
    private List<Module> modules;

    public Folder(String name, List<Module> modules) {
        this.name = name;
        this.modules = modules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
