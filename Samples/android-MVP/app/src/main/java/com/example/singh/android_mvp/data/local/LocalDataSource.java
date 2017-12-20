package com.example.singh.android_mvp.data.local;

import com.example.singh.android_mvp.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: singh on: 19-Dec-17.
 */
/*
This class can have the SQLite implementation of a local data source. As per now
we can use this as a hard coded data values
*/
// TODO: 19-Dec-17 Implement SQL database
public class LocalDataSource {

    public static List<Person> createPersonList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jennifer", "Anniston", 50, "Female"));
        personList.add(new Person("John", "Abraham", 45, "Male"));
        personList.add(new Person("Salman", "Khan", 52, "Male"));
        personList.add(new Person("Julia", "Roberts", 46, "Male"));
        personList.add(new Person("Tom", "Cruise", 53, "Male"));
        personList.add(new Person("Will", "Smith", 54, "Male"));
        personList.add(new Person("Clint", "Eastwood", 65, "Male"));

        return personList;
    }
}
