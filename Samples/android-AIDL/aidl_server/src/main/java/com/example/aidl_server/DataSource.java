package com.example.aidl_server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 20-Aug-17.
 */

public class DataSource {


    private static DataSource instance = null;


    public DataSource() {
    }


    public static DataSource getInstance(){

        if (instance==null){
            instance = new DataSource();
        }
        return instance;

    }

    List<Person> personList = new ArrayList<>();

    public void initPersonList(){
        personList.clear();
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));

    }

    public List<Person> getPersonList() {
        return personList;
    }


    public void addPerson(Person person){
        personList.add(new Person("John" + getRandom(), getRandom(), "male", new Date()));
    }


    private String getRandom() {
        Random random = new Random();
        return String.valueOf(random.nextInt(100));
    }

}
