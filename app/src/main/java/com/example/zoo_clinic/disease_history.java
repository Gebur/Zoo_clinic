package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class disease_history extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton buttonBackDies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_history);
        buttonBackDies = (AppCompatButton) findViewById(R.id.buttonBackDies);
        buttonBackDies.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.buttonBackDies)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
            startActivity(intent1);
        }
    }

}
