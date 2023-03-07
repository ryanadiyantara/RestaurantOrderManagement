package com.example.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import adapter.HistoryListAdapter;
import db.DbHelper;
import model.History;

public class HistoryList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryListAdapter adapter;
    private ArrayList<History> historyArrayList;
    private DbHelper dbHelper;
    private Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historylist);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviews);
        adapter = new HistoryListAdapter(this);

        dbHelper = new DbHelper(this);
        historyArrayList = dbHelper.readHistory();
        adapter.setListHistory(historyArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(v -> {
            Intent intentcancel = new Intent(HistoryList.this, MainMenu.class);
            startActivity(intentcancel);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        historyArrayList = dbHelper.readHistory();
        adapter.setListHistory(historyArrayList);
        adapter.notifyDataSetChanged();
    }
}