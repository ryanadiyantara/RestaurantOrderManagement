package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import db.DbHelper;
import model.Order;

public class OrderListDetail extends AppCompatActivity {

    private DbHelper dbHelper;
    private TextView detail_tablenumber, detail_customername, detail_ordernote, qtydetail_Americano, qtydetail_Cappucino, qtydetail_Macchiato, qtydetail_Espressso, qtydetail_Latte,
    qtydetail_Chocolate, qtydetail_Matchalatte, qtydetail_Thaitea, qtydetail_Redvelvet, qtydetail_Greentea,
    qtydetail_Sweets, qtydetail_Cupcake, qtydetail_Doughnut, qtydetail_Croissant, qtydetail_Cheesecake, qtydetail_Totalprice;
    private Button btndt_finished, btndt_delete, btndt_back;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderlist_detail);

        dbHelper = new DbHelper(this);

        detail_tablenumber = findViewById(R.id.detail_tablenumber);
        detail_customername = findViewById(R.id.detail_customername);
        detail_ordernote = findViewById(R.id.detail_ordernote);

        qtydetail_Americano = findViewById(R.id.qtydetail_Americano);
        qtydetail_Cappucino = findViewById(R.id.qtydetail_Cappucino);
        qtydetail_Macchiato = findViewById(R.id.qtydetail_Macchaito);
        qtydetail_Espressso = findViewById(R.id.qtydetail_Espresso);
        qtydetail_Latte = findViewById(R.id.qtydetail_Latte);
        qtydetail_Chocolate = findViewById(R.id.qtydetail_Chocolate);
        qtydetail_Matchalatte = findViewById(R.id.qtydetail_MatchaLatte);
        qtydetail_Thaitea = findViewById(R.id.qtydetail_ThaiTea);
        qtydetail_Redvelvet = findViewById(R.id.qtydetail_RedVelvet);
        qtydetail_Greentea = findViewById(R.id.qtydetail_GreenTea);
        qtydetail_Sweets = findViewById(R.id.qtydetail_Sweets);
        qtydetail_Cupcake = findViewById(R.id.qtydetail_Cupcake);
        qtydetail_Doughnut = findViewById(R.id.qtydetail_Doughnut);
        qtydetail_Croissant = findViewById(R.id.qtydetail_Croissant);
        qtydetail_Cheesecake = findViewById(R.id.qtydetail_Cheesecake);

        qtydetail_Totalprice = findViewById(R.id.qtydetail_TotalPrice);

        btndt_finished = findViewById(R.id.btndt_finished);
        btndt_delete = findViewById(R.id.btndt_delete);
        btndt_back = findViewById(R.id.btndt_back);

        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra("user");

        detail_tablenumber.setText(order.getTable_number());
        detail_customername.setText(order.getCustomer_name());
        detail_ordernote.setText(order.getOrder_note());

        qtydetail_Americano.setText(order.getAmericano());
        qtydetail_Cappucino.setText(order.getCappucino());
        qtydetail_Macchiato.setText(order.getMacchiato());
        qtydetail_Espressso.setText(order.getEspresso());
        qtydetail_Latte.setText(order.getLatte());
        qtydetail_Chocolate.setText(order.getChocolate());
        qtydetail_Matchalatte.setText(order.getMatcha_latte());
        qtydetail_Thaitea.setText(order.getThai_tea());
        qtydetail_Redvelvet.setText(order.getRed_velvet());
        qtydetail_Greentea.setText(order.getGreen_tea());
        qtydetail_Sweets.setText(order.getSweets());
        qtydetail_Cupcake.setText(order.getCupcake());
        qtydetail_Doughnut.setText(order.getDoughnut());
        qtydetail_Croissant.setText(order.getCroissant());
        qtydetail_Cheesecake.setText(order.getCheesecake());

        qtydetail_Totalprice.setText(order.getTotal_price());

        btndt_finished.setOnClickListener(v -> {
            dbHelper.createHistory(detail_tablenumber.getText().toString(), detail_customername.getText().toString(), detail_ordernote.getText().toString(),
                    qtydetail_Americano.getText().toString(), qtydetail_Cappucino.getText().toString(), qtydetail_Macchiato.getText().toString(), qtydetail_Espressso.getText().toString(), qtydetail_Latte.getText().toString(),
                    qtydetail_Chocolate.getText().toString(), qtydetail_Matchalatte.getText().toString(), qtydetail_Thaitea.getText().toString(), qtydetail_Redvelvet.getText().toString(), qtydetail_Greentea.getText().toString(),
                    qtydetail_Sweets.getText().toString(), qtydetail_Cupcake.getText().toString(), qtydetail_Doughnut.getText().toString(), qtydetail_Croissant.getText().toString(), qtydetail_Cheesecake.getText().toString(),
                    qtydetail_Totalprice.getText().toString());
            detail_tablenumber.setText("");
            detail_customername.setText("");
            detail_ordernote.setText("");

            qtydetail_Americano.setText("");
            qtydetail_Cappucino.setText("");
            qtydetail_Macchiato.setText("");
            qtydetail_Espressso.setText("");
            qtydetail_Latte.setText("");
            qtydetail_Chocolate.setText("");
            qtydetail_Matchalatte.setText("");
            qtydetail_Thaitea.setText("");
            qtydetail_Redvelvet.setText("");
            qtydetail_Greentea.setText("");
            qtydetail_Sweets.setText("");
            qtydetail_Cupcake.setText("");
            qtydetail_Doughnut.setText("");
            qtydetail_Croissant.setText("");
            qtydetail_Cheesecake.setText("");
            qtydetail_Totalprice.setText("");

            dbHelper.deleteOrder(order.getOrder_id());


            Toast.makeText(OrderListDetail.this, "Order Finished!", Toast.LENGTH_SHORT).show();
            Intent intentCreateHistory = new Intent(OrderListDetail.this, MainMenu.class);
            startActivity(intentCreateHistory);
        });

        btndt_delete.setOnClickListener((View v) -> {
            dbHelper.deleteOrder(order.getOrder_id());
            Toast.makeText(OrderListDetail.this, "Delete Successfully!", Toast.LENGTH_SHORT).show();
            Intent intentdelete = new Intent(OrderListDetail.this, OrderList.class);
            startActivity(intentdelete);
        });

        btndt_back.setOnClickListener(v -> {
            Intent intentcancel = new Intent(OrderListDetail.this, OrderList.class);
            startActivity(intentcancel);
        });
    }
}