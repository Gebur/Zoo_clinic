package com.example.zoo_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import android.text.TextUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class enrolling_menu extends AppCompatActivity implements View.OnClickListener{

    TextView price;
    AppCompatButton enrollBtn;
    AppCompatButton buttonBackEnMenu;
    EditText editTextTextPersonName4;
    TextView textView3;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db2;
    public Boolean blue;
    public int buttonInfoE2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolling_menu);
        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        price = (TextView) findViewById(R.id.price);
        enrollBtn = (AppCompatButton) findViewById(R.id.enrollBtn);
        enrollBtn.setOnClickListener(this);
        buttonBackEnMenu = (AppCompatButton) findViewById(R.id.buttonBackEnMenu);
        buttonBackEnMenu.setOnClickListener(this);
        editTextTextPersonName4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        textView3 = (TextView) findViewById(R.id.textView3);
        blue = false;
    }

    public void onCreate() {
        Bundle extras = getIntent().getExtras();
        String costil1;
        int costil2;
        costil1 = extras.getString("key5");
        costil2 = Integer.parseInt(costil1);
        if(extras != null)
        {
            if(costil2 == 12345)
            {
            price.setText("Стоимость приёма: " + costil1 + " руб.");
            }
            else
            {
                price.setText("Стоимость приёма: 3500 руб.");
            }
        }
        else
        {
            price.setText("Стоимость приёма: 3500 руб.");
        }
        if (extras != null)
        {
            buttonInfoE2 = extras.getInt("key");
            Intent i11 = new Intent(enrolling_menu.this, enrolling.class);
            i11.putExtra("key11", buttonInfoE2);
        }
    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.buttonBackEnMenu)
        {
            Intent intent1 = new Intent(this, enrolling.class);
            startActivity(intent1);
        }
        else if(button.getId() == R.id.enrollBtn)
        {
            sendInfoAndDate();
            blue = true;
            Intent i8 = new Intent(enrolling_menu.this, enrolling.class);
            i8.putExtra("key8", blue);
        }
    }

    private void sendInfoAndDate()
    {
        String info, date;
        info = editTextTextPersonName4.getText().toString();
        date = textView3.getText().toString();

        // Проверка на ввод
        if (TextUtils.isEmpty(info)) {
            Toast.makeText(getApplicationContext(),
                    "Пожалуйста введите информацию о проблемах питомца!",
                    Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            addDataToFirestoreDate(info, date);

        }

        mAuth.createUserWithEmailAndPassword(info, date)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Данные успешно внесены!",
                                    Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(enrolling_menu.this,
                                    enrolling.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "У вас не получилось внести данные",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void  addDataToFirestoreDate(String info, String date)
    {
        // Создание коллекции для Firebase
        CollectionReference dbData2 = db2.collection("InfoDate");

        // Добовление инфы в класс.
        PassLog passLog = new PassLog(info, date);

        // Должно заносить данные в Firebase
        dbData2.add(passLog).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // Для того, чтобы я понял, занеслась ли инфа в Firebase
                Toast.makeText(enrolling_menu.this, "Успешный занос данных в Firebase", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Грустный вариант
                Toast.makeText(enrolling_menu.this, "ОПЯТЬ ПРОБЛЕМЫ \n" + e, Toast.LENGTH_SHORT).show();
            }
        });

    }


}