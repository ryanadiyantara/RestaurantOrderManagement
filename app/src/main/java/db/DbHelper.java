package db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.History;
import model.Order;

public class DbHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_shirohige";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ORDER = "order_table";
    private static final String TABLE_HISTORY = "history_table";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //--TABLE ORDER ------------------------------------------------------------------------------//
    private static final String ORDER_ID = "order_id";
    private static final String CUSTOMER_NAME = "customer_name";
    private static final String TABLE_NUMBER = "table_number";
    private static final String ORDER_NOTE = "order_note";
    private static final String AMERICANO = "americano";
    private static final String CAPPUCINO = "cappucino";
    private static final String MACCHIATO = "macchiato";
    private static final String ESPRESSO = "espresso";
    private static final String LATTE = "latte";
    private static final String CHOCOLATE = "chocolate";
    private static final String MATCHA_LATTE = "matcha_latte";
    private static final String THAI_TEA = "thai_tea";
    private static final String RED_VELVET = "red_velvet";
    private static final String GREEN_TEA = "green_tea";
    private static final String SWEETS = "sweets";
    private static final String CUPCAKE = "cupcake";
    private static final String DOUGHNUT = "doughnut";
    private static final String CROISSANT = "croissant";
    private static final String CHEESECAKE = "cheesecake";
    private static final String TOTAL_PRICE = "total_price";

    private static final String CREATE_TABLE_ORDER = "CREATE TABLE "
            +TABLE_ORDER+ "("+ORDER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_NUMBER+" TEXT, "+CUSTOMER_NAME+" TEXT, "+ORDER_NOTE+" TEXT," +
            " "+AMERICANO+" TEXT, "+CAPPUCINO+" TEXT, "+MACCHIATO+" TEXT, "+ESPRESSO+" TEXT, "+LATTE+" TEXT," +
            " "+CHOCOLATE+" TEXT, "+MATCHA_LATTE+" TEXT, "+THAI_TEA+" TEXT, "+RED_VELVET+" TEXT, "+GREEN_TEA+" TEXT," +
            " "+SWEETS+" TEXT, "+CUPCAKE+" TEXT, "+DOUGHNUT+" TEXT, "+CROISSANT+" TEXT, "+CHEESECAKE+" TEXT, "+TOTAL_PRICE+" TEXT );";

    //--TABLE ORDER CRUD CODE---------------------------------------------------------------------//
    public long createOrder(String table_number, String customer_name, String order_note,
                            String americano, String cappucino, String macchiato, String espresso, String latte,
                            String chocolate, String matchalatte, String thaitea, String redvelvet, String greentea,
                            String sweets, String cupcake, String doughnut, String croissant, String cheesecake, String totalprice) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE_NUMBER, table_number);
        values.put(CUSTOMER_NAME, customer_name);
        values.put(ORDER_NOTE, order_note);
        values.put(AMERICANO, americano);
        values.put(CAPPUCINO, cappucino);
        values.put(MACCHIATO, macchiato);
        values.put(ESPRESSO, espresso);
        values.put(LATTE, latte);
        values.put(CHOCOLATE, chocolate);
        values.put(MATCHA_LATTE, matchalatte);
        values.put(THAI_TEA, thaitea);
        values.put(RED_VELVET, redvelvet);
        values.put(GREEN_TEA, greentea);
        values.put(SWEETS, sweets);
        values.put(CUPCAKE, cupcake);
        values.put(DOUGHNUT, doughnut);
        values.put(CROISSANT, croissant);
        values.put(CHEESECAKE, cheesecake);
        values.put(TOTAL_PRICE, totalprice);

        long insert = db.insert(TABLE_ORDER, null, values);
        return insert;
    }

    @SuppressLint("Range")
    public ArrayList<Order> readOrder() {
        ArrayList<Order> userModelArrayList = new ArrayList<Order>();

        String selectQuery = "SELECT * FROM " + TABLE_ORDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Order order = new Order();
                order.setOrder_id(c.getInt(c.getColumnIndex(ORDER_ID)));
                order.setCustomer_name(c.getString(c.getColumnIndex(CUSTOMER_NAME)));
                order.setTable_number(c.getString(c.getColumnIndex(TABLE_NUMBER)));
                order.setOrder_note(c.getString(c.getColumnIndex(ORDER_NOTE)));

                order.setAmericano(c.getString(c.getColumnIndex(AMERICANO)));
                order.setCappucino(c.getString(c.getColumnIndex(CAPPUCINO)));
                order.setMacchiato(c.getString(c.getColumnIndex(MACCHIATO)));
                order.setEspresso(c.getString(c.getColumnIndex(ESPRESSO)));
                order.setLatte(c.getString(c.getColumnIndex(LATTE)));
                order.setChocolate(c.getString(c.getColumnIndex(CHOCOLATE)));
                order.setMatcha_latte(c.getString(c.getColumnIndex(MATCHA_LATTE)));
                order.setThai_tea(c.getString(c.getColumnIndex(THAI_TEA)));
                order.setRed_velvet(c.getString(c.getColumnIndex(RED_VELVET)));
                order.setGreen_tea(c.getString(c.getColumnIndex(GREEN_TEA)));
                order.setSweets(c.getString(c.getColumnIndex(SWEETS)));
                order.setCupcake(c.getString(c.getColumnIndex(CUPCAKE)));
                order.setDoughnut(c.getString(c.getColumnIndex(DOUGHNUT)));
                order.setCroissant(c.getString(c.getColumnIndex(CROISSANT)));
                order.setCheesecake(c.getString(c.getColumnIndex(CHEESECAKE)));

                order.setTotal_price(c.getString(c.getColumnIndex(TOTAL_PRICE)));

                userModelArrayList.add(order);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public int updateOrder(int id, String table_number, String customer_name, String order_note,
                           String americano, String cappucino, String macchiato, String espresso, String latte,
                           String chocolate, String matchalatte, String thaitea, String redvelvet, String greentea,
                           String sweets, String cupcake, String doughnut, String croissant, String cheesecake, String totalprice) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TABLE_NUMBER, table_number);
        values.put(CUSTOMER_NAME, customer_name);
        values.put(ORDER_NOTE, order_note);
        values.put(AMERICANO, americano);
        values.put(CAPPUCINO, cappucino);
        values.put(MACCHIATO, macchiato);
        values.put(ESPRESSO, espresso);
        values.put(LATTE, latte);
        values.put(CHOCOLATE, chocolate);
        values.put(MATCHA_LATTE, matchalatte);
        values.put(THAI_TEA, thaitea);
        values.put(RED_VELVET, redvelvet);
        values.put(GREEN_TEA, greentea);
        values.put(SWEETS, sweets);
        values.put(CUPCAKE, cupcake);
        values.put(DOUGHNUT, doughnut);
        values.put(CROISSANT, croissant);
        values.put(CHEESECAKE, cheesecake);
        values.put(TOTAL_PRICE, totalprice);

        return db.update(TABLE_ORDER, values, ORDER_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteOrder(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDER, ORDER_ID + " = ?", new String[]{String.valueOf(id)});
    }
    //--------------------------------------------------------------------------------------------//
    //--------------------------------------------------------------------------------------------//

    //--TABLE HISTORY ----------------------------------------------------------------------------//
    private static final String HISTORY_ID2 = "history_id";
    private static final String TABLE_NUMBER2 = "table_number";
    private static final String CUSTOMER_NAME2 = "customer_name";
    private static final String ORDER_NOTE2 = "order_note";
    private static final String AMERICANO2 = "americano";
    private static final String CAPPUCINO2 = "cappucino";
    private static final String MACCHIATO2 = "macchiato";
    private static final String ESPRESSO2 = "espresso";
    private static final String LATTE2 = "latte";
    private static final String CHOCOLATE2 = "chocolate";
    private static final String MATCHA_LATTE2 = "matcha_latte";
    private static final String THAI_TEA2 = "thai_tea";
    private static final String RED_VELVET2 = "red_velvet";
    private static final String GREEN_TEA2 = "green_tea";
    private static final String SWEETS2 = "sweets";
    private static final String CUPCAKE2 = "cupcake";
    private static final String DOUGHNUT2 = "doughnut";
    private static final String CROISSANT2 = "croissant";
    private static final String CHEESECAKE2 = "cheesecake";
    private static final String TOTAL_PRICE2 = "total_price";

    private static final String CREATE_TABLE_HISTORY = "CREATE TABLE "
            +TABLE_HISTORY+ "("+HISTORY_ID2+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TABLE_NUMBER2+" TEXT, "+CUSTOMER_NAME2+" TEXT," +ORDER_NOTE2+" TEXT," +
            " "+AMERICANO2+" TEXT, "+CAPPUCINO2+" TEXT, "+MACCHIATO2+" TEXT, "+ESPRESSO2+" TEXT, "+LATTE2+" TEXT," +
            " "+CHOCOLATE2+" TEXT, "+MATCHA_LATTE2+" TEXT, "+THAI_TEA2+" TEXT, "+RED_VELVET2+" TEXT, "+GREEN_TEA2+" TEXT," +
            " "+SWEETS2+" TEXT, "+CUPCAKE2+" TEXT, "+DOUGHNUT2+" TEXT, "+CROISSANT2+" TEXT, "+CHEESECAKE2+" TEXT, "+TOTAL_PRICE2+" TEXT );";


    //--TABLE HISTORY CRUD CODE-------------------------------------------------------------------//
    public long createHistory(String table_number2, String customer_name2, String order_note2,
                              String americano2, String cappucino2, String macchiato2, String espresso2, String latte2,
                              String chocolate2, String matchalatte2, String thaitea2, String redvelvet2, String greentea2,
                              String sweets2, String cupcake2, String doughnut2, String croissant2, String cheesecake2,
                              String total_price2) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valueshistory = new ContentValues();
        valueshistory.put(TABLE_NUMBER2, table_number2);
        valueshistory.put(CUSTOMER_NAME2, customer_name2);
        valueshistory.put(ORDER_NOTE2, order_note2);

        valueshistory.put(AMERICANO2, americano2);
        valueshistory.put(CAPPUCINO2, cappucino2);
        valueshistory.put(MACCHIATO2, macchiato2);
        valueshistory.put(ESPRESSO2, espresso2);
        valueshistory.put(LATTE2, latte2);
        valueshistory.put(CHOCOLATE2, chocolate2);
        valueshistory.put(MATCHA_LATTE2, matchalatte2);
        valueshistory.put(THAI_TEA2, thaitea2);
        valueshistory.put(RED_VELVET2, redvelvet2);
        valueshistory.put(GREEN_TEA2, greentea2);
        valueshistory.put(SWEETS2, sweets2);
        valueshistory.put(CUPCAKE2, cupcake2);
        valueshistory.put(DOUGHNUT2, doughnut2);
        valueshistory.put(CROISSANT2, croissant2);
        valueshistory.put(CHEESECAKE2, cheesecake2);

        valueshistory.put(TOTAL_PRICE2, total_price2);

        long inserthistory = db.insert(TABLE_HISTORY, null, valueshistory);
        return inserthistory;
    }

    @SuppressLint("Range")
    public ArrayList<History> readHistory() {
        ArrayList<History> userModelArrayList = new ArrayList<History>();

        String selectQuery = "SELECT * FROM " + TABLE_HISTORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                History history = new History();
                history.setHistory_id(c.getInt(c.getColumnIndex(HISTORY_ID2)));
                history.setCustomer_name(c.getString(c.getColumnIndex(CUSTOMER_NAME2)));
                history.setTable_number(c.getString(c.getColumnIndex(TABLE_NUMBER2)));
                history.setOrder_note(c.getString(c.getColumnIndex(ORDER_NOTE2)));

                history.setAmericano(c.getString(c.getColumnIndex(AMERICANO2)));
                history.setCappucino(c.getString(c.getColumnIndex(CAPPUCINO2)));
                history.setMacchiato(c.getString(c.getColumnIndex(MACCHIATO2)));
                history.setEspresso(c.getString(c.getColumnIndex(ESPRESSO2)));
                history.setLatte(c.getString(c.getColumnIndex(LATTE2)));
                history.setChocolate(c.getString(c.getColumnIndex(CHOCOLATE2)));
                history.setMatcha_latte(c.getString(c.getColumnIndex(MATCHA_LATTE2)));
                history.setThai_tea(c.getString(c.getColumnIndex(THAI_TEA2)));
                history.setRed_velvet(c.getString(c.getColumnIndex(RED_VELVET2)));
                history.setGreen_tea(c.getString(c.getColumnIndex(GREEN_TEA2)));
                history.setSweets(c.getString(c.getColumnIndex(SWEETS2)));
                history.setCupcake(c.getString(c.getColumnIndex(CUPCAKE2)));
                history.setDoughnut(c.getString(c.getColumnIndex(DOUGHNUT2)));
                history.setCroissant(c.getString(c.getColumnIndex(CROISSANT2)));
                history.setCheesecake(c.getString(c.getColumnIndex(CHEESECAKE2)));

                history.setTotal_price(c.getString(c.getColumnIndex(TOTAL_PRICE2)));

                userModelArrayList.add(history);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }
    //--------------------------------------------------------------------------------------------//
    //--------------------------------------------------------------------------------------------//

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORDER);
        db.execSQL(CREATE_TABLE_HISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ORDER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_HISTORY + "'");
        onCreate(db);
    }
}
