package com.example.catatan;

public class WalletEntry {
    private String name;
    private String type; // "income" or "expense"
    private double amount;
    private String date;

    public WalletEntry(String name, String type, double amount, String date) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(String date) { this.date = date; }
}

