package com.example.zoo_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class disease_history extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton buttonBackDies;

    String[] allissues = {"", "", ""};

    TextView textView14;
    TextView textView20;

    int Textview1;

    // Переменная для Firebase
    FirebaseDatabase firebaseDatabase;

    // Firebase reference
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.disease_history);
        buttonBackDies = (AppCompatButton) findViewById(R.id.buttonBackDies);
        buttonBackDies.setOnClickListener(this);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView20 = (TextView) findViewById(R.id.textView20);
        getdata();
        textView14.setText(allissues[1]);
        textView20.setText(allissues[2]);

        Intent i80 = new Intent(disease_history.this, disease_historyMenu.class);
        Intent i81 = new Intent(disease_history.this, disease_historyMenu.class);
        i80.putExtra("key222", allissues[1]);
        i81.putExtra("key223", allissues[2]);

        Textview1 = textView14.getId();

        Intent i70 = new Intent(disease_history.this, disease_historyMenu.class);
        Intent i71 = new Intent(disease_history.this, disease_historyMenu.class);
        i80.putExtra("key122", allissues[1]);
        i81.putExtra("key123", allissues[2]);

    }

    @Override
    public void onClick(View v)
    {
        Button button = findViewById(v.getId());
        if(button.getId() == R.id.buttonBackDies)
        {
            Intent intent1 = new Intent(this, welcome_screen.class);
            startActivity(intent1);
        }
    }

    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot diseasefinder) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                allissues = diseasefinder.getValue(String[].class);

                // after getting the value we are setting
                // our value to our text view in below line.

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(disease_history.this, "Всё опять пошло не по плану.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

