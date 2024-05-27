package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void handleText(View v)
    {
        EditText t = findViewById(R.id.editTextText);
        String input = t.getText().toString();

        Log.d("info", input);
    }

    /*
    public void toggle(View v)
    {
        findViewById(R.id.button4).setEnabled(false);
        ((Button)findViewById(R.id.button4)).setText("New Disabled button");
    }
    */
}