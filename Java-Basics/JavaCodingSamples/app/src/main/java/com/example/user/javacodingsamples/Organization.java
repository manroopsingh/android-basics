package com.example.user.javacodingsamples;

import java.util.Scanner;

/**
 * Created by singh on 12/7/17.
 */

public class Organization {


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


    public static void main(String[] args) {


        String[] teams = new String[]{"B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"};


        Organizer organizer = new Organizer();
        organizer.printOrganization(teams);

        //organizer.printOrganization(teams);

    }

}
