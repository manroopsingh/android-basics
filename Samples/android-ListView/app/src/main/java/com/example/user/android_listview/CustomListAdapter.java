package com.example.user.android_listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by singh on 9/11/17.
 */

public class CustomListAdapter extends ArrayAdapter<Person> {


    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> personList) {
        super(context, resource, personList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        //inflate the view
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item1, null);
        }


        //bind all the views from the custom view
        TextView tvPersonName = view.findViewById(R.id.tvName);
        TextView tvPersonAge = view.findViewById(R.id.tvAge);
        TextView tvPersonGender = view.findViewById(R.id.tvGender);
        TextView tvPersonHeight = view.findViewById(R.id.tvHeight);

        //bind the views with the data
        Person person = getItem(position);
        if (person != null) {
            tvPersonName.setText(person.getName());
            tvPersonAge.setText(String.valueOf(person.getAge()));
            tvPersonHeight.setText(String.valueOf(person.getHeight()));
            tvPersonGender.setText(person.getGender());
        }

        Log.d("CustomTag", "getView: " + new Random().nextInt(100) + " " + person.getName());

        return view;

    }
}
