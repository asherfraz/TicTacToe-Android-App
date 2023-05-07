package com.ashdev.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView historyListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyListview = findViewById(R.id.historylistview);

        // receiving Intent
        Intent fromihistory = getIntent();
        ArrayList<String> array = fromihistory.getExtras().getStringArrayList("key");

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);

        historyListview.setAdapter(ListViewAdapter);
    }
}