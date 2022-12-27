package com.example.kolokvijum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        DatabaseHelper db = new DatabaseHelper(ListActivity.this);
        List<Knjiga> knjige = db.citajKnjige();
        List<String> naslovi = new ArrayList<String>();

        ArrayAdapter adapter = new ArrayAdapter(ListActivity.this, android.R.layout.simple_list_item_1, knjige);
        listView.setAdapter(adapter);

    }
}