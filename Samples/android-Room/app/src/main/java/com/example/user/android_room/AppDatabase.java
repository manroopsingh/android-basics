package com.example.user.android_room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by singh on 11/1/17.
 */


@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract UserDao userDao();

}
