package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void switchScreenToScore(View v) {
        View view = findViewById(R.id.scorematch);
        Button button = (Button) v;
        setContentView(R.layout.score_main);
    }

    public void switchScreenToBackdrop(View v) {
        View view = findViewById(R.id.virtualbackdrop);
        Button button = (Button) v;
        setContentView(R.layout.backdrop_main);
    }

    public void switchScreenToAuto(View v) {
        View view = findViewById(R.id.auto);
        Button button = (Button) v;
        setContentView(R.layout.auto_main);
    }


    /* Scorer */
    //Declares if team elements are selected
    private boolean blueteamelelement1;
    private boolean blueteamelelement2;
    private boolean redteamelelement1;
    private boolean redteamelelement2;

    //Declares the auto switches
    Switch blueswitch1;
    Switch blueswitch2;
    Switch redswitch1;
    Switch redswitch2;
    Switch redswitch3;
    Switch redswitch4;
    Switch redswitch5;
    Switch redswitch6;
    Switch redswitch7;
    Switch redswitch8;
    Switch blueswitch3;
    Switch blueswitch4;
    Switch blueswitch5;
    Switch blueswitch6;
    Switch blueswitch7;
    Switch blueswitch8;
    FloatingActionButton bluebackdroppixelcountplus;


    // Counting
    private int blueBackdropPixels = 0;
    //Declares the scores
    private int totalbluescore = 0;
    private int totalredscore = 0;
    private int totalbluepurplescore = 0;
    private int totalredpurplescore = 0;
    private int totalblueyellowscore = 0;
    private int totalredyellowscore = 0;
    private int totalblueparkscore = 0;
    private int totalredparkscore = 0;
    private int bluepurplescorerobot1 = 0;
    private int bluepurplescorerobot2 = 0;
    private int redpurplescorerobot1 = 0;
    private int redpurplescorerobot2 = 0;
    private int blueyellowscorerobot1 = 0;
    private int blueyellowscorerobot2 = 0;
    private int redyellowscorerobot1 = 0;
    private int redyellowscorerobot2 = 0;
    private int blueparkscorerobot1 = 0;
    private int blueparkscorerobot2 = 0;
    private int redparkscorerobot1 = 0;
    private int redparkscorerobot2 = 0;



    public void goBack(View v) {
        View view = findViewById(R.id.scorematch);
        Button button = (Button) v;
        setContentView(R.layout.score_main);
    }

    public void calculateScore(View v) {
        View view = findViewById(R.id.calulatebutton);
        Button button = (Button) v;
        teamElementChecker();
        purplePixelChecker();
        yellowPixelChecker();
        autoParkChecker();
        calculateAutoScores();
        updateAutoRedScore();
        updateAutoBlueScore();
    }

    public void teamElementChecker() {
        blueswitch1 = (Switch) findViewById(R.id.blueswitch1);
        blueswitch2 = (Switch) findViewById(R.id.blueswitch2);
        redswitch1 = (Switch) findViewById(R.id.redswitch1);
        redswitch2 = (Switch) findViewById(R.id.redswitch2);

        if (blueswitch1.isChecked())
        {
            blueteamelelement1 = true;
        }
        else
        {
            blueteamelelement1 = false;
        }

        if (blueswitch2.isChecked())
        {
            blueteamelelement2 = true;
        }
        else
        {
            blueteamelelement2 = false;
        }

        if (redswitch1.isChecked())
        {
            redteamelelement1 = true;
        }
        else
        {
            redteamelelement1 = false;
        }

        if (redswitch2.isChecked())
        {
            redteamelelement2 = true;
        }
        else
        {
            redteamelelement2 = false;
        }
    }

    public void purplePixelChecker() {
        blueswitch3 = (Switch) findViewById(R.id.blueswitch3);
        redswitch3 = (Switch) findViewById(R.id.redswitch3);
        blueswitch4 = (Switch) findViewById(R.id.blueswitch4);
        redswitch4 = (Switch) findViewById(R.id.redswitch4);


        if (blueswitch3.isChecked() && blueteamelelement1 == true) {
            bluepurplescorerobot1 = 20;
        } else if (blueswitch3.isChecked() && blueteamelelement1 == false) {
            bluepurplescorerobot1 = 10;
        } else {
            bluepurplescorerobot1 = 0;
        }

        if(blueswitch4.isChecked() && blueteamelelement2 == true) {
            bluepurplescorerobot2 = 20;
        } else if (blueswitch4.isChecked() && blueteamelelement2 == false) {
            bluepurplescorerobot2 = 10;
        } else {
            bluepurplescorerobot2 = 0;
        }

        if (redswitch3.isChecked() && redteamelelement1 == true) {
            redpurplescorerobot1 = 20;
        } else if (redswitch3.isChecked() && redteamelelement1 == false) {
            redpurplescorerobot1 = 10;
        } else {
            redpurplescorerobot1 = 0;
        }

        if(redswitch4.isChecked() && redteamelelement2 == true) {
            redpurplescorerobot2 = 20;
        } else if (redswitch4.isChecked() && redteamelelement2 == false) {
            redpurplescorerobot2 = 10;
        } else {
            redpurplescorerobot2 = 0;
        }

        totalbluepurplescore = bluepurplescorerobot1 + bluepurplescorerobot2;
        totalredpurplescore = redpurplescorerobot1 + redpurplescorerobot2;
    }
    public void yellowPixelChecker() {
        blueswitch5 = (Switch) findViewById(R.id.blueswitch5);
        redswitch5 = (Switch) findViewById(R.id.redswitch5);
        blueswitch6 = (Switch) findViewById(R.id.blueswitch6);
        redswitch6 = (Switch) findViewById(R.id.redswitch6);


        if (blueswitch5.isChecked() && blueteamelelement1 == true) {
            blueyellowscorerobot1 = 25;
        } else if (blueswitch5.isChecked() && blueteamelelement1 == false) {
            blueyellowscorerobot1 = 15;
        } else {
            blueyellowscorerobot1 = 0;
        }

        if(blueswitch6.isChecked() && blueteamelelement2 == true) {
            blueyellowscorerobot2 = 25;
        } else if (blueswitch6.isChecked() && blueteamelelement2 == false) {
            blueyellowscorerobot2 = 15;
        } else {
            blueyellowscorerobot2 = 0;
        }

        if (redswitch5.isChecked() && redteamelelement1 == true) {
            redyellowscorerobot1 = 25;
        } else if (redswitch5.isChecked() && redteamelelement1 == false) {
            redyellowscorerobot1 = 15;
        } else {
            redyellowscorerobot1 = 0;
        }

        if(redswitch6.isChecked() && redteamelelement2 == true) {
            redyellowscorerobot2 = 25;
        } else if (redswitch6.isChecked() && redteamelelement2 == false) {
            redyellowscorerobot2 = 15;
        } else {
            redyellowscorerobot2 = 0;
        }

        totalblueyellowscore = blueyellowscorerobot1 + blueyellowscorerobot2;
        totalredyellowscore = redyellowscorerobot1 + redyellowscorerobot2;
    }
    public void autoParkChecker() {
        blueswitch7 = (Switch) findViewById(R.id.blueswitch7);
        redswitch7 = (Switch) findViewById(R.id.redswitch7);
        blueswitch8 = (Switch) findViewById(R.id.blueswitch8);
        redswitch8 = (Switch) findViewById(R.id.redswitch8);

        if(blueswitch7.isChecked()) {
            blueparkscorerobot1 = 5;
        } else {
            blueparkscorerobot1 = 0;
        }

        if(blueswitch8.isChecked()) {
            blueparkscorerobot2 = 5;
        } else {
            blueparkscorerobot2 = 0;
        }

        if(redswitch7.isChecked()) {
            redparkscorerobot1 = 5;
        } else {
            redparkscorerobot1 = 0;
        }

        if(redswitch8.isChecked()) {
            redparkscorerobot2 = 5;
        } else {
            redparkscorerobot2 = 0;
        }

        totalblueparkscore = blueparkscorerobot1 + blueparkscorerobot2;
        totalredparkscore = redparkscorerobot1 + redparkscorerobot2;
    }


    public void blueBackdropPixelAdd()
    {
        blueBackdropPixels++;
        //updateAutoBackdropPixels();
    }

    public void blueBackdropPixelSubtract()
    {
        blueBackdropPixels -= 1;
        updateAutoBackdropPixels();
    }

    public void updateAutoBackdropPixels() {
        TextView totalScoreTextView = findViewById(R.id.bluebackdroppixelcount);
        totalScoreTextView.setText(String.valueOf(blueBackdropPixels));
    }




    public void calculateAutoScores() {
        totalbluescore = totalbluepurplescore + totalblueyellowscore + totalblueparkscore;
        totalredscore = totalredpurplescore + totalredyellowscore + totalredparkscore;
    }

    public void updateAutoRedScore() {
        TextView totalScoreTextView = findViewById(R.id.redtotalscore);
        totalScoreTextView.setText(String.valueOf(totalredscore));
    }

    public void updateAutoBlueScore() {
        TextView totalScoreTextView = findViewById(R.id.bluetotalscore);
        totalScoreTextView.setText(String.valueOf(totalbluescore));
    }
}