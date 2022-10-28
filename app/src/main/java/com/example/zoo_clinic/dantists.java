package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class dantists extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton dantBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dantists);
        dantBack = (AppCompatButton) findViewById(R.id.dantBack);
        dantBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.nextCodeButton)
        {
            Intent intent1 = new Intent(this, doctors.class);
            startActivity(intent1);
        }
    }

}