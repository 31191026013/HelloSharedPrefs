package com.example.hellosharedprefs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getValueAndColor();
        getButtons();
    }

    protected void setValueAndColor(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_prefs_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TextView textViewCount = findViewById(R.id.textViewCount);
        TextView textViewColor = findViewById(R.id.textViewColor);
        int value = count;
        ColorDrawable bg = (ColorDrawable) textViewCount.getBackground();
        ColorDrawable bg2 = (ColorDrawable) textViewColor.getBackground();
        int color = bg.getColor();
        int color2 = bg2.getColor();
        editor.putInt("count", value);
        editor.putInt("color", color);
        editor.putInt("color2", color2);
        editor.apply();
    }

    protected void getValueAndColor(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_prefs_name), MODE_PRIVATE);
        int value = sharedPref.getInt("count", 0);
        count = value;
        int color = sharedPref.getInt("color", Color.parseColor("#909090"));
        int color2 = color;
        TextView textViewCount = findViewById(R.id.textViewCount);
        TextView textViewColor = findViewById(R.id.textViewColor);
        textViewCount.setText(String.valueOf(count));
        textViewCount.setBackgroundColor(color);
        textViewColor.setBackgroundColor(color2);
    }

    protected void clearValueAndColor(){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_prefs_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TextView textViewColor = findViewById(R.id.textViewColor);
        textViewColor.setText("");
        editor.clear();
        editor.apply();
    }

    protected void getButtons(){
        Button buttonBlack = findViewById(R.id.buttonBlack);
        buttonBlack.setTag(0);

        buttonBlack.setOnClickListener(this);

        Button buttonRed = findViewById(R.id.buttonRed);
        buttonRed.setTag(1);
        buttonRed.setOnClickListener(this);

        Button buttonBlue = findViewById(R.id.buttonGreen);
        buttonBlue.setTag(2);
        buttonBlue.setOnClickListener(this);

        Button buttonGreen = findViewById(R.id.buttonBlue);
        buttonGreen.setTag(3);
        buttonGreen.setOnClickListener(this);

        Button buttonCount = findViewById(R.id.buttonCount);
        buttonCount.setTag(4);
        buttonCount.setOnClickListener(this);

        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setTag(5);
        buttonReset.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        TextView textViewCount = findViewById(R.id.textViewCount);
        TextView textViewColor = findViewById(R.id.textViewColor);
        int tag = Integer.parseInt(String.valueOf(view.getTag()));
        switch (tag) {
            case 0:
                textViewCount.setBackgroundColor(getResources().getColor(R.color.black));
                textViewColor.setBackgroundColor(getResources().getColor(R.color.black));
                textViewColor.setText("BLACK");
                break;
            case 1:
                textViewCount.setBackgroundColor(getResources().getColor(R.color.red));
                textViewColor.setBackgroundColor(getResources().getColor(R.color.red));
                textViewColor.setText("RED");
                break;
            case 2:
                textViewCount.setBackgroundColor(getResources().getColor(R.color.green));
                textViewColor.setBackgroundColor(getResources().getColor(R.color.green));
                textViewColor.setText("GREEN");

                break;
            case 3:
                textViewCount.setBackgroundColor(getResources().getColor(R.color.blue));
                textViewColor.setBackgroundColor(getResources().getColor(R.color.blue));
                textViewColor.setText("BLUE");
                break;
            case 4:
                count++;
                break;
            case 5:
                clearValueAndColor();
                getValueAndColor();
                break;
        }
        setValueAndColor();
        getValueAndColor();
    }
}