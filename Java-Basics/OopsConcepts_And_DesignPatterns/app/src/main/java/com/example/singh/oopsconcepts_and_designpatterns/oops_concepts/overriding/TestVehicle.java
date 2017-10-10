package com.example.singh.oopsconcepts_and_designpatterns.oops_concepts.overriding;

/**
 * Created by singh on 09-Oct-17.
 */

public class TestVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(); //Vehicle reference and object
        Vehicle dodge = new Dodge(); //Vehicle reference and Dodge object

//        you can initialize the vehicle class with dodge class since
//        Dodge class is extending the Vehicle class
        Vehicle vehicleDodge = new Dodge();

//        this will call the method in the Vehicle class
        vehicle.accelerate();
//        this will call the method in the Dodge class, since the JVM will
//        run the specific method in the object at runtime
        dodge.accelerate();

//        this method is calling the brake method in Dodge class which is calling
//        the brake  method in the Vehicle class by using keyword super
        vehicleDodge.brake();

//        do360() method is in the Dodge class, so you wont be able to access
//        this method from this instance as this instance is
//        vehicleDodge.do360();

//        to access the do360() method in the Dodge class make an
//        reference of the Dodge class
        Dodge thisDodge = new Dodge();
        thisDodge.do360();


    }
}
