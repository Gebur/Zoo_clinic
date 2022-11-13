package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class personal_cabinet extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton buttonBackCab;
    AppCompatButton discountButton;
    AppCompatButton changePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.personal_cab);
        buttonBackCab = (AppCompatButton) findViewById(R.id.buttonBackCab);
        discountButton = (AppCompatButton) findViewById(R.id.discountButton);
        changePasswordButton = (AppCompatButton) findViewById(R.id.changePasswordButton);
        buttonBackCab.setOnClickListener(this);
        discountButton.setOnClickListener(this);
        changePasswordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Button button = findViewById(view.getId());
        if(button.getId() == R.id.buttonBackCab)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.changePasswordButton)
        {
            Intent intent2 = new Intent(this, forget_password.class);
            startActivity(intent2);
        }
    }
}