package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView ForgotPassword;
    AppCompatButton enterButton;
    AppCompatButton RegistrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        enterButton = (AppCompatButton) findViewById(R.id.EnterButton);
        RegistrationButton = (AppCompatButton) findViewById(R.id.RegistrationButton);
        ForgotPassword = (TextView) findViewById(R.id.ForgotPassword);
        enterButton.setOnClickListener(this);
        RegistrationButton.setOnClickListener(this);
        ForgotPassword.setOnClickListener(this);
        Button button = findViewById(R.id.EnterButton);

        View.OnClickListener enter = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, welcome_screen.class);
                startActivity(intent);
            }
        };
        button.setOnClickListener(enter);
    }

    @Override
    public void onClick(View view) {

    }

    //@Override
    //public void onClick(View v)
    //{
        //Button button = findViewById(v.getId());
        //switch(v.getId()){
        //    case R.id.EnterButton:
        //        Intent intent = new Intent(this, welcome_screen.class);
        //       startActivity(intent);
        //       break;
        //}

        // if (button.getId() == R.id.EnterButton)
        //{
        //    Intent intent = new Intent(this, welcome_screen.class);
        //    startActivity(intent);
        // }

        // else if (button.getId() == R.id.RegistrationButton)
        // {
        //     Intent intent2 = new Intent(this, Registration_screen.class);
        //    startActivity(intent2);
        // }

        // TextView textView = findViewById(v.getId());
        // if (textView.getId() == R.id.ForgotPassword)
        // {
        //     Intent intent3 = new Intent( this, forget_password.class);
        //     startActivity(intent3);
        // }
    }

// }
