package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class doctors_info extends AppCompatActivity implements View.OnClickListener {
    TextView textInfo;
    TextView infoName;
    AppCompatButton enroll;
    AppCompatButton infoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.doctors_info);
        enroll = (AppCompatButton) findViewById(R.id.enroll);
        enroll.setOnClickListener(this);
        infoBack = (AppCompatButton) findViewById(R.id.infoBack);
        infoBack.setOnClickListener(this);

        textInfo = (TextView) findViewById(R.id.textInfo);
        infoName = (TextView) findViewById(R.id.infoName);
    }

    public void OnCreate()
    {

    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.infoBack)
        {
            Intent intent1 = new Intent(this, dantists.class);
            startActivity(intent1);
        }
    }

}