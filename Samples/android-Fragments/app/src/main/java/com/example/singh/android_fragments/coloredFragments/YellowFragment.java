package com.example.singh.android_fragments.coloredFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.singh.android_fragments.R;

public class YellowFragment extends Fragment {

    public YellowFragment() {
        // Required empty public constructor
    }

    public static YellowFragment newInstance() {
        YellowFragment fragment = new YellowFragment();
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
        return inflater.inflate(R.layout.fragment_yellow, container, false);
    }

}
