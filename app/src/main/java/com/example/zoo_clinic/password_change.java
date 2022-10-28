package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class password_change extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton passwordReady;
    AppCompatButton passwordChangeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_password_change);
        passwordReady = (AppCompatButton) findViewById(R.id.passwordReady);
        passwordChangeBack = (AppCompatButton) findViewById(R.id.passwordChangeBack);
        passwordReady.setOnClickListener(this);
        passwordChangeBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.passwordReady)
        {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.passwordChangeBack)
        {
            Intent intent2 = new Intent(this, code.class);
            startActivity(intent2);
        }
    }

}