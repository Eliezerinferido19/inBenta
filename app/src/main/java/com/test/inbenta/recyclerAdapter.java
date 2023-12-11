package com.test.inbenta;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private final ArrayList<Item> itemList;

    public recyclerAdapter(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView itemNametxt, listpricetxt, retailpricetxt, stockkqtytxt, soldqtytxt;
        private TextView revtxt;

        public MyViewHolder(final View view){
            super(view);
            itemNametxt = view.findViewById(R.id.itemtextview);
            listpricetxt = view.findViewById(R.id.listtextview);
            retailpricetxt = view.findViewById(R.id.retailtextview);
            stockkqtytxt = view.findViewById(R.id.stocktextview);
            soldqtytxt = view.findViewById(R.id.soldtextview);
            revtxt = view.findViewById(R.id.revtextview);


        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.six_list_item, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String itemname = itemList.get(position).getItemName();
        holder.itemNametxt.setText(itemname);

        // Convert Double values to String
        String listprice = String.valueOf(itemList.get(position).getListPrice());
        holder.listpricetxt.setText(listprice);

        String retailprice = String.valueOf(itemList.get(position).getRetailPrice());
        holder.retailpricetxt.setText(retailprice);

        // Convert int values to String
        String stockqty = String.valueOf(itemList.get(position).getStockQty());
        holder.stockkqtytxt.setText(stockqty);

        String soldqty = String.valueOf(itemList.get(position).getSoldQty());
        holder.soldqtytxt.setText(soldqty);
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}