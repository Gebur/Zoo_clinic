package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class forget_password extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton codeButton;
    AppCompatButton forgetBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        forgetBackButton = (AppCompatButton) findViewById(R.id.forgetBackButton);
        codeButton = (AppCompatButton) findViewById(R.id.codeButton);
        forgetBackButton.setOnClickListener(this);
        codeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if (button.getId() == R.id.forgetBackButton)
        {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.codeButton)
        {
            Intent intent2 = new Intent(this, code.class);
            startActivity(intent2);
        }
    }
}