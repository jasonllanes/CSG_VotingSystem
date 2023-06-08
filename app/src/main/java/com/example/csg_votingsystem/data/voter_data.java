package com.example.csg_votingsystem.data;

public class voter_data {



    public String name;
    public String president;
    public String vice;

    public voter_data(){}


    public voter_data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
