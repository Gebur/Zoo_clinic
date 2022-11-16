package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class enrolling extends AppCompatActivity implements View.OnClickListener{

    TextView textView10;
    AppCompatButton button3;
    public int buttonInfoE;

    public boolean MAKEMEBLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enrolling_2);
        textView10 = (TextView) findViewById(R.id.textView10);
        button3 = (AppCompatButton) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    public void OnCreate()
    {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            MAKEMEBLUE = extras.getBoolean("key8");
            if(MAKEMEBLUE = true)
            {
                Button buttonBLUE;
                int IdBlue;
                IdBlue = extras.getInt("key11");
                buttonBLUE = (AppCompatButton) findViewById(IdBlue);
                buttonBLUE.setBackgroundColor(Color.BLUE);
            }
        }

    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.button3)
        {
            Intent intent1 = new Intent(this, doctors_info.class);
            startActivity(intent1);
        }
        else
        {
            Intent intent2 = new Intent(this, enrolling_menu.class);
            startActivity(intent2);
            buttonInfoE = button.getId();
            Intent i6 = new Intent(enrolling.this, enrolling_menu.class);
            i6.putExtra("key9", buttonInfoE);
        }
    }

}