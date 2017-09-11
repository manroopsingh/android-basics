package com.example.user.android_designpatterns.designpatterns;

/**
 * Created by singh on 9/1/17.
 */

//A singleton class is a class that can have only one instance of the class
public class Singleton {

    //create an instance of the class
    private static Singleton instance = null;

    private Singleton(){
        //defeats the instantiation of the class
    }

    //create a public method to get the instance of the class
    public static Singleton getInstance(){

        //this will make sure to return the same instance of the object
        if(instance== null){
            instance = new Singleton();
        }

        return instance;
    }

}
