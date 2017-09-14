package com.example.user.android_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSimpleListItem;
    ListView lvCustomItem;
    ListView lvViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSimpleListItem = (ListView) findViewById(R.id.lvSimpleListItem);
        lvCustomItem = (ListView) findViewById(R.id.lvCustomItem);
        lvViewHolder = (ListView) findViewById(R.id.lvViewHolder);


        //initialize data for lvSimpleListItem
        String[] simpleListData = new String[]{"First item", "Second item","Third item"};

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,simpleListData);
        lvSimpleListItem.setAdapter(stringArrayAdapter);

        //initialize data for lvCustomItem
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John Doe",23,"Male",144));
        personList.add(new Person("Monica geller",45,"Female",156));
        personList.add(new Person("Clay brendon",34,"Male",177));


        //initialize and set adapter for lvCustomItem
        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.custom_list_item1, personList);
        lvCustomItem.setAdapter(customListAdapter);

        //initialize and set adatper for lvViewHolder
        VHCustomListAdapter VHCustomListAdapter = new VHCustomListAdapter(this, R.layout.custom_list_item1, personList);
        lvViewHolder.setAdapter(VHCustomListAdapter);




    }

}
