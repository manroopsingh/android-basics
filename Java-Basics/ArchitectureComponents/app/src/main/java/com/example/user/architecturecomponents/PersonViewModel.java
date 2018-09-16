package com.example.user.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.text.Html;

import com.example.user.architecturecomponents.model.Person;
import com.example.user.architecturecomponents.model.PersonDataSource;
import com.example.user.architecturecomponents.model.PersonDatabase;

public class PersonViewModel extends AndroidViewModel{

    MutableLiveData<Person> personMutableLiveData;
    PersonDataSource personDataSource;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        this.personDataSource = new PersonDataSource(
                application.getApplicationContext(),
                this);

    }
    public LiveData getPerson() {

        if (personMutableLiveData == null) {
            personMutableLiveData = new MutableLiveData<>();
            loadPerson();
        }
        return personMutableLiveData;

    }

    private void loadPerson() {

        personMutableLiveData.setValue(PersonDataSource.getPerson());


    }


    public void insertPerson(Person person) {

        personDataSource.insert(person);

    }

    public void updateViewModel(Person person) {

        personMutableLiveData.setValue(person);
    }






}
