package com.example.singh.android_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 13-Sep-17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    //create the list of data to populate the recyclerView
    List<DummyData> dummyDataList = new ArrayList<>();

    //constructor to initialize the data
    public RecyclerViewAdapter(List<DummyData> dummyDataList) {
        this.dummyDataList = dummyDataList;
    }

    //create an inner viewholder class to hold all the views for the item
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        //bind the view in the constructor
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivSomeImage);
            textView = itemView.findViewById(R.id.tvSomeText);

        }
    }

    //this method is used to define different views to inflate for view holder
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);

    }

    //this method is used to inflate the view and initialize the view holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item_type1, parent, false);
        return new ViewHolder(view);
    }

    //this method is called to bind each viewHolder instance with the data
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DummyData dummyData = dummyDataList.get(position);
        holder.imageView.setBackground(dummyData.getSomeImage());
        holder.textView.setText(dummyData.getSomeText());


    }

    //this method returns the total number of items in the list
    @Override
    public int getItemCount() {
        return 0;
    }
}
