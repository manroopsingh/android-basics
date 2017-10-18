package com.example.singh.oopsconcepts_and_designpatterns.java_problems.handling_elevator_request;

import java.util.Arrays;

/**
 * Created by singh on 10/17/17.
 */


// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

//Hello!!
// Elevator on floor X
// Elevator will go up or down
// Input: Currently floor, List of floors to visit
// Output: What floors the elevator visits

// Input: at floor 5, input {1, ,6 ,3, 2, 5, 7, 8}, elevator direction: going up
// Output: 5, 6, 7, 8, 3, 2, 1

enum Direction {
    UP,
    DOWN
}

public class RequestHandler {

    public static void main(String[] args) {
        int[] requests = new int[]{1, 5, 3, 7, 8};

        int[] output = new int[requests.length];

        elevatorStops(4, requests, Direction.DOWN);


        System.out.println(Arrays.toString(output));
    }

    //output: 5,7,8,3,1
    public static int[] elevatorStops(int currentFloor, int[] request, Direction dirc) {

        int[] visitedFloors = new int[request.length];
        int[] sortedRequest = request;

        Arrays.sort(sortedRequest);

        int visitingCounter = 0;

        switch (dirc) {

            case UP:

                //iterate through the floors as per the current value of the floor
                for (int i = 0; i < sortedRequest.length; i++) {
                    if (sortedRequest[i] >= currentFloor) {
                        visitedFloors[visitingCounter] = sortedRequest[i];
                        visitingCounter++;
                    }
                }

                for (int j = sortedRequest.length - 1; j >= 0; j--) {
                    if (sortedRequest[j] < currentFloor) {
                        visitedFloors[visitingCounter] = sortedRequest[j];
                        visitingCounter++;
                    }

                }
                //prints out the floors visited which going up the floor as per the input floor
                System.out.println("Floors:" + Arrays.toString(visitedFloors));


                break;

            case DOWN:

                // input //1,3,5,7,8

                //iterate through the floors as per the current value of the floor
                for (int i = sortedRequest.length - 1; i >= 0; i--) {
                    if (sortedRequest[i] <= currentFloor) {
                        visitedFloors[visitingCounter] = sortedRequest[i];
                        visitingCounter++;
                    }
                }

                for (int j = 0; j < sortedRequest.length; j++) {
                    if (sortedRequest[j] > currentFloor) {
                        visitedFloors[visitingCounter] = sortedRequest[j];
                        visitingCounter++;
                    }

                }
                System.out.println("Floors:" + Arrays.toString(visitedFloors));

                break;
        }

        return visitedFloors;

    }


}


