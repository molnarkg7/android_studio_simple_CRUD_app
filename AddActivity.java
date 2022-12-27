package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddActivity extends AppCompatActivity {

    EditText autor, naslov, godina;
    Button okay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        autor = findViewById(R.id.autor);
        naslov = findViewById(R.id.naslov);
        godina = findViewById(R.id.godina);
        okay = findViewById(R.id.okay);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper db = new DatabaseHelper(AddActivity.this);
                String Autor = autor.getText().toString();
                String Naslov = naslov.getText().toString();
                int Godina = Integer.parseInt(godina.getText().toString());
                Knjiga knjiga = new Knjiga(1, Autor, Naslov, Godina);

                boolean dodato = db.dodajKnjigu(knjiga);
                if (dodato == true) {
                    Toast.makeText(AddActivity.this, "Knjiga je dodata", Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(AddActivity.this, "Knjiga nije dodata", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}