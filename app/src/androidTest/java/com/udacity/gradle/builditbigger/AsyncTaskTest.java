package com.udacity.gradle.builditbigger;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.base.IdlingResourceRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        Espresso.registerIdlingResources(new SimpleIdlingResource(true));
    }


    @Test
    public void asyncTaskTest() {
        Espresso.onView(ViewMatchers.withId(R.id.endpointjoke))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.content))
                .check(ViewAssertions
                        .matches(Matchers.not(ViewMatchers.withText(""))));

    }

    @After
    public void reset() {
        Espresso.unregisterIdlingResources(SimpleIdlingResource.getInstance());
        SimpleIdlingResource.reset();
    }

}
