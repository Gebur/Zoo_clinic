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
    public int PastDoctors;
    public int PastName;

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
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            PastDoctors = extras.getInt("key");
            PastName = extras.getInt("key2");
        }
        if (PastDoctors == R.id.dantistsButton)
        {
            if(PastName == R.id.doctorName1)
            {
                infoName.setText(R.string.dantsit1);
                textInfo.setText(R.string.text_dantsit1);
            }
            else if(PastName == R.id.doctorName2)
            {
                infoName.setText(R.string.dantsit2);
                textInfo.setText(R.string.text_dantsit2);
            }
            else
            {
                infoName.setText(R.string.dantsit3);
                textInfo.setText(R.string.text_dantsit3);
            }
        }
        else if (PastDoctors == R.id.buttonTer)
        {
            if(PastName == R.id.doctorName1)
            {
                infoName.setText(R.string.ter1);
                textInfo.setText(R.string.text_ter1);
            }
            else if(PastName == R.id.doctorName2)
            {
                infoName.setText(R.string.ter2);
                textInfo.setText(R.string.text_ter2);
            }
            else
            {
                infoName.setText(R.string.ter3);
                textInfo.setText(R.string.text_ter3);
            }
        }
        else if (PastDoctors == R.id.buttonPar)
        {
            if(PastName == R.id.doctorName1)
            {
                infoName.setText(R.string.par1);
                textInfo.setText(R.string.text_par1);
            }
            else
            {
                infoName.setText(R.string.par2);
                textInfo.setText(R.string.text_par2);
            }
        }
        else if (PastDoctors == R.id.buttonCard)
        {
            if(PastName == R.id.doctorName1)
            {
                infoName.setText(R.string.heart1);
                textInfo.setText(R.string.text_heart1);
            }
            else
            {
                infoName.setText(R.string.heart2);
                textInfo.setText(R.string.text_heart2);
            }
        }
        else if (PastDoctors == R.id.buttonCanc)
        {
            if(PastName == R.id.doctorName1)
            {
                infoName.setText(R.string.cancer1);
                textInfo.setText(R.string.text_cancer1);
            }
            else
            {
                infoName.setText(R.string.cancer2);
                textInfo.setText(R.string.text_cancer2);
            }
        }

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
        if(button.getId() == R.id.enroll)
        {

        }
    }

}