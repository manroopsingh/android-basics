package com.example.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter_list_alphbetically_from_last_letter_and_age {

    /**
     * | Name    | Age |
     * |---------|-----|
     * | Al      | 68  |
     * | Chris   | 22  |
     * | Jessica | 41  |
     * | Jeff    | 28  |
     * | Jenn    | 19  |
     * | Jim     | 22  |
     *
     * Implement code that prints out the names
     * (sorted by the last letter of their name)
     * of people age 25 or older.
     *
     * Expected output:
     * Jessica
     * Jeff
     * Al
     */

    public static void main(String[] args) {

        printList(filterList(generatePeople()));
    }

    private static List<Person> generatePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Al", 68));
        people.add(new Person("Chris", 22));
        people.add(new Person("Jessica", 41));
        people.add(new Person("Jeff", 28));
        people.add(new Person("Jenn", 19));
        people.add(new Person("Jim", 22));
        return people;
    }

    private static List<Person> filterList(List<Person> people){

        //filter list as per age
        List<Person> filteredList = people.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() > 25;
            }
        }).collect(Collectors.<Person>toList());

        //sort the list
        Collections.sort(filteredList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                String p1Name = p1.getName();
                String p2Name = p2.getName();

                String p1Last = p1Name.substring(p1Name.length() - 1);
                String p2Last = p2Name.substring(p2Name.length() - 1);

                return String.valueOf(p1Last).compareTo(p2Last);
            }
        });
        return filteredList;
    }

    private static void printList(List<Person> people){
        for (Person person : people) {
            System.out.println(person.getName());

        }
    }


    public static class Person{

        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }
    }




}
