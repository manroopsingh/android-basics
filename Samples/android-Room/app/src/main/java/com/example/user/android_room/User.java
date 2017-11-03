package com.example.user.android_room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by singh on 9/29/17.
 */

@Entity
public class User {


    @PrimaryKey
    int uid;

    @ColumnInfo(name = "first_name")
    String firstName;

    @ColumnInfo(name = "last_name")
    String lastName;

    public User(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

