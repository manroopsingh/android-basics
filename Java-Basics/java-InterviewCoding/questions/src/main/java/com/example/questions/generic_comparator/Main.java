package com.example.questions.generic_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Movie> movies = getUnsortedMovies();


        System.out.println("---Printing unsorted movies---");
        printMovies(movies);
        System.out.println("---Sorting movies---");
        Collections.sort(movies, new GenericComparator<Movie>());
        System.out.println("---Printing sorted movies---");
        printMovies(movies);

    }

    private static void printMovies(List<Movie> unsortedMovies) {
        for (Movie unsortedMovie : unsortedMovies) {
            System.out.println(unsortedMovie.toString());
        }
    }


    public static List<Movie> getUnsortedMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Titanic"));
        movies.add(new Movie("Rocky"));
        movies.add(new Movie("Avengers"));
        movies.add(new Movie("Shooter"));
        movies.add(new Movie("Lion King"));
        return movies;
    }


}
