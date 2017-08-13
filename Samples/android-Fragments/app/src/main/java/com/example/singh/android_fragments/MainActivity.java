package com.example.singh.android_fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.singh.android_fragments.carFragments.Car;
import com.example.singh.android_fragments.carFragments.CarInputFragment;
import com.example.singh.android_fragments.carFragments.CarListFragment;
import com.example.singh.android_fragments.coloredFragments.BlueFragment;
import com.example.singh.android_fragments.coloredFragments.RedFragment;
import com.example.singh.android_fragments.coloredFragments.YellowFragment;

public class MainActivity extends AppCompatActivity
        implements
        StaticFragment.OnFragmentInteractionListener,
        CarInputFragment.OnFragmentInteractionListener,
        CarListFragment.OnFragmentInteractionListener {

    private static final String INPUT_CAR_FRAGMENT_TAG = "InputCarFragTag";
    private static final String CAR_LIST_FRAGMENT_TAG = "CarListFragTag";
    private static final String RED_FRAGMENT_TAG = "RedFragTag";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragTag";
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragTag";

    private FrameLayout flColored;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flColored = (FrameLayout) findViewById(R.id.flColored);

    }


    @Override
    public void toastActivity(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    public void addFragment(View view) {

        ;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (view.getId()) {


            case R.id.btnEnterCarDetails:

                CarInputFragment carInputFragment = CarInputFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.flFirst, carInputFragment, INPUT_CAR_FRAGMENT_TAG)
                        .addToBackStack(INPUT_CAR_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnAddRed:
                CheckFragFrameVisible();
                RedFragment redFragment = RedFragment.newInstance();
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .add(R.id.flColored, redFragment, RED_FRAGMENT_TAG)
                        .addToBackStack(RED_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnAddBlue:
                CheckFragFrameVisible();
                BlueFragment blueFragment = BlueFragment.newInstance();
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .add(R.id.flColored, blueFragment, BLUE_FRAGMENT_TAG)
                        .addToBackStack(BLUE_FRAGMENT_TAG)
                        .commit();
                break;

            case R.id.btnAddYellow:
                CheckFragFrameVisible();
                YellowFragment yellowFragment = YellowFragment.newInstance();
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .add(R.id.flColored, yellowFragment, YELLOW_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        .commit();
                break;

        }

    }

    private void CheckFragFrameVisible() {
        int isFragAdded = flColored.getVisibility();

        if (isFragAdded == View.GONE) {
            flColored.setVisibility(View.VISIBLE);
        }
    }

    public void removeFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (view.getId()) {

            case R.id.btnRemoveRed:

                RedFragment redFragment = (RedFragment) fragmentManager.findFragmentByTag(RED_FRAGMENT_TAG);
                if (redFragment != null) {
                    fragmentManager.beginTransaction()
                            .remove(redFragment)
                            .commit();
                    flColored.setVisibility(View.GONE);
                }
                break;

            case R.id.btnRemoveBlue:

                BlueFragment blueFragment = (BlueFragment) fragmentManager.findFragmentByTag(BLUE_FRAGMENT_TAG);
                if (blueFragment != null) {
                    fragmentManager.beginTransaction()
                            .remove(blueFragment)
                            .commit();
                    flColored.setVisibility(View.GONE);
                }
                break;

            case R.id.btnRemoveYellow:

                YellowFragment yellowFragment = (YellowFragment) fragmentManager.findFragmentByTag(YELLOW_FRAGMENT_TAG);
                if (yellowFragment != null) {
                    fragmentManager.beginTransaction()
                            .remove(yellowFragment)
                            .commit();
                    flColored.setVisibility(View.GONE);
                }
                break;
        }



    }


    @Override
    public void addToCarList(Car car) {

        CarListFragment carListFragment = (CarListFragment) getSupportFragmentManager().findFragmentById(R.id.flSecond);

        if (carListFragment != null) {
            carListFragment.addToList(car);
        } else {
            CarListFragment newCarListFragment = CarListFragment.newInstance(car);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.flSecond, newCarListFragment, CAR_LIST_FRAGMENT_TAG)
                    .addToBackStack(CAR_LIST_FRAGMENT_TAG)
                    .commit();

        }

    }

    @Override
    public void carAdded(Boolean isAdded) {

        if (isAdded)
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();

    }
}
