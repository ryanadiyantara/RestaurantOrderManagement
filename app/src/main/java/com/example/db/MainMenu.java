package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button btnNeworder, btnOrdered, btnHistory, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnNeworder = findViewById(R.id.btn_neworder);
        btnOrdered = findViewById(R.id.btn_ordered);
        btnHistory = findViewById(R.id.btn_history);
        btnLogout = findViewById(R.id.btn_logout);

        btnNeworder.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, NewOrder.class);
            startActivity(intent);
        });

        btnOrdered.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, OrderList.class);
            startActivity(intent);
        });

        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, HistoryList.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Login.class);
            startActivity(intent);
        });

    }




}