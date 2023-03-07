package model;

import java.io.Serializable;

public class History implements Serializable {
    private int history_id;
    private String customer_name;
    private String table_number;
    private String order_note;
    private String americano;
    private String cappucino;
    private String macchiato;
    private String espresso;
    private String latte;
    private String chocolate;
    private String matcha_latte;
    private String thai_tea;
    private String red_velvet;
    private String green_tea;
    private String sweets;
    private String cupcake;
    private String doughnut;
    private String croissant;
    private String cheesecake;
    private String total_price;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTable_number() {
        return table_number;
    }

    public void setTable_number(String table_number) {
        this.table_number = table_number;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public String getAmericano() {
        return americano;
    }

    public void setAmericano(String americano) {
        this.americano = americano;
    }

    public String getCappucino() {
        return cappucino;
    }

    public void setCappucino(String cappucino) {
        this.cappucino = cappucino;
    }

    public String getMacchiato() {
        return macchiato;
    }

    public void setMacchiato(String macchiato) {
        this.macchiato = macchiato;
    }

    public String getEspresso() {
        return espresso;
    }

    public void setEspresso(String espresso) {
        this.espresso = espresso;
    }

    public String getLatte() {
        return latte;
    }

    public void setLatte(String latte) {
        this.latte = latte;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public String getMatcha_latte() {
        return matcha_latte;
    }

    public void setMatcha_latte(String matcha_latte) {
        this.matcha_latte = matcha_latte;
    }

    public String getThai_tea() {
        return thai_tea;
    }

    public void setThai_tea(String thai_tea) {
        this.thai_tea = thai_tea;
    }

    public String getRed_velvet() {
        return red_velvet;
    }

    public void setRed_velvet(String red_velvet) {
        this.red_velvet = red_velvet;
    }

    public String getGreen_tea() {
        return green_tea;
    }

    public void setGreen_tea(String green_tea) {
        this.green_tea = green_tea;
    }

    public String getSweets() {
        return sweets;
    }

    public void setSweets(String sweets) {
        this.sweets = sweets;
    }

    public String getCupcake() {
        return cupcake;
    }

    public void setCupcake(String cupcake) {
        this.cupcake = cupcake;
    }

    public String getDoughnut() {
        return doughnut;
    }

    public void setDoughnut(String doughnut) {
        this.doughnut = doughnut;
    }

    public String getCroissant() {
        return croissant;
    }

    public void setCroissant(String croissant) {
        this.croissant = croissant;
    }

    public String getCheesecake() {
        return cheesecake;
    }

    public void setCheesecake(String cheesecake) {
        this.cheesecake = cheesecake;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
}
