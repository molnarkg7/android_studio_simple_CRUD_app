package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    TextView user_header;
    Button logout;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user_header = findViewById(R.id.user_header);
        logout = findViewById(R.id.logout);
        lista = findViewById(R.id.lista);

        //vracanje na login aktivnost

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (UserActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //citanje samo naslova

        DatabaseHelper db = new DatabaseHelper(UserActivity.this);
        List<String> knjige = db.citajNaslove();

        ArrayAdapter adapter = new ArrayAdapter(UserActivity.this, android.R.layout.simple_list_item_1, knjige);
        lista.setAdapter(adapter);

    }
}