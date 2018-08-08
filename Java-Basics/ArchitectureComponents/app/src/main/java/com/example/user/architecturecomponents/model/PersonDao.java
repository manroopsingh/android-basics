package com.example.user.architecturecomponents.model;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM Person where name = :name")
    Single<Person> getPerson(String name);

    @Query("SELECT * FROM Person")
    Flowable<List<Person>> getAllPerson();

    @Insert
    void updatePerson(Person person);

}
