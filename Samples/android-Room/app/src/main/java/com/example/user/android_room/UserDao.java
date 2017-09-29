package com.example.user.android_room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by singh on 9/29/17.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();


    @Query("SELECT * FROM user where uid IN (:userId)")
    List<User> getUsersById(int[] userIds);

    @Query(("SELECT * FROM user where" +
            "first_name LIKE :first AND" +
            "last_name LIKE :last LIMIT 1"))
    User getUserByName(String first, String last);

    @Insert
    void insertUsers(User... users);

    @Delete
    void deleteUser(User user);


}
