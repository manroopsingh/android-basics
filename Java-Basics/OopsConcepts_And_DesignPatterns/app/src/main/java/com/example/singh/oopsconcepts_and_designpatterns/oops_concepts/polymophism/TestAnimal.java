package com.example.singh.oopsconcepts_and_designpatterns.oops_concepts.polymophism;

/**
 * Created by singh on 10-Oct-17.
 */

public class TestAnimal {

    public static void main(String[] args) {

//        this is subtyping is type of polymorphism when the references can
//        be intialized with Tiger object
        Tiger tiger = new Tiger();
        Animal animal = tiger;;
        Carnivorous carnivorous = tiger;
//        both animal and carnivorous are references to the same tiger object


//        Static polymorphism is method overloading
        tiger.run(3);
        tiger.run(3, 30);
//        calling the same method name with different argument list
        
//        Dynamic polymorphism is method overriding
        animal.sleep();
//        The JVM use Virtual method invocation to call the sleep method
//        in the tiger class, which is a subclass of the animal class.
//        The Compiler will let the sleep method call on the animal instance
//        since it is declared in the animal class. But the JVM will can the
//        sleep method in the tiger instance, since that is how it was instantiated.

    }
}
