package com.example.aidl_server;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvOriginalData;
    TextView tvAddedData;
    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = DataSource.getInstance();

        tvAddedData = (TextView) findViewById(R.id.tvAddedData);
        tvOriginalData = (TextView) findViewById(R.id.tvOriginalData);

        dataSource.initPersonList();
        tvOriginalData.setText(dataSource.getPersonList().toString());

    }


    public void updateAddedData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref",MODE_PRIVATE);
        String addedData = sharedPreferences.getString("person","");
        tvAddedData.setText(addedData);

    }
}
