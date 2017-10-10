package com.example.singh.oopsconcepts_and_designpatterns.oops_concepts.polymophism;

/**
 * Created by singh on 10-Oct-17.
 */

public class Tiger extends Animal implements Carnivorous {

    public void sleep() {
        System.out.println("This tiger is sleeping");
    }


    public void run(int distance) {
        System.out.println("This tiger just ran " + distance + "miles");

    }

    public void run(int distance, int speed) {
        System.out.println("This tiger just ran "
                + distance + "miles at "
                + speed + "mph");
    }

    @Override
    public void eat() {
        System.out.println("This tiger is eating some deer now");
    }
}
