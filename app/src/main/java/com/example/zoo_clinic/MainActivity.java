package com.example.zoo_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatButton enterButton;
    AppCompatButton RegistrationButton;

    //Для поиска логин
    private String loginFind;
    String parol;

    // Переменная для Firebase
    FirebaseDatabase firebaseDatabase;

    // Firebase reference
    DatabaseReference databaseReference;

    EditText EmailAddress;
    EditText TextPassword;

    String For_password;
    String For_login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.login_screen);
        enterButton = (AppCompatButton) findViewById(R.id.EnterButton);
        RegistrationButton = (AppCompatButton) findViewById(R.id.RegistrationButton);
        enterButton.setOnClickListener(this);
        RegistrationButton.setOnClickListener(this);
        Button button = findViewById(R.id.EnterButton);

        EmailAddress = findViewById(R.id.EmailAddress);
        TextPassword = findViewById(R.id.TextPassword);

        // Вот это для вытасквивания данных
        firebaseDatabase = FirebaseDatabase.getInstance();

        // Какой референс искать
        databaseReference = firebaseDatabase.getReference("Data");

        // calling method
        // for getting data.
        getdata();

        loginFind = EmailAddress.getText().toString();

    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());

        if (button.getId() == R.id.EnterButton)
        {
            loginUserAccount();
        }
         else if (button.getId() == R.id.RegistrationButton)
         {
             Intent intent2 = new Intent(this, Registration_screen.class);
             startActivity(intent2);
         }
         }

    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot passwordFind) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                parol = passwordFind.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(MainActivity.this, "Всё опять пошло не по плану.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginUserAccount() {
        String email, password;
        email = EmailAddress.getText().toString();
        password = TextPassword.getText().toString();

        // Проверка на ввод пароля и логина
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Пожалуйста, введите email!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Пожалуйста, введите пароль!",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (parol == password) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(
                                        @NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),
                                                        "Успешный вход в личный кабинет!",
                                                        Toast.LENGTH_LONG)
                                                .show();

                                        Intent intent = new Intent(MainActivity.this, welcome_screen.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Войти в личный кабинет не удалось",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
        }
    }

    }
