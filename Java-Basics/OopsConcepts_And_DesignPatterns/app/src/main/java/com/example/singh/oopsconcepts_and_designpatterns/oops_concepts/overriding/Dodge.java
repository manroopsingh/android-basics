package com.example.singh.oopsconcepts_and_designpatterns.oops_concepts.overriding;

/**
 * Created by singh on 09-Oct-17.
 */

public class Dodge extends Vehicle{

    public void accelerate(){
        System.out.println("This dodge is moving fast");
    }

    public void brake(){
        super.brake();
        System.out.println("This Dodge is stopping right now");
    }

    public void do360(){
        System.out.println("Dodge is on a spin");
    }
}
