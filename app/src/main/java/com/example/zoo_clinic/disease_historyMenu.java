package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class disease_historyMenu extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton menuBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desiase_storymenu);
        menuBack = (AppCompatButton) findViewById(R.id.menuBack);
        menuBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.menuBack)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
        }
    }

}
