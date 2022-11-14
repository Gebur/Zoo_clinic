package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class dantists extends AppCompatActivity implements View.OnClickListener{

    public int HolyShitManager;
    AppCompatButton dantBack;
    AppCompatButton doctorName1;
    AppCompatButton doctorName2;
    AppCompatButton doctorName3;
    TextView textView40;
    int buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_dantists);
        dantBack = (AppCompatButton) findViewById(R.id.dantBack);
        dantBack.setOnClickListener(this);
        doctorName1 = (AppCompatButton) findViewById(R.id.doctorName1);
        doctorName1.setOnClickListener(this);
        doctorName2 = (AppCompatButton) findViewById(R.id.doctorName2);
        doctorName2.setOnClickListener(this);
        doctorName3 = (AppCompatButton) findViewById(R.id.doctorName3);
        doctorName3.setOnClickListener(this);
        textView40 = (TextView) findViewById(R.id.textView40);
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
        else
        {
            Intent intent2 = new Intent(this, doctors_info.class);
            startActivity(intent2);
            buttonInfo = button.getId();
            Intent i5 = new Intent(dantists.this, doctors_info.class);
            i5.putExtra("key2", buttonInfo);
            startActivity(i5);
        }
    }

    public void OnCreate()
    {
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            HolyShitManager = extras.getInt("key");
        }
        if (HolyShitManager == R.id.dantistsButton)
        {
            textView40.setText(R.string.dantists);
            doctorName1.setText(R.string.dantsit1);
            doctorName2.setText(R.string.dantsit2);
            doctorName3.setText(R.string.dantsit3);
        }
        if (HolyShitManager == R.id.buttonCard)
        {
            textView40.setText(R.string.heart);
            doctorName1.setText(R.string.heart1);
            doctorName2.setText(R.string.heart2);
            doctorName3.setVisibility(View.GONE);
            doctorName3.setClickable(false);
        }
        if (HolyShitManager == R.id.buttonTer)
        {
            textView40.setText(R.string.ter);
            doctorName1.setText(R.string.ter1);
            doctorName2.setText(R.string.ter2);
            doctorName3.setText(R.string.ter3);
        }
        if (HolyShitManager == R.id.buttonTer)
        {
            textView40.setText(R.string.ter);
            doctorName1.setText(R.string.ter1);
            doctorName2.setText(R.string.ter2);
            doctorName3.setText(R.string.ter3);
        }
        if (HolyShitManager == R.id.buttonPar)
        {
            textView40.setText(R.string.par);
            doctorName1.setText(R.string.par1);
            doctorName2.setText(R.string.par2);
            doctorName3.setVisibility(View.GONE);
            doctorName3.setClickable(false);
        }
        if (HolyShitManager == R.id.buttonCanc)
        {
            textView40.setText(R.string.cancer);
            doctorName1.setText(R.string.cancer1);
            doctorName2.setText(R.string.cancer2);
            doctorName3.setVisibility(View.GONE);
            doctorName3.setClickable(false);
        }
    }

}