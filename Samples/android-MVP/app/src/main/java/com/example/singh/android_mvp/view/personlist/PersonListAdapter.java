package com.example.singh.android_mvp.view.personlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singh.android_mvp.R;
import com.example.singh.android_mvp.model.Person;

import java.util.List;

/**
 * Author: singh on: 19-Dec-17.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {

    List<Person> personList;
    onPersonListInteraction personListInteraction;


    public PersonListAdapter(Context context,List<Person> personList) {
        this.personListInteraction = (onPersonListInteraction) context;
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Person person = personList.get(position);

        holder.tvPersonFirstName.setText(person.getFirstName());
        holder.tvPersonLastName.setText(person.getLastName());
        holder.tvPersonAge.setText("" +person.getAge());
        holder.tvPersonGender.setText(person.getGender());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvPersonFirstName,
                tvPersonLastName,
                tvPersonGender,
                tvPersonAge;

        ViewHolder(View itemView) {
            super(itemView);
            tvPersonFirstName = itemView.findViewById(R.id.tvPersonFirstName);
            tvPersonLastName = itemView.findViewById(R.id.tvPersonLastName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonGender= itemView.findViewById(R.id.tvPersonGender);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            personListInteraction.onPersonClicked(personList.get(getAdapterPosition()));
        }
    }

    interface onPersonListInteraction{

        void onPersonClicked(Person person);
    }
}
