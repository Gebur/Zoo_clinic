package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class code extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton nextCodeButton;
    AppCompatButton backCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_code);
        nextCodeButton = (AppCompatButton) findViewById(R.id.nextCodeButton);
        backCodeButton = (AppCompatButton) findViewById(R.id.backCodeButton);
        backCodeButton.setOnClickListener(this);
        nextCodeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.nextCodeButton)
        {
            Intent intent1 = new Intent(this, password_change.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.backCodeButton)
        {
            Intent intent2 = new Intent(this, forget_password.class);
            startActivity(intent2);
        }
    }
}