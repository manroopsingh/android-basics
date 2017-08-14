package com.example.singh.android_fragments.coloredFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.singh.android_fragments.R;

public class BlueFragment extends Fragment {

    public BlueFragment() {
        // Required empty public constructor
    }

    public static BlueFragment newInstance() {
        BlueFragment fragment = new BlueFragment();
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
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

}
