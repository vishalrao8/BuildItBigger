package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokeui.JokeActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String INTENT_EXTRA = "INTENT_EXTRA";

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

        try {

            String joke = new EndpointsAsyncTask().execute(new String[]{"getJoke"}).get();
            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtra(INTENT_EXTRA, joke);
            startActivity(intent);

        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.error_toast), Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.error_toast), Toast.LENGTH_SHORT).show();
        }

    }

    @VisibleForTesting
    public static boolean testAsyncTask () {

        String res = null;
        try {
            res = new EndpointsAsyncTask().execute(new String[]{"getJoke"}).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res != null && !res.equals("");
    }
}
