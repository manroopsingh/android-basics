package com.example.singh.oopsconcepts_and_designpatterns.java_problems.custom_parser;

/**
 * Created by singh on 10-Oct-17.
 */

public class Country {

    String name;
    String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
