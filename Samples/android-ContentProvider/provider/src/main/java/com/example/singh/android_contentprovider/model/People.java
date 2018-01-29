package com.example.singh.android_contentprovider.model;

/**
 * Author: singh on: 28-Jan-18.
 */

public class People {


    int id;
    String name;
    String gender;
    String age;

    public People(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public People(int id, String name, String gender, String age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
