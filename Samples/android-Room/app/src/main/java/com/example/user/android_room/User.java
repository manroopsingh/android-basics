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




}
