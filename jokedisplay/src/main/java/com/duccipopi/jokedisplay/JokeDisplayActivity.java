package com.duccipopi.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_JOKE)) {
            TextView content = findViewById(R.id.content);
            content.setText(intent.getStringExtra(EXTRA_JOKE));
        }

    }
}
