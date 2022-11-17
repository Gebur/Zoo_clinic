package com.example.zoo_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration_screen extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton nextButton;
    AppCompatButton buttonBack;
    EditText EmailAddress, editTextTextPersonName;
    EditText TextPassword, petTypeText;
    private FirebaseAuth mAuth;
    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.registration_screen);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        nextButton = (AppCompatButton) findViewById(R.id.buttonNext);
        buttonBack = (AppCompatButton) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        TextPassword = (EditText) findViewById(R.id.TextPassword);
        EmailAddress = (EditText) findViewById(R.id.EmailAddress);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        petTypeText = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if (button.getId() == R.id.buttonNext)
        {
            registerNewUser();
        }
        else if (button.getId() == R.id.buttonBack) {
            Intent intent1 = new Intent(this, personal_cabinet.class);
            startActivity(intent1);
        }
    }

    private void registerNewUser()
    {
        String email, password, pet, pet_type;
        email = EmailAddress.getText().toString();
        password = TextPassword.getText().toString();
        pet = editTextTextPersonName.getText().toString();
        pet_type = petTypeText.getText().toString();

        // Проверка на ввод
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Пожалуйста введите email!!",
                            Toast.LENGTH_LONG).show();
            return;
        }
        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Пожалуйста введите пароль!",
                            Toast.LENGTH_LONG).show();
            return;
        }
        else if (TextUtils.isEmpty(pet)) {
            Toast.makeText(getApplicationContext(),
                    "Пожалуйста введите имя питомца!",
                    Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(pet_type)) {
            Toast.makeText(getApplicationContext(),
                    "Пожалуйста введите тип питомца!",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            addDataToFirestore(email, password, pet, pet_type);
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                            "Успешная решистрация!",
                                            Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(Registration_screen.this,
                                    MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(
                                            getApplicationContext(),
                                            "У вас не получилось зарегистрироваться",
                                            Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    private void  addDataToFirestore(String email, String password, String pet, String pet_type)
    {
        // Создание коллекции для Firebase
        CollectionReference dbData = db.collection("PassLog");

        // Добовление инфы в класс.
        PassLog passLog = new PassLog(email, password, pet, pet_type);

        // Должно заносить данные в Firebase или я съем свою ногу.
        dbData.add(passLog).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // Для того, чтобы я понял, занеслась ли инфа в Firebase
                Toast.makeText(Registration_screen.this, "Успешный занос данных в Firebase", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Грустный вариант
                Toast.makeText(Registration_screen.this, "ОПЯТЬ ПРОБЛЕМЫ \n" + e, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
