package com.example.user.javacodingsamples.printing_organization_problem;

import java.util.List;

/**
 * Created by singh on 12/7/17.
 */

public class Team {

    String manager;
    List<String> employeeList;

    public Team(String manager, List<String> employeeList) {
        this.manager = manager;
        this.employeeList = employeeList;
    }


    @Override
    public String toString() {
        return "Team{" +
                "manager='" + manager + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<String> employeeList) {
        this.employeeList = employeeList;
    }
}
