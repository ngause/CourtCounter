package com.example.android.courtcounter;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsTeamA = 0;
    int pointsTeamB = 0;

    // spinner change image variables
    private String[] listOfObjects;
    private TypedArray images;
    private ImageView itemImage;
    private ImageView itemImageB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);

        //change image with spinner

        listOfObjects = getResources().getStringArray(R.array.teams_array);
        images = getResources().obtainTypedArray(R.array.team_image);

        // Team A spinner

        //TextView spinnerHeader = (TextView)findViewById(R.id.team_a_name);
        itemImage = (ImageView)findViewById(R.id.team_a_image);
        final Spinner spinner = (Spinner)findViewById(R.id.team_a_spinner);
        //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, listOfObjects);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, listOfObjects);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemImage.setImageResource(images.getResourceId(spinner.getSelectedItemPosition(), -1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Team B spinner
        //TextView spinnerHeaderB = (TextView)findViewById(R.id.team_b_name);
        itemImageB = (ImageView)findViewById(R.id.team_b_image);
        final Spinner spinnerB = (Spinner)findViewById(R.id.team_b_spinner);
        //ArrayAdapter<String> spinnerAdapterB = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, listOfObjects);
        ArrayAdapter<String> spinnerAdapterB = new ArrayAdapter<String>(this,R.layout.spinner_item, listOfObjects);
        spinnerAdapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerB.setAdapter(spinnerAdapterB);
        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemImageB.setImageResource(images.getResourceId(spinnerB.getSelectedItemPosition(), -1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
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

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        pointsTeamA = pointsTeamA + 1;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        pointsTeamA = pointsTeamA + 2;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        pointsTeamA = pointsTeamA +3;
        displayForTeamA(pointsTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        pointsTeamB = pointsTeamB + 1;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        pointsTeamB = pointsTeamB + 2;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        pointsTeamB = pointsTeamB +3;
        displayForTeamB(pointsTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets the given score for both teams to 0.
     */
    public void resetScore(View v) {
        pointsTeamA = 0;
        pointsTeamB = 0;
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);
    }
}
