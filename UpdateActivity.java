package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText autor, naslov, godina, update_id;
    Button azuriraj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        autor = findViewById(R.id.autor);
        naslov = findViewById(R.id.naslov);
        godina = findViewById(R.id.godina);
        update_id = findViewById(R.id.update_id);
        azuriraj = findViewById(R.id.azuriraj);


        azuriraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                String Autor = autor.getText().toString();
                String Naslov = naslov.getText().toString();
                int Godina = Integer.parseInt(godina.getText().toString());
                int ID = Integer.parseInt(update_id.getText().toString());
                Knjiga knjiga = new Knjiga(ID, Autor, Naslov, Godina);

                db.azurirajKnjigu(knjiga);

                Toast.makeText(UpdateActivity.this, "Knjiga je azurirana", Toast.LENGTH_SHORT).show();

            }
        });
    }
}