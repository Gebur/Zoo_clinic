package com.example.zoo_clinic;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class welcome_screen extends AppCompatActivity implements View.OnClickListener{
    AppCompatButton CabButton;
    AppCompatButton IllnesButton;
    AppCompatButton RecordButton;
    AppCompatButton MyRecordsButton;
    AppCompatButton logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.welcome_screen);
        CabButton = (AppCompatButton) findViewById(R.id.CabButton);
        IllnesButton = (AppCompatButton) findViewById(R.id.IllnesButton);
        RecordButton = (AppCompatButton) findViewById(R.id.RecordButton);
        MyRecordsButton = (AppCompatButton) findViewById(R.id.MyRecordsButton);
        MyRecordsButton.setOnClickListener(this);
        RecordButton.setOnClickListener(this);
        IllnesButton.setOnClickListener(this);
        CabButton.setOnClickListener(this);
        logoutButton = (AppCompatButton) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.CabButton)
        {
            Intent intent1 = new Intent(this, personal_cabinet.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.IllnesButton)
        {
            Intent intent2 = new Intent(this, disease_history.class);
            startActivity(intent2);
        }
        else if(button.getId() == R.id.RecordButton)
        {
            Intent intent3 = new Intent(this, disease_history.class); //Изменить
        }
        else if(button.getId() == R.id.MyRecordsButton)
        {
            Intent intent4 = new Intent(this, disease_history.class); //Изменить
        }
        else if(button.getId() == R.id.logoutButton)
        {
            Intent intent5 = new Intent(this, MainActivity.class);
            startActivity(intent5);
        }
    }
}
