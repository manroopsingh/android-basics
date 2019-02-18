package com.example.questions.sort_worker_salaries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    //global variable to save all the salaries
    static HashMap<String, List<String>> salariesMap;

//    getter for all worker salaries
    private static HashMap<String, List<String>> getSalariesMap(){return salariesMap;}

//    recursive function to calculate the salaries
    private static int getSalary(List<String> worker){

        String workerType = worker.get(1);

        switch (workerType) {
            case "FTE":
                return Integer.parseInt(worker.get(3));
            case "Contractor":
                return Integer.parseInt(worker.get(3)) * Integer.parseInt(worker.get(4)) * 52;
            case "Manager":
                String[] directs = worker.get(3).split(",");
                return getSalary(getSalariesMap().get(directs[0])) + getSalary(getSalariesMap().get(directs[1]));
            default:
                return -1;
        }
    }

    private static List<Integer> getSortedSalary(List<List<String>> workers){
        salariesMap = new HashMap<>();
        List<Integer> salaries = new ArrayList<>();

//        loop through all the workers to save the salaries
        for (List<String> worker : workers) {
            getSalariesMap().put(worker.get(0), worker);
        }
//         add the salaries to the list
        for (List<String> worker : workers) {
            salaries.add(getSalary(worker));
        }

//        sort all the salaries
        Collections.sort(salaries);
        return salaries;

    }

    public static void main(String[] args) {

//        sample workers
        List<List<String>> workers = new ArrayList<>();
        workers.add(Arrays.asList("1", "FTE", "George", "75000", "X"));
        workers.add(Arrays.asList("2", "FTE", "George", "50000", "X"));
        workers.add(Arrays.asList("3", "Manager", "George", "2,4"));
        workers.add(Arrays.asList("4", "Manager", "George", "1,5"));
        workers.add(Arrays.asList("5", "FTE", "George", "100000", "X"));
        workers.add(Arrays.asList("6", "Contractor", "George", "100", "20"));

        for (Integer sortedListOfSalary : getSortedSalary(workers)) {
            System.out.println(sortedListOfSalary);
        }

    }
}