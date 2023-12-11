package com.test.inbenta;

public class four_item {
    private String item_name;
    private double listing_price;
    private int avail_Qty;

    public four_item(String itemName, double listingPrice, int availQty) {
        item_name = itemName;
        listing_price = listingPrice;
        avail_Qty = availQty;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getListing_price() {
        return listing_price;
    }

    public void setListing_price(double listing_price) {
        this.listing_price = listing_price;
    }



    public int getAvail_Qty() {
        return avail_Qty;
    }

    public void setAvail_Qty(int avail_Qty) {
        this.avail_Qty = avail_Qty;
    }
}
