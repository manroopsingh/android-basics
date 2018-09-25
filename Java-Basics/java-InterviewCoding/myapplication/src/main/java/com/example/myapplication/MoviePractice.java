package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoviePractice {

    public static void main(String[] args) {


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("someting"));
        movies.add(new Movie("dometing"));
        movies.add(new Movie("fometing"));
        movies.add(new Movie("ghometing"));

        Collections.sort(movies);

        for (Movie movie : movies) {
            System.out.println(movie.toString());

        }



    }
}
