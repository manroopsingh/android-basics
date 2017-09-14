package com.example.user.android_listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by singh on 9/11/17.
 */

public class VHCustomListAdapter extends ArrayAdapter<Person> {


    public VHCustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> personList) {
        super(context, resource, personList);

    }

    //create an inner class to use the view holder pattern
    public class ViewHolder {
        private TextView tvPersonName;
        private TextView tvPersonAge;
        private TextView tvPersonGender;
        private TextView tvPersonHeight;

    }


    @Override
    public int getItemViewType(int position) {

        Person person = getItem(position);
        int age = person.getAge();

        if (age > 40)
            return 1;
        else
            return 2;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        //get the type of the view
        int type = getItemViewType(position);

        //inflate the view
        if (view == null) {
            switch (type) {

                case 1:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item1, null);
                    break;
                case 2:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item2, null);
                    break;
            }

        }


        ViewHolder holder = new ViewHolder();
        //bind all the views from the custom view
        holder.tvPersonName = view.findViewById(R.id.tvName);
        holder.tvPersonAge = view.findViewById(R.id.tvAge);
        holder.tvPersonGender = view.findViewById(R.id.tvGender);
        holder.tvPersonHeight = view.findViewById(R.id.tvHeight);

        //bind the views with the data
        Person person = getItem(position);
        if (person != null) {

            holder.tvPersonName.setText(person.getName());
            holder.tvPersonAge.setText(String.valueOf(person.getAge()));
            holder.tvPersonHeight.setText(String.valueOf(person.getHeight()));
            holder.tvPersonGender.setText(person.getGender());
            view.setTag(holder);
            //Log.d("VICustomTag", "getView: " + new Random().nextInt(100) + " " + person.getName());

        }


        return view;
    }
}
