package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ducci on 14/01/2018.
 */

public class SimpleIdlingResource implements IdlingResource {

    private static SimpleIdlingResource mInstance;

    private AtomicBoolean mIsIdle = new AtomicBoolean(false);
    private ResourceCallback mCallback;

    public SimpleIdlingResource(boolean startIdle) {
        mInstance = this;
        setIdleState(startIdle);
    }

    private SimpleIdlingResource() {
    }

    public static SimpleIdlingResource getInstance() {
        return mInstance;
    }

    public static void reset() {
        mInstance = null;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return mIsIdle.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallback = callback;
    }

    public void setIdleState(boolean isIdleNow) {
        mIsIdle.set(isIdleNow);
        if (isIdleNow && mCallback != null) {
            mCallback.onTransitionToIdle();
        }
    }
}
