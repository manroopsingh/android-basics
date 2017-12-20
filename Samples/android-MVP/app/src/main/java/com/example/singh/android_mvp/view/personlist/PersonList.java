package com.example.singh.android_mvp.view.personlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.singh.android_mvp.R;
import com.example.singh.android_mvp.model.Person;

import java.util.List;

public class PersonList extends AppCompatActivity implements PersonListContract.View {

    private RecyclerView rvPersonList;
    List<Person> personList;
    private PersonListAdapter adapter;
    private PersonListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        presenter = new PersonListPresenter();
        presenter.attachView(this);
        presenter.getPersonList();
        presenter.setupRecyclerView();


    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendPersonList(List<Person> personList) {

        this.personList = personList;

    }

    @Override
    public void setupRecyclerView() {

        rvPersonList = findViewById(R.id.rvPersonList);
        adapter = new PersonListAdapter(personList);
        rvPersonList.setLayoutManager(new LinearLayoutManager(this));
        rvPersonList.setAdapter(adapter);
    }
}
