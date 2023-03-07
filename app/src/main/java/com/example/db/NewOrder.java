package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import db.DbHelper;

public class NewOrder extends AppCompatActivity {

    private EditText txtTablenumber, txtCustomername, txtOrdernote;
    private TextView txtAmericano, txtCappucino, txtMacchiato, txtEspresso, txtLatte,
            txtChocolate, txtMatchaLatte, txtThaiTea, txtRedVelvet, txtGreenTea,
            txtSweets, txtCupcake, txtDoughnut, txtCroissant, txtCheesecake, txtTotalprice;
    private Button btnCreateneworder, btnCancel;

    DbHelper dbHelper;

    int intAmericano, intCappucino, intMacchiato,
        intEspresso, intLatte, intChocolate,
        intMatchaLatte, intThaiTea, intRedVelvet,
        intGreenTea, intSweets, intCupcake,
        intDoughnut, intCroissant, intCheesecake, intTotalPrice  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        txtTablenumber = findViewById(R.id.txt_tablenumber);
        txtCustomername = findViewById(R.id.txt_customername);
        txtOrdernote = findViewById(R.id.txt_ordernote);

        txtAmericano = findViewById(R.id.qty_Americano);
        txtCappucino = findViewById(R.id.qty_Cappucino);
        txtMacchiato = findViewById(R.id.qty_Macchiato);
        txtEspresso = findViewById(R.id.qty_Espresso);
        txtLatte = findViewById(R.id.qty_Latte);
        txtChocolate = findViewById(R.id.qty_Chocolate);
        txtMatchaLatte = findViewById(R.id.qty_MatchaLatte);
        txtThaiTea = findViewById(R.id.qty_ThaiTea);
        txtRedVelvet = findViewById(R.id.qty_RedVelvet);
        txtGreenTea = findViewById(R.id.qty_GreenTea);
        txtSweets = findViewById(R.id.qty_Sweets);
        txtCupcake  = findViewById(R.id.qty_Cupcake);
        txtDoughnut = findViewById(R.id.qty_Doughnut);
        txtCroissant = findViewById(R.id.qty_Croissant);
        txtCheesecake = findViewById(R.id.qty_Cheesecake);

        txtTotalprice = findViewById(R.id.qty_TotalPrice);

        btnCreateneworder = findViewById(R.id.btn_createneworder);
        btnCancel = findViewById(R.id.btn_cancel);
        dbHelper = new DbHelper(this);

        btnCreateneworder.setOnClickListener(v -> {
            if (txtTablenumber.getText().toString().isEmpty()) {
                Toast.makeText(NewOrder.this, "Error: Table Number Must be Filled!", Toast.LENGTH_SHORT).show();
            } else if (txtCustomername.getText().toString().isEmpty()) {
                Toast.makeText(NewOrder.this, "Error: Customer Name must be Filled!", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.createOrder(txtTablenumber.getText().toString(), txtCustomername.getText().toString(), txtOrdernote.getText().toString(),
                        txtAmericano.getText().toString(), txtCappucino.getText().toString(), txtMacchiato.getText().toString(), txtEspresso.getText().toString(), txtLatte.getText().toString(),
                        txtChocolate.getText().toString(), txtMatchaLatte.getText().toString(), txtThaiTea.getText().toString(), txtRedVelvet.getText().toString(), txtGreenTea.getText().toString(),
                        txtSweets.getText().toString(), txtCupcake.getText().toString(), txtDoughnut.getText().toString(), txtCroissant.getText().toString(), txtCheesecake.getText().toString(),
                        txtTotalprice.getText().toString());

                txtTablenumber.setText("");
                txtCustomername.setText("");
                txtOrdernote.setText("");
                txtAmericano.setText("");
                txtCappucino.setText("");
                txtMacchiato.setText("");
                txtEspresso.setText("");
                txtLatte.setText("");
                txtChocolate.setText("");
                txtMatchaLatte.setText("");
                txtThaiTea.setText("");
                txtRedVelvet.setText("");
                txtGreenTea.setText("");
                txtSweets.setText("");
                txtCupcake.setText("");
                txtDoughnut.setText("");
                txtCroissant.setText("");
                txtCheesecake.setText("");
                txtTotalprice.setText("");
                Toast.makeText(NewOrder.this, "Create a New Order Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewOrder.this, MainMenu.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(v -> {
            Intent intent = new Intent(NewOrder.this, MainMenu.class);
            startActivity(intent);
        });
    }

//--LOGIC CODE
    private void displayAmericano(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Americano);
        displayInteger.setText("" + number);
    }
    public void increaseAmericano(View view) {
        intAmericano = intAmericano + 1;
        displayAmericano(intAmericano);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseAmericano(View view) {
        intAmericano = intAmericano - 1;
        displayAmericano(intAmericano);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayCappucino(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Cappucino);
        displayInteger.setText("" + number);
    }
    public void increaseCappucino(View view) {
        intCappucino = intCappucino + 1;
        displayCappucino(intCappucino);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseCappucino(View view) {
        intCappucino = intCappucino - 1;
        displayCappucino(intCappucino);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayMacchiato(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Macchiato);
        displayInteger.setText("" + number);
    }
    public void increaseMacchiato(View view) {
        intMacchiato = intMacchiato + 1;
        displayMacchiato(intMacchiato);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseMacchiato(View view) {
        intMacchiato = intMacchiato - 1;
        displayMacchiato(intMacchiato);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayEspresso(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Espresso);
        displayInteger.setText("" + number);
    }
    public void increaseEspresso(View view) {
        intEspresso = intEspresso + 1;
        displayEspresso(intEspresso);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseEspresso(View view) {
        intEspresso = intEspresso - 1;
        displayEspresso(intEspresso);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayLatte(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Latte);
        displayInteger.setText("" + number);
    }
    public void increaseLatte(View view) {
        intLatte = intLatte + 1;
        displayLatte(intLatte);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseLatte(View view) {
        intLatte = intLatte - 1;
        displayLatte(intLatte);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayChocolate(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Chocolate);
        displayInteger.setText("" + number);
    }
    public void increaseChocolate(View view) {
        intChocolate = intChocolate + 1;
        displayChocolate(intChocolate);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseChocolate(View view) {
        intChocolate = intChocolate - 1;
        displayChocolate(intChocolate);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayMatchaLatte(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_MatchaLatte);
        displayInteger.setText("" + number);
    }
    public void increaseMatchaLatte(View view) {
        intMatchaLatte = intMatchaLatte + 1;
        displayMatchaLatte(intMatchaLatte);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseMatchaLatte(View view) {
        intMatchaLatte = intMatchaLatte - 1;
        displayMatchaLatte(intMatchaLatte);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayThaiTea(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_ThaiTea);
        displayInteger.setText("" + number);
    }
    public void increaseThaiTea(View view) {
        intThaiTea = intThaiTea + 1;
        displayThaiTea(intThaiTea);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseThaiTea(View view) {
        intThaiTea = intThaiTea - 1;
        displayThaiTea(intThaiTea);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayRedVelvet(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_RedVelvet);
        displayInteger.setText("" + number);
    }
    public void increaseRedVelvet(View view) {
        intRedVelvet = intRedVelvet + 1;
        displayRedVelvet(intRedVelvet);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseRedVelvet(View view) {
        intRedVelvet = intRedVelvet - 1;
        displayRedVelvet(intRedVelvet);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayGreenTea(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_GreenTea);
        displayInteger.setText("" + number);
    }
    public void increaseGreenTea(View view) {
        intGreenTea = intGreenTea + 1;
        displayGreenTea(intGreenTea);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseGreenTea(View view) {
        intGreenTea = intGreenTea - 1;
        displayGreenTea(intGreenTea);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displaySweets(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Sweets);
        displayInteger.setText("" + number);
    }
    public void increaseSweets(View view) {
        intSweets = intSweets + 1;
        displaySweets(intSweets);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseSweets(View view) {
        intSweets = intSweets - 1;
        displaySweets(intSweets);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayCupcake(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Cupcake);
        displayInteger.setText("" + number);
    }
    public void increaseCupcake(View view) {
        intCupcake = intCupcake + 1;
        displayCupcake(intCupcake);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseCupcake(View view) {
        intCupcake = intCupcake - 1;
        displayCupcake(intCupcake);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayDoughnut(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Doughnut);
        displayInteger.setText("" + number);
    }
    public void increaseDoughnut(View view) {
        intDoughnut = intDoughnut + 1;
        displayDoughnut(intDoughnut);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseDoughnut(View view) {
        intDoughnut = intDoughnut - 1;
        displayDoughnut(intDoughnut);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayCroissant(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Croissant);
        displayInteger.setText("" + number);
    }
    public void increaseCroissant(View view) {
        intCroissant = intCroissant + 1;
        displayCroissant(intCroissant);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseCroissant(View view) {
        intCroissant = intCroissant - 1;
        displayCroissant(intCroissant);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayCheesecake(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_Cheesecake);
        displayInteger.setText("" + number);
    }
    public void increaseCheesecake(View view) {
        intCheesecake = intCheesecake + 1;
        displayCheesecake(intCheesecake);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }
    public void decreaseCheesecake(View view) {
        intCheesecake = intCheesecake - 1;
        displayCheesecake(intCheesecake);
        intTotalPrice = intAmericano*45 + intCappucino*40 +intMacchiato*42 + intEspresso*40 + intLatte*45 +
                intChocolate*50 + intMatchaLatte*34 + intThaiTea*30 + intRedVelvet*32 + intGreenTea*30 +
                intSweets*30 + intCupcake*45 + intDoughnut*45 + intCroissant*40 + intCheesecake * 25;
        displayTotalPrice(intTotalPrice);
    }

    private void displayTotalPrice(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.qty_TotalPrice);
        displayInteger.setText("" + number);
    }
}