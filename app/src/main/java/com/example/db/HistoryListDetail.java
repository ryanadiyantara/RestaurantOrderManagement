package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import db.DbHelper;
import model.History;

public class HistoryListDetail extends AppCompatActivity {

    private DbHelper dbHelper;
    private TextView detail_tablenumber, detail_customername, detail_ordernote, qtydetail_Americano, qtydetail_Cappucino, qtydetail_Macchiato, qtydetail_Espressso, qtydetail_Latte,
            qtydetail_Chocolate, qtydetail_Matchalatte, qtydetail_Thaitea, qtydetail_Redvelvet, qtydetail_Greentea,
            qtydetail_Sweets, qtydetail_Cupcake, qtydetail_Doughnut, qtydetail_Croissant, qtydetail_Cheesecake, qtydetail_Totalprice;
    private Button btndt_finished, btndt_delete, btndt_back;
    private History history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historylist_detail);

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

        btndt_back = findViewById(R.id.btndt_back);

        Intent intent = getIntent();
        history = (History) intent.getSerializableExtra("user");

        detail_tablenumber.setText(history.getTable_number());
        detail_customername.setText(history.getCustomer_name());
        detail_ordernote.setText(history.getOrder_note());

        qtydetail_Americano.setText(history.getAmericano());
        qtydetail_Cappucino.setText(history.getCappucino());
        qtydetail_Macchiato.setText(history.getMacchiato());
        qtydetail_Espressso.setText(history.getEspresso());
        qtydetail_Latte.setText(history.getLatte());
        qtydetail_Chocolate.setText(history.getChocolate());
        qtydetail_Matchalatte.setText(history.getMatcha_latte());
        qtydetail_Thaitea.setText(history.getThai_tea());
        qtydetail_Redvelvet.setText(history.getRed_velvet());
        qtydetail_Greentea.setText(history.getGreen_tea());
        qtydetail_Sweets.setText(history.getSweets());
        qtydetail_Cupcake.setText(history.getCupcake());
        qtydetail_Doughnut.setText(history.getDoughnut());
        qtydetail_Croissant.setText(history.getCroissant());
        qtydetail_Cheesecake.setText(history.getCheesecake());

        qtydetail_Totalprice.setText(history.getTotal_price());

        btndt_back.setOnClickListener(v -> {
            Intent intentcancel = new Intent(HistoryListDetail.this, HistoryList.class);
            startActivity(intentcancel);
        });
    }
}