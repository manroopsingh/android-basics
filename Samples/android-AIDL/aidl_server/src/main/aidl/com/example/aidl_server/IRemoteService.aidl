// IRemoteService.aidl
package com.example.aidl_server;

// Declare any non-default types here with import statements
import com.example.aidl_server.Person;

interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */


    void savePerson(in Person person);
    Person getPerson(int position);
    List<Person> getPersonList();


}
