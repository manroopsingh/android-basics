package com.example.user.android_firebase;

/**
 * Created by singh on 7/20/17.
 */

public class Movie {

    String title;
    String producer;
    String rating;
    String director;
    String writer;

    public Movie(String title, String producer, String rating, String director, String writer) {
        this.title = title;
        this.producer = producer;
        this.rating = rating;
        this.director = director;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
