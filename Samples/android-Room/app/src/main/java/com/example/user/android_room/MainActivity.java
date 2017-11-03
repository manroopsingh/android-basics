package com.example.user.android_room;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);


        appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "user_database").build();

    }

    public void saveUserObject(View view) {

        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        final User user = new User(new Random().nextInt(100), firstName, lastName);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MainActivityTag", "run: save object");
                appDatabase.userDao().insertUsers(user);
            }
        }).start();


    }


    public void getUserObjects(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MainActivityTag", "run: get object");

                List<User> userList  = appDatabase.userDao().getAllUsers();
                for(User user: userList){
                    Log.d("MainActivityTag"
                            , "getUserObjects: " + user.getFirstName());
                }
            }
        }).start();


    }
}
