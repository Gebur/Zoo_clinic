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
import kotlin.Metadata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"},
        d2 = {"Lcom/gridness/assignment/Categories;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)

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
    String login;

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
        login = loginFind;

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

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot passwordFind) {
                parol = passwordFind.getValue(FindLogin.class).toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(MainActivity.this, "Возникла проблема с подключением.", Toast.LENGTH_SHORT).show();
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
