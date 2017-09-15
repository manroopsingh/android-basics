package com.example.singh.android_recyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.onItemClicked {


    //create required instance
    private RecyclerView rvSomeList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;

    private List<DummyData> dummyDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSomeList = findViewById(R.id.rvSomeList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();

        //intialize dummy data list
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        for (int i = 0; i < 10; i++) {
            dummyDataList.add(new DummyData(String.valueOf(i), bitmap));
        }

        //initiate objects required for recycler view
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dummyDataList);
        rvSomeList.setAdapter(adapter);
        rvSomeList.setLayoutManager(layoutManager);
        rvSomeList.setItemAnimator(itemAnimator);

        ItemTouchHelper.Callback callback = new CustomItemTouchHelper(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rvSomeList);


    }

    @Override
    public void sendDataToActivity(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

    }
}
