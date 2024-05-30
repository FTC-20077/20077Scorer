package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void switchScreenToScore(View v) {
        View view = findViewById(R.id.score);
        Button button = (Button) v;
        setContentView(R.layout.score_main);
    }

    public void switchScreenToBackdrop(View v) {
        View view = findViewById(R.id.backdrop);
        Button button = (Button) v;
        setContentView(R.layout.backdrop_main);
    }

    public void switchScreenToAuto(View v) {
        View view = findViewById(R.id.auto);
        Button button = (Button) v;
        setContentView(R.layout.auto_main);
    }

    public void switchScreenToTeleop(View v) {
        View view = findViewById(R.id.teleop);
        Button button = (Button) v;
        setContentView(R.layout.teleop_main);
    }

    public void switchScreenToEndgame(View v) {
        View view = findViewById(R.id.endgame);
        Button button = (Button) v;
        setContentView(R.layout.endgame_main);
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

    //Declares image buttons
    ImageButton bluebackdropadd;
    ImageButton bluebackdropsubtract;
    ImageButton redbackdropadd;
    ImageButton redbackdropsubtract;
    ImageButton bluebackdropaddteleop;
    ImageButton bluebackdropsubtractteleop;
    ImageButton redbackdropaddteleop;
    ImageButton redbackdropsubtractteleop;

    // Counting
    private int blueBackdropPixels = 0;
    private int blueBackstagePixels = 0;
    private int redBackstagePixels = 0;
    private int redBackdropPixels = 0;
    private int blueBackdropPixelsTeleOp = 0;
    private int blueBackstagePixelsTeleOp = 0;
    private int redBackstagePixelsTeleOp = 0;
    private int redBackdropPixelsTeleOp = 0;
    private int bluemosaics = 0;
    private int redmosaics = 0;
    private int bluesetlines = 0;
    private int redsetlines = 0;

    //Declares the scores
    private int totalbluescore = 0;
    private int totalredscore = 0;
    private int totalbluescoreteleop = 0;
    private int totalredscoreteleop = 0;
    private int totalbluepurplescore = 0;
    private int totalredpurplescore = 0;
    private int totalblueyellowscore = 0;
    private int totalredyellowscore = 0;
    private int totalblueparkscore = 0;
    private int totalredparkscore = 0;
    private int blueBackdropScore = 0;
    private int redBackdropScore = 0;
    private int blueBackstageScore = 0;
    private int redBackstageScore = 0;
    private int blueBackdropScoreTeleOp = 0;
    private int redBackdropScoreTeleOp = 0;
    private int blueBackstageScoreTeleOp = 0;
    private int redBackstageScoreTeleOp = 0;
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
    private int bluemosaicsscore = 0;
    private int redmosaicsscore = 0;
    private int bluesetlinesscore = 0;
    private int redsetlinesscore = 0;

    //Declares current page
    private int currentPage = 0;

    public void nextPage(View v) {
        View view = findViewById(R.id.nextpage);
        Button button = (Button) v;
        if (currentPage == 1) {
            setContentView(R.layout.teleop_main);
        } else if (currentPage == 2){
            setContentView(R.layout.endgame_main);
        } else if (currentPage == 3){
            setContentView(R.layout.score_main);
        }

    }

    public void goBackToScore(View v) {
        View view = findViewById(R.id.backbutton);
        Button button = (Button) v;
        setContentView(R.layout.score_main);
    }

    public void goBacktoMain(View v) {
            View view = findViewById(R.id.backbutton);
            Button button = (Button) v;
            setContentView(R.layout.activity_main);
        }

    public void calculateScore(View v) {
            View view = findViewById(R.id.bluebackdropsubtract);
            Button button = (Button) v;
            teamElementChecker();
            purplePixelChecker();
            yellowPixelChecker();
            autoParkChecker();
            calculateAutoScores();
            updateAutoRedScore();
            updateAutoBlueScore();
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

    public void purplePixelChecker()
    {
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
    public void yellowPixelChecker()
    {
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
    public void autoParkChecker()
    {
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

    public void blueBackdropPixelAdd(View v)
    {
        View view = findViewById(R.id.bluebackdropadd);
        ImageButton imageButtonBDA = (ImageButton) v;
        blueBackdropPixels += 1;

        updateAutoBlueBackdropPixels();
    }

    public void blueBackdropPixelSubtract(View v)
    {
        View view = findViewById(R.id.bluebackdropsubtract);
        ImageButton imageButtonBDS = (ImageButton) v;
        blueBackdropPixels -= 1;

        if (blueBackdropPixels <= 0) {
            blueBackdropPixels = 0;
        }

        updateAutoBlueBackdropPixels();
    }

    public void redBackdropPixelAdd(View v)
    {
        View view = findViewById(R.id.redbackdropadd);
        ImageButton imageButtonRDA = (ImageButton) v;
        redBackdropPixels += 1;

        updateAutoRedBackdropPixels();
    }

    public void redBackdropPixelSubtract(View v)
    {
        View view = findViewById(R.id.redbackdropsubtract);
        ImageButton imageButtonRDS = (ImageButton) v;
        redBackdropPixels -= 1;

        if(redBackdropPixels <= 0) {
            redBackdropPixels = 0;
        }
        updateAutoRedBackdropPixels();
    }

    public void blueBackstagePixelAdd(View v)
    {
        View view = findViewById(R.id.bluebackstageadd);
        ImageButton imageButtonBSA = (ImageButton) v;

        blueBackstagePixels += 1;
        updateAutoBlueBackstagePixels();
    }

    public void blueBackstagePixelSubtract(View v)
    {
        View view = findViewById(R.id.bluebackstagesubtract);
        ImageButton imageButtonBSS = (ImageButton) v;
        blueBackstagePixels -= 1;

        if(blueBackstagePixels <= 0) {
            blueBackstagePixels = 0;
        }
        updateAutoBlueBackstagePixels();
    }

    public void redBackstagePixelAdd(View v)
    {
        View view = findViewById(R.id.redbackstageadd);
        ImageButton imageButtonRSA = (ImageButton) v;

        redBackstagePixels += 1;
        updateAutoRedBackstagePixels();
    }

    public void redBackstagePixelSubtract(View v)
    {
        View view = findViewById(R.id.redbackstagesubtract);
        ImageButton imageButtonRSS = (ImageButton) v;
        redBackstagePixels -= 1;

        if(redBackstagePixels <= 0) {
            redBackstagePixels = 0;
        }
        updateAutoRedBackstagePixels();
    }

    public void blueBackdropPixelAddTeleOp(View v)
    {
        View view = findViewById(R.id.bluebackdropaddteleop);
        ImageButton imageButtonBDAT = (ImageButton) v;
        blueBackdropPixelsTeleOp += 1;

        updateTeleOpBlueBackdropPixels();
    }

    public void blueBackdropPixelSubtractTeleop(View v)
    {
        View view = findViewById(R.id.bluebackdropsubtractteleop);
        ImageButton imageButtonBDST = (ImageButton) v;
        blueBackdropPixelsTeleOp -= 1;

        if (blueBackdropPixelsTeleOp <= 0) {
            blueBackdropPixelsTeleOp = 0;
        }

        updateTeleOpBlueBackdropPixels();
    }

    public void redBackdropPixelAddTeleOp(View v)
    {
        View view = findViewById(R.id.redbackdropaddteleop);
        ImageButton imageButtonBDAT = (ImageButton) v;
        redBackdropPixelsTeleOp += 1;

        updateTeleOpRedBackdropPixels();
    }

    public void redBackdropPixelSubtractTeleop(View v)
    {
        View view = findViewById(R.id.redbackdropsubtractteleop);
        ImageButton imageButtonBDST = (ImageButton) v;
        redBackdropPixelsTeleOp -= 1;

        if (redBackdropPixelsTeleOp <= 0) {
            redBackdropPixelsTeleOp = 0;
        }

        updateTeleOpRedBackdropPixels();
    }

    public void blueBackstagePixelAddTeleOp(View v)
    {
        View view = findViewById(R.id.bluebackstageaddteleop);
        ImageButton imageButtonBDAT = (ImageButton) v;
        blueBackstagePixelsTeleOp += 1;

        updateTeleOpBlueBackstagePixels();
    }

    public void blueBackstagePixelSubtractTeleop(View v)
    {
        View view = findViewById(R.id.bluebackstagesubtractteleop);
        ImageButton imageButtonBDST = (ImageButton) v;
        blueBackstagePixelsTeleOp -= 1;

        if (blueBackstagePixelsTeleOp <= 0) {
            blueBackstagePixelsTeleOp = 0;
        }

        updateTeleOpBlueBackstagePixels();
    }

    public void redBackstagePixelAddTeleOp(View v)
    {
        View view = findViewById(R.id.redbackstageaddteleop);
        ImageButton imageButtonBDAT = (ImageButton) v;
        redBackstagePixelsTeleOp += 1;

        updateTeleOpRedBackstagePixels();
    }

    public void redBackstagePixelSubtractTeleop(View v)
    {
        View view = findViewById(R.id.redbackstagesubtractteleop);
        ImageButton imageButtonBDST = (ImageButton) v;
        redBackstagePixelsTeleOp -= 1;

        if (redBackstagePixelsTeleOp <= 0) {
            redBackstagePixelsTeleOp = 0;
        }

        updateTeleOpRedBackstagePixels();
    }

    public void blueMosaicAdd(View v)
    {
        View view = findViewById(R.id.bluemosaicsaddteleop);
        ImageButton imageButtonBDA = (ImageButton) v;
        bluemosaics += 1;

        updateBlueMosaics();
    }

    public void blueMosaicsSubtract(View v)
    {
        View view = findViewById(R.id.bluemosaicsubtractteleop);
        ImageButton imageButtonBDS = (ImageButton) v;
        bluemosaics -= 1;

        if (bluemosaics <= 0) {
            bluemosaics = 0;
        }

        updateBlueMosaics();
    }

    public void redMosaicsAdd(View v)
    {
        View view = findViewById(R.id.redmosaicaddteleop);
        ImageButton imageButtonRDA = (ImageButton) v;
        redmosaics += 1;

        updateRedMosaics();
    }

    public void redMosaicsSubtract(View v)
    {
        View view = findViewById(R.id.redmosaicsubtractteleop);
        ImageButton imageButtonRDS = (ImageButton) v;
        redmosaics -= 1;

        if(redmosaics <= 0) {
            redmosaics = 0;
        }
        updateRedMosaics();
    }

    public void blueSetlinesAdd(View v)
    {
        View view = findViewById(R.id.bluesetlineaddteleop);
        ImageButton imageButtonBDA = (ImageButton) v;
        bluesetlines += 1;

        updateBlueSetlines();
    }

    public void blueSetlinesSubtract(View v)
    {
        View view = findViewById(R.id.bluesetlinesubtractteleop);
        ImageButton imageButtonBDS = (ImageButton) v;
        bluesetlines -= 1;

        if (bluesetlines <= 0) {
            bluesetlines = 0;
        }

        updateBlueSetlines();
    }

    public void redSetlinesAdd(View v)
    {
        View view = findViewById(R.id.redsetlineaddteleop);
        ImageButton imageButtonRDA = (ImageButton) v;
        redsetlines += 1;

        updateRedSetlines();
    }

    public void redSetlinesSubtract(View v)
    {
        View view = findViewById(R.id.redsetlinesubtractteleop);
        ImageButton imageButtonRDS = (ImageButton) v;
        redsetlines -= 1;

        if(redsetlines <= 0) {
            redsetlines = 0;
        }
        updateRedSetlines();
    }

    public void updateAutoBlueBackdropPixels() {
        TextView totalScoreTextView = findViewById(R.id.bluebackdropcount);
        totalScoreTextView.setText(String.valueOf(blueBackdropPixels));
        blueBackdropScore = blueBackdropPixels * 5;
        calculateAutoScores();
    }

    public void updateAutoRedBackdropPixels() {
        TextView totalScoreTextView = findViewById(R.id.redbackdropcount);
        totalScoreTextView.setText(String.valueOf(redBackdropPixels));
        redBackdropScore = redBackdropPixels * 5;
        calculateAutoScores();
    }

    public void updateAutoBlueBackstagePixels() {
        TextView totalScoreTextView = findViewById(R.id.bluebackstagecount);
        totalScoreTextView.setText(String.valueOf(blueBackstagePixels));
        blueBackstageScore = blueBackstagePixels * 3;
        calculateAutoScores();
    }

    public void updateAutoRedBackstagePixels() {
        TextView totalScoreTextView = findViewById(R.id.redbackstagecount);
        totalScoreTextView.setText(String.valueOf(redBackstagePixels));
        redBackstageScore = redBackstagePixels * 3;
        calculateAutoScores();
    }

    public void updateTeleOpBlueBackdropPixels() {
        TextView totalScoreTextView = findViewById(R.id.bluebackdropcountteleop);
        totalScoreTextView.setText(String.valueOf(blueBackdropPixelsTeleOp));
        blueBackdropScoreTeleOp = blueBackdropPixelsTeleOp * 3;
        calculateTeleOpScores();
    }

    public void updateTeleOpRedBackdropPixels() {
        TextView totalScoreTextView = findViewById(R.id.redbackdropcountteleop);
        totalScoreTextView.setText(String.valueOf(redBackdropPixelsTeleOp));
        redBackdropScoreTeleOp = redBackdropPixelsTeleOp * 3;
        calculateTeleOpScores();
    }

    public void updateTeleOpBlueBackstagePixels() {
        TextView totalScoreTextView = findViewById(R.id.bluebackstagecountteleop);
        totalScoreTextView.setText(String.valueOf(blueBackstagePixelsTeleOp));
        blueBackstageScoreTeleOp = blueBackstagePixelsTeleOp;
        calculateTeleOpScores();
    }

    public void updateTeleOpRedBackstagePixels() {
        TextView totalScoreTextView = findViewById(R.id.redbackstagecountteleop);
        totalScoreTextView.setText(String.valueOf(redBackstagePixelsTeleOp));
        redBackstageScoreTeleOp = redBackstagePixelsTeleOp;
        calculateTeleOpScores();
    }

    public void updateBlueMosaics() {
        TextView totalScoreTextView = findViewById(R.id.bluemosaiccountteleop);
        totalScoreTextView.setText(String.valueOf(bluemosaics));
        bluemosaicsscore = bluemosaics * 10;
        calculateTeleOpScores();
    }

    public void updateRedMosaics() {
        TextView totalScoreTextView = findViewById(R.id.redmosaiccountteleop);
        totalScoreTextView.setText(String.valueOf(redmosaics));
        redmosaicsscore = redmosaics * 10;
        calculateTeleOpScores();
    }

    public void updateBlueSetlines() {
        TextView totalScoreTextView = findViewById(R.id.bluesetlineteleop);
        totalScoreTextView.setText(String.valueOf(bluesetlines));
        bluesetlinesscore = bluesetlines * 10;
        calculateTeleOpScores();
    }

    public void updateRedSetlines() {
        TextView totalScoreTextView = findViewById(R.id.redsetlineteleop);
        totalScoreTextView.setText(String.valueOf(redsetlines));
        redsetlinesscore = redsetlines * 10;
        calculateTeleOpScores();
    }



    public void calculateAutoScores() {
        totalbluescore = totalbluepurplescore + totalblueyellowscore + totalblueparkscore + blueBackdropScore + blueBackstageScore;
        totalredscore = totalredpurplescore + totalredyellowscore + totalredparkscore + redBackdropScore + redBackstageScore;
        updateAutoBlueScore();
        updateAutoRedScore();
    }

    public void calculateTeleOpScores() {
        totalbluescoreteleop = blueBackdropScoreTeleOp + blueBackstageScoreTeleOp + bluemosaicsscore + bluesetlinesscore;
        totalredscoreteleop = redBackdropScoreTeleOp + redBackstageScoreTeleOp + redmosaicsscore + redsetlinesscore;
        updateTeleOpBlueScore();
        updateTeleOpRedScore();

    }

    //Updates the scores
    public void updateAutoRedScore() {
        TextView totalScoreTextView = findViewById(R.id.redtotalscore);
        totalScoreTextView.setText(String.valueOf(totalredscore));
    }

    public void updateAutoBlueScore() {
        TextView totalScoreTextView = findViewById(R.id.bluetotalscore);
        totalScoreTextView.setText(String.valueOf(totalbluescore));
    }

    public void updateTeleOpBlueScore() {
        TextView totalScoreTextView = findViewById(R.id.bluetotalscoreteleop);
        totalScoreTextView.setText(String.valueOf(totalbluescoreteleop));
    }

    public void updateTeleOpRedScore() {
        TextView totalScoreTextView = findViewById(R.id.redtotalscoreteleop);
        totalScoreTextView.setText(String.valueOf(totalredscoreteleop));
    }
}