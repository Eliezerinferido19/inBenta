package com.test.inbenta;

public class Item {
    private String itemName;
    private double listPrice;
    private double retailPrice;
    private int stockQty;
    private int soldQty;

    // Assume revenue is calculated based on the sold quantity and retail price
    public double Revenue() {
        return soldQty * retailPrice;
    }

    // Constructor
    public Item(String itemName, double listPrice, double retailPrice, int stockQty, int soldQty) {
        this.itemName = itemName;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
        this.stockQty = stockQty;
        this.soldQty = soldQty;
    }

    // Getters and setters for the properties
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStocQty(int stockQty) {
        this.stockQty = stockQty;
    }


    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }
}
