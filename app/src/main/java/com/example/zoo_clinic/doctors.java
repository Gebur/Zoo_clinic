package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.view.View.OnClickListener;

public class doctors extends AppCompatActivity implements View.OnClickListener{

    public int buttonInfo;
    AppCompatButton doctorsBack;
    AppCompatButton dantistsButton;
    AppCompatButton buttonCard;
    AppCompatButton buttonTer;
    AppCompatButton buttonPar;
    AppCompatButton buttonCanc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.available_doctors);
        doctorsBack = (AppCompatButton) findViewById(R.id.doctorsBack);
        doctorsBack.setOnClickListener(this);
        //Дантисты
        dantistsButton = (AppCompatButton) findViewById(R.id.dantistsButton);
        dantistsButton.setOnClickListener(this);
        //Кардиологи
        buttonCard = (AppCompatButton) findViewById(R.id.buttonCard);
        buttonCard.setOnClickListener(this);
        //Терапевты
        buttonTer = (AppCompatButton) findViewById(R.id.buttonTer);
        buttonTer.setOnClickListener(this);
        //Паразитологи
        buttonPar = (AppCompatButton) findViewById(R.id.buttonPar);
        buttonPar.setOnClickListener(this);
        buttonCanc = (AppCompatButton) findViewById(R.id.buttonCanc);
        buttonCanc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.doctorsBack)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
            startActivity(intent1);
        }
        else {
            buttonInfo = button.getId();
            Intent i = new Intent(doctors.this, dantists.class);
            i.putExtra("key", buttonInfo);
            startActivity(i);
        }
    }

}
