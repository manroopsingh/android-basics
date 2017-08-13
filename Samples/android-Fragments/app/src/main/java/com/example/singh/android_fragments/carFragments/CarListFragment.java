package com.example.singh.android_fragments.carFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.singh.android_fragments.R;

import java.util.ArrayList;
import java.util.List;


public class CarListFragment extends Fragment {

    private static final String KEY_CAR = "keyCar";
    List<Car> carList = new ArrayList<>();
    private RecyclerView rvCarList;
    private RecyclerView.LayoutManager layoutManager;
    private CarListAdapter carListAdapter;

    private OnFragmentInteractionListener mListener;

    public CarListFragment() {
        // Required empty public constructor
    }

    public static CarListFragment newInstance(Car car) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CAR, car);
        CarListFragment fragment = new CarListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity());
        carListAdapter = new CarListAdapter(carList);


        if(getArguments()!=null){
            carList.add((Car) getArguments().getParcelable(KEY_CAR));
            carListAdapter.notifyDataSetChanged();
            mListener.carAdded(true);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCarList = view.findViewById(R.id.rvCarList);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvCarList.setLayoutManager(layoutManager);
        rvCarList.setAdapter(carListAdapter);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void addToList(Car car){

        carList.add(car);
        carListAdapter.notifyDataSetChanged();
        mListener.carAdded(true);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void carAdded(Boolean isAdded);
    }
}
