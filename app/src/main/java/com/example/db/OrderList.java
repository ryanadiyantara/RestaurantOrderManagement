package com.example.db;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.OrderListAdapter;
import db.DbHelper;
import model.Order;

public class OrderList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderListAdapter adapter;
    private ArrayList<Order> orderArrayList;
    private DbHelper dbHelper;
    private Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderlist);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new OrderListAdapter(this);

        dbHelper = new DbHelper(this);
        orderArrayList = dbHelper.readOrder();
        adapter.setListOrder(orderArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(v -> {
            Intent intentcancel = new Intent(OrderList.this, MainMenu.class);
            startActivity(intentcancel);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        orderArrayList = dbHelper.readOrder();
        adapter.setListOrder(orderArrayList);
        adapter.notifyDataSetChanged();
    }
}