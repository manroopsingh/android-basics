package com.example.singh.android_mvp.view.persondetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.singh.android_mvp.R;
import com.example.singh.android_mvp.model.Person;
import com.example.singh.android_mvp.utils.Constants;

public class PersonDetail extends AppCompatActivity implements PersonDetailContract.View{


    private TextView tvPersonFirstName;
    private TextView tvPersonLastName;
    private TextView tvPersonAge;
    private TextView tvPersonGender;
    private PersonDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        bindViews();
        presenter = new PersonDetailPresenter();
        presenter.attachView(this);
        presenter.getPerson();

    }

    private void bindViews() {
        tvPersonFirstName = findViewById(R.id.tvPersonFirstName);
        tvPersonLastName = findViewById(R.id.tvPersonLastName);
        tvPersonAge = findViewById(R.id.tvPersonAge);
        tvPersonGender = findViewById(R.id.tvPersonGender);
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void onPersonReceived() {

        Person person = getIntent().getParcelableExtra(Constants.Extras.PERSON);
        Log.d("PersonDetail", "onPersonReceived: " + person.toString());
        tvPersonFirstName.setText(person.getFirstName());
        tvPersonLastName.setText(person.getLastName());
        tvPersonAge.setText(""+person.getAge());
        tvPersonGender.setText(person.getGender());


    }
}
