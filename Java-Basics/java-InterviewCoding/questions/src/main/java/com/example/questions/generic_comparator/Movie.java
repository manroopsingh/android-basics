package com.example.questions.generic_comparator;

public class Movie implements Comparable<Movie> {

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
    public int compareTo(Movie movie) {
        return 0;
    }
}
