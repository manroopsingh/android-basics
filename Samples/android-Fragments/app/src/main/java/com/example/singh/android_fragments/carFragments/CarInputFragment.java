package com.example.singh.android_fragments.carFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.singh.android_fragments.R;

public class
CarInputFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText etModel;
    private EditText etMake;
    private EditText etColor;
    private EditText etYear;
    private Button btnAddCarToList;
    private String carModel, carMake, carColor;
    private int carYear;

    public CarInputFragment() {
        // Required empty public constructor
    }


    public static CarInputFragment newInstance() {
        CarInputFragment fragment = new CarInputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_input, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etModel = view.findViewById(R.id.etCarModel);
        etYear = view.findViewById(R.id.etCarYear);
        etMake = view.findViewById(R.id.etCarMake);
        etColor = view.findViewById(R.id.etCarColor);
        btnAddCarToList = view.findViewById(R.id.btnAddToCarList);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnAddCarToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carModel= etModel.getText().toString();
                carColor = etColor.getText().toString();
                carMake =  etMake.getText().toString();
                carYear = Integer.parseInt(etYear.getText().toString());
                mListener.addToCarList(new Car(carModel, carMake,carYear, carColor));
            }
        });

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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void addToCarList(Car car);
    }
}
