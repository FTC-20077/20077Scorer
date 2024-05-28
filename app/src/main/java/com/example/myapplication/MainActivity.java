package com.example.myapplication;

import android.annotation.SuppressLint;import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private boolean switchScreenPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void switchScreen(View v)
    {
        View view = findViewById(R.id.scorematch);
        Button button = (Button) v;
        setContentView(R.layout.score_main);
    }




    /*public void handleText(View v)
    {
        EditText t = findViewById(R.id.editTextText);
        String input = t.getText().toString();

        Log.d("info", input);
    }*/


}