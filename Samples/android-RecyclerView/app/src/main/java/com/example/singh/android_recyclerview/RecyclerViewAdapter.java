package com.example.singh.android_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by singh on 13-Sep-17.
 */

public class RecyclerViewAdapter
        extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
        implements
        CustomItemTouchHelperAdapter
        , View.OnClickListener {

    //create an instance of the listener
    private onItemClicked listener;

    //create the list of data to populate the recyclerView
    List<DummyData> dummyDataList = new ArrayList<>();

    //constructor to initialize the data
    public RecyclerViewAdapter(Context context, List<DummyData> dummyDataList) {
        this.dummyDataList = dummyDataList;
        listener = (onItemClicked) context;
    }

    //implemented from itemTouchHelperAdapter
    //for moving the data positions in the list
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < fromPosition; i++) {
                Collections.swap(dummyDataList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(dummyDataList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);

        return true;
    }

    //implemented from itemTouchHelperAdapter
    //for deleting the item
    @Override
    public void onItemDismiss(int position) {
        dummyDataList.remove(position);
        notifyItemRemoved(position);

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
        if (position % 2 == 0) return 1;
        else return 2;


    }

    //this method is used to inflate the view and initialize the view holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //choose a different layout for each item based on position or data
        int itemLayout = 0;
        switch (viewType) {
            case 1:
                itemLayout = R.layout.rv_list_item_type1;
                break;
            case 2:
                itemLayout = R.layout.rv_list_item_type2;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ViewHolder(view);
    }

    //this method is called to bind each viewHolder instance with the data
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DummyData dummyData = dummyDataList.get(position);

        holder.imageView.setImageBitmap(dummyData.getSomeImage());
        holder.textView.setText(dummyData.getSomeText());

        //set onclick listener for the views in the holder
        holder.itemView.setOnClickListener(this);
        holder.textView.setOnClickListener(this);
    }

    //this method returns the total number of items in the list
    @Override
    public int getItemCount() {
        return dummyDataList.size();
    }

    //implemented from View.OnClickListener to handle on click events
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvSomeText:
                listener.sendDataToActivity("MainActivity: TextView clicked");
                break;

            case -1:
                listener.sendDataToActivity("MainActivity: ItemView clicked");
                break;
        }
    }

    //create an interface to communicate with the main activity
    interface onItemClicked {
        void sendDataToActivity(String data);
    }
}
