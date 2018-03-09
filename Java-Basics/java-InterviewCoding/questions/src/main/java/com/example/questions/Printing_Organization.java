package com.example.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: singh on: 01-Feb-18.
 */

public class Printing_Organization {

    /**
     * We have an organization and need to print an org chart in the terminal.
     * The input is a list of strings.
     * Each string is a management / direct report relationship Example: "A1,B2,C3,D4"
     * Explanation: A1 is the manager of B2, C3, D4, where A1, B2, C3, D4 are unique employee IDs separated by comma.
     *
     * An org chart is a list of strings like above. Example of an org chart "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"
     *
     * The output is a terminal representation of the org chart, such as
     *
     * A1
     *      B2
     *            E5
     *            F6
     *      C3
     *      D4
     *            G7
     *                   H8
     *            I9
     *
     * INPUT: an array of strings "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"
     *
     * OUTPUT: (see above)
     */
    private static Set<String> managers;

    public static void main(String[] args) {
        String[] input = {"B2,E5,F6","A1,B2,C3,D4","D4,G7,I9","G7,H8"};
        printOrganization(input);
    }

    private static void printOrganization(String[] input) {
        //Leaders will contain set of all possible managers
        managers = new HashSet<>();
        //Process the string input
        Map<String, List<String>> relations = processInput(input);
        //This means every potential CEO of the company is under someone else
        //This is the result of a circular organization chart!
        if(managers.size()==0) {
            System.out.println("Invalid organization structure - circular organization chart. Cannot print out.");
            return;
        }
        String[] Leaders = managers.toArray(new String[managers.size()]);
        printResult(Leaders[0],relations,1);
    }

    //Process the string inputs // Store as (manager, employee) key value pair
    private static Map<String, List<String>> processInput(String[] input) {
        Map<String, List<String>> relations = new HashMap<>();
        Set<String> allUnderlings = new HashSet<>();
        for(String relation:input) {
            String[] underlings = relation.split(",");
            String manager = underlings[0];
            managers.add(manager);

            //Add all to relation map
            for(int i=1;i<underlings.length;i++) {
                addRelation(manager,underlings[i],relations);
                allUnderlings.add(underlings[i]);
            }
        }

        managers.removeAll(allUnderlings);
        return relations;
    }

    private static void addRelation(String manager, String underling, Map<String, List<String>> managers) {
        List<String> employees = managers.get(manager);

        if(employees==null) {
            employees = new ArrayList<>();
        }
        employees.add(underling);
        managers.put(manager,employees);
    }

    private static void printResult(String leader, Map<String, List<String>> organization, int steps) {
        //Print out leader
        if(steps==1)
            System.out.println(leader);
        List<String> underlings = organization.get(leader);
        for(String underling:underlings) {
            for(int i=1;i<=steps;i++)
                System.out.print("\t");
            System.out.println(underling);
            //If underling has people under them, print those as well
            if(organization.get(underling)!=null) {
                printResult(underling, organization,steps+1);
            }
        }
    }
}