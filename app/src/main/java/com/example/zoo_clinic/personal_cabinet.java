package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.ToIntFunction;

public class personal_cabinet extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton buttonBackCab;
    AppCompatButton discountButton;
    EditText editTextTextPersonName2;

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
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        buttonBackCab.setOnClickListener(this);
        discountButton.setOnClickListener(this);
    }

    public void onCreate()
    {
        String promo1;
        int promo2;
        promo1 = editTextTextPersonName2.getText().toString();
        promo2 = Integer.parseInt(promo1);
        if(promo2 == 12345) {
            Intent t = new Intent(personal_cabinet.this, enrolling.class);
            t.putExtra("key5", "3000");
            Toast.makeText(getApplicationContext(),
                    "Правильный промокод! Скидка в 500 рублей",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Неправильный промокод!",
                    Toast.LENGTH_LONG).show();
        }
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
    }
}