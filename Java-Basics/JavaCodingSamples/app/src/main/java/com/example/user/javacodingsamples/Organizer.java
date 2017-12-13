package com.example.user.javacodingsamples;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 12/7/17.
 */

public class Organizer {

    public Team parse(String rawString){

        String[] members = rawString.split(",");
        int teamSize = members.length;

        String manager = members[0];
        List<String> employees = new ArrayList<>();

        for (int i = 1; i < teamSize; i++) {
            employees.add(members[i]);
        }

        Team team = new Team(manager, employees);
        return team;

    }

    public void printOrganization(String[] rawTeamString){

        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < rawTeamString.length; i++) {
            Team team = parse(rawTeamString[i]);
            teams.add(team);
        }

        System.out.println(teams.toString());



    }

    //public void mapper()


}
