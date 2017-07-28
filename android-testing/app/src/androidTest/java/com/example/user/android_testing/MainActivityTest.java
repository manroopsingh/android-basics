package com.example.user.android_testing;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by singh on 7/19/17.
 */

public class MainActivityTest {


    private static final String PACKAGENAME = "com.example.user.android_testing";
    String stringToBeTyped;


//    @Rule
//    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Rule
    public IntentsTestRule<MainActivity> mainActivityIntentsTestRule = new IntentsTestRule<>(MainActivity.class) ;


    @Before
    public void setup(){

        stringToBeTyped = "Hello world";
    }

    @Test
    public void testText_mainActivity(){

        onView(withId(R.id.edittext))
                .perform(typeText(stringToBeTyped), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textview))
                .check(matches(withText(stringToBeTyped)));


    }

    @Test
    public void testIntent_secondActivity(){

        onView(withId(R.id.edittext))
                .perform(typeText(stringToBeTyped), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.buttonIntent))
                .perform(click());


        intended(allOf(
                hasComponent(hasShortClassName(".SecondActivity")),
                toPackage(PACKAGENAME),
                hasExtra(MainActivity.KeyExtra, stringToBeTyped)));


    }
}




















