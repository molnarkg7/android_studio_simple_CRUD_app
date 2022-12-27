package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent i = new Intent(MainActivity.this, AdminActivity.class);
               Intent j = new Intent(MainActivity.this, UserActivity.class);

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    startActivity(i);
                }

                if (username.getText().toString().equals("user") && password.getText().toString().equals("123")) {
                    startActivity(j);
                }

            }
        });

    }
}