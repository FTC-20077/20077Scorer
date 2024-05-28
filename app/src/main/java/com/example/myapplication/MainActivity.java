package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
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

    //Declares the scores
    private int totalredscore = 0;
    private int totalbluescore = 0;
    private int totalbluepurplescorerobot1 = 0;
    private int totalbluepurplescorerobot2 = 0;
    private int totalredpurplescorerobot1 = 0;
    private int totalredpurplescorerobot2 = 0;

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
        View view = findViewById(R.id.scorematch);
        Button button = (Button) v;
        setContentView(R.layout.backdrop_main);
    }

    public void goBack(View v) {
        View view = findViewById(R.id.scorematch);
        Button button = (Button) v;
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View v) {
        View view = findViewById(R.id.calulatebutton);
        Button button = (Button) v;
        teamElementChecker();
        purplePixelChecker();
        calculateBlueTotalScore();
        calculateRedTotalScore();
        updateRedScore();
        updateBlueScore();
    }

    public void collectBlueAutoPixels(Number v) {
        Number number = (Number) v;
        int input = v.intValue();
    }

    public void collectRedAutoPixels(Number v) {
        Number number = (Number) v;
        int input = v.intValue();
    }

    public void purplePixelChecker() {
        blueswitch3 = (Switch) findViewById(R.id.blueswitch3);
        redswitch3 = (Switch) findViewById(R.id.redswitch3);
        blueswitch4 = (Switch) findViewById(R.id.blueswitch4);
        redswitch4 = (Switch) findViewById(R.id.redswitch4);


        if (blueswitch3.isChecked() && blueteamelelement1 == true) {
            totalbluepurplescorerobot1 = 20;
        } else if (blueswitch3.isChecked() && blueteamelelement1 == false) {
            totalbluepurplescorerobot1 = 10;
        } else {
            totalbluepurplescorerobot1 = 0;
        }

        if(blueswitch4.isChecked() && blueteamelelement2 == true) {
            totalbluepurplescorerobot2 = 20;
            } else if (blueswitch4.isChecked() && blueteamelelement2 == false) {
            totalbluepurplescorerobot2 = 10;
        } else {
            totalbluepurplescorerobot2 = 0;
        }

        if (redswitch3.isChecked() && redteamelelement1 == true) {
            totalredpurplescorerobot1 = 20;
        } else if (redswitch3.isChecked() && redteamelelement1 == false) {
            totalredpurplescorerobot1 = 10;
        } else {
            totalredpurplescorerobot1 = 0;
        }

        if(redswitch4.isChecked() && redteamelelement2 == true) {
            totalredpurplescorerobot2 = 20;
            } else if (redswitch4.isChecked() && redteamelelement2 == false) {
            totalredpurplescorerobot2 = 10;
        } else {
            totalredpurplescorerobot2 = 0;
        }
    }

    public void teamElementChecker()
    {
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

    public void updateRedScore()
    {
        TextView totalScoreTextView = findViewById(R.id.redtotalscore);
        totalScoreTextView.setText(String.valueOf(totalredscore));
    }

    public void updateBlueScore()
    {
        TextView totalScoreTextView = findViewById(R.id.bluetotalscore);
        totalScoreTextView.setText(String.valueOf(totalbluescore));
    }

    public void calculateBlueTotalScore()
    {
        totalbluescore = totalbluepurplescorerobot1 + totalbluepurplescorerobot2;
    }

    public void calculateRedTotalScore()
    {
        totalredscore = totalredpurplescorerobot1 + totalredpurplescorerobot2;
    }
}