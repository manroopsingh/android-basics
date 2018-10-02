package com.example.myapplication;

import android.support.annotation.NonNull;

import java.util.Comparator;

public class Movie implements Comparable<Movie>, Comparator<Movie> {


    String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull Movie o) {
        return name.compareTo(o.name);
    }

    @Override
    public int compare(Movie o1, Movie o2) {
        return 0;
    }
}
