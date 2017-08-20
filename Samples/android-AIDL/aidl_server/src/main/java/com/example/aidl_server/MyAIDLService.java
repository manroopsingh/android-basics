package com.example.aidl_server;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MyAIDLService extends Service {


    List<Person> personList = new ArrayList<>();
    DataSource dataSource;

    public MyAIDLService() {
        dataSource = DataSource.getInstance();
        dataSource.initPersonList();
        personList.addAll(dataSource.getPersonList());

    }

    @Override
    public IBinder onBind(Intent intent) {

        return binder;

    }

    private final IRemoteService.Stub binder = new IRemoteService.Stub() {


        @Override
        public void savePerson(Person person) throws RemoteException {


            SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref", MODE_PRIVATE);
            String storedPersons = sharedPreferences.getString("person", "");

            Log.d(TAG, "savePerson: ");
            boolean isSaved = false;
            if (person != null) {

                dataSource.addPerson(person);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("person", storedPersons + "\n" + person.toString());
                isSaved = editor.commit();
            }

            Log.d(TAG, "savePerson: isSaved" + isSaved);

        }

        @Override
        public Person getPerson(int position) throws RemoteException {

            int personListSize = dataSource.getPersonList().size();
            personList.clear();
            personList.addAll(dataSource.getPersonList());
            if (position > 0 && position < personListSize) {
                return personList.get(position);
            } else {
                return personList.get(0);
            }

        }

        @Override
        public List<Person> getPersonList() throws RemoteException {

            return dataSource.getPersonList();

        }

    };


}
