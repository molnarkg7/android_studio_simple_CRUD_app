package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminActivity extends AppCompatActivity {

    TextView textView;
    Button dodaj, prikazi, azuriraj, obrisi;
    EditText editID;
    FloatingActionButton delete_forever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        textView = findViewById(R.id.admin_header);
        dodaj = findViewById(R.id.dodaj);
        prikazi = findViewById(R.id.prikazi);
        azuriraj = findViewById(R.id.azuriraj);
        obrisi = findViewById(R.id.obrisi);
        editID = findViewById(R.id.editID);
        delete_forever = findViewById(R.id.delete_forever);

        delete_forever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper db = new DatabaseHelper(AdminActivity.this);
                Integer x = db.obrisiSve();

                Toast.makeText(AdminActivity.this, "Sve je obrisano", Toast.LENGTH_SHORT).show();
            }
        });

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

        azuriraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, UpdateActivity.class);
                startActivity(i);
            }
        });

        prikazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

        obrisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper db = new DatabaseHelper(AdminActivity.this);
                String id = editID.getText().toString();

                db.obrisiKnjigu(id);

                Toast.makeText(AdminActivity.this, "Knjiga je obrisana", Toast.LENGTH_SHORT).show();

            }
        });

    }
}