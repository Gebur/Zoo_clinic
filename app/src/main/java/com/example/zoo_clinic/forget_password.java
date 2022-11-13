package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.function.ToLongFunction;

public class forget_password extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton codeButton;
    AppCompatButton forgetBackButton;
    EditText editTextTextEmailAddress;
    TextView textView32;
    public static String T;
    private static double Code1;
    public static long Code;
    private  static String Codestr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.forget_password);
        forgetBackButton = (AppCompatButton) findViewById(R.id.forgetBackButton);
        codeButton = (AppCompatButton) findViewById(R.id.codeButton);
        forgetBackButton.setOnClickListener(this);
        codeButton.setOnClickListener(this);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextEmailAddress.setOnClickListener(this);
        textView32 = (TextView) findViewById(R.id.textView32);
        textView32.setOnClickListener(this);
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

    public void Test(View v)
    {
        long s;
        T = editTextTextEmailAddress.getText().toString();
        if (T != "")
        {
            Code1 = Math.random();
            Code = Math.round(Code1);
        }
        Codestr = String.valueOf(Code);
        textView32.setText(Codestr);
    }
}