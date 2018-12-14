package com.example.jokeui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String INTENT_EXTRA = "INTENT_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTV = findViewById(R.id.jokeTextView);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(INTENT_EXTRA)){

            jokeTV.setText(intent.getStringExtra(INTENT_EXTRA));

        }
    }
}
