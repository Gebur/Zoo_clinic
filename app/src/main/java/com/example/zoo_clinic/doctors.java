package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class doctors extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton doctorsBack;
    AppCompatButton dantistsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_doctors);
        doctorsBack = (AppCompatButton) findViewById(R.id.doctorsBack);
        doctorsBack.setOnClickListener(this);
        dantistsButton = (AppCompatButton) findViewById(R.id.dantistsButton);
        dantistsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.doctorsBack)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
        }
        else if(button.getId() == R.id.dantistsButton)
        {
            Intent intent2 = new Intent(this, dantists.class);
        }
    }

}
