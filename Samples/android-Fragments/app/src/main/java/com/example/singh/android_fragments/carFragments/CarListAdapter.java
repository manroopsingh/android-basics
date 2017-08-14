package com.example.singh.android_fragments.carFragments;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.singh.android_fragments.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 12-Aug-17.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder>{

    List<Car> carList = new ArrayList<>();


    public CarListAdapter(List<Car> carList) {
        this.carList = carList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCarModel;
        TextView tvCarYear;
        TextView tvCarMake;
        TextView tvCarColor;


        public ViewHolder(View itemView) {
            super(itemView);

            tvCarColor = itemView.findViewById(R.id.tvCarColor);
            tvCarMake = itemView.findViewById(R.id.tvCarMake);
            tvCarModel = itemView.findViewById(R.id.tvCarModel);
            tvCarYear = itemView.findViewById(R.id.tvCarYear);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, null, false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d("TAG", "onBindViewHolder: ");
        Car car = carList.get(position);
        holder.tvCarYear.setText(String.valueOf(car.getYear()));
        holder.tvCarMake.setText(car.getMake());
        holder.tvCarModel.setText(car.getModel());
        holder.tvCarColor.setText(car.getColor());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
