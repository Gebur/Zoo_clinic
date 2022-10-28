package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Registration_screen extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton nextButton;
    AppCompatButton buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        nextButton = (AppCompatButton) findViewById(R.id.buttonNext);
        buttonBack = (AppCompatButton) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if (button.getId() == R.id.buttonNext)
        {Intent intent = new Intent(this, MainActivity.class);}
        else if (button.getId() == R.id.buttonBack) {
            Intent intent = new Intent(this, personal_cabinet.class);
        }
    }
}
