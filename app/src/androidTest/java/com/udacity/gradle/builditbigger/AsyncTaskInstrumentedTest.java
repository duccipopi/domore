package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by ducci on 20/01/2018.
 * https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
 * https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AsyncTaskInstrumentedTest {

    @Test
    public void testAsyncTask() throws InterruptedException {
        final CountDownLatch countdown = new CountDownLatch(1);
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                assertNotNull("AsyncTask result is null", result);
                assertTrue("AsyncTask result is empty", result.length() > 0);
                countdown.countDown();
            }
        };

        testTask.execute(InstrumentationRegistry.getContext());
        countdown.await();
    }
}
