package com.udacity.gradle.builditbigger;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.duccipopi.jokedisplay.JokeDisplayActivity;
import com.duccipopi.jokelib.Joker;


public class MainActivity extends AppCompatActivity {

    private static final int LIB_JOKE_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Joker joker = new Joker();
        String joke = joker.tellJoke();

        tellJokeFromLib(joke);
        tellJokeToAndroidLib(joke);
    }

    public void tellJokeByEndpoint(View view) {
        new EndpointsAsyncTask().execute(this);
    }

    private void tellJokeToAndroidLib(String joke) {
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.EXTRA_JOKE, joke);

        startActivity(intent);
    }

    private void tellJokeFromLib(String joke) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);

        notificationManager.notify(LIB_JOKE_ID,
                builder.setSmallIcon(R.drawable.ic_small_joke)
                        .setContentTitle(getTitle())
                        .setContentText(joke)
                        .setAutoCancel(true)
                        .build());
    }


}
