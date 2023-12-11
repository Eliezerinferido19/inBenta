package com.test.inbenta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class four_items_recyclerAdapter extends RecyclerView.Adapter<four_items_recyclerAdapter.MyViewHolder> {

    private ArrayList<four_item> fourItemList;
    private four_items_recyclerAdapter(ArrayList<four_item> fourItemList){
        this.fourItemList = fourItemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt, listingPrice, availQty, selectedQty;
        private ImageView minus_btn, add_btn;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.itemlistTV1);
            listingPrice = view.findViewById(R.id.itemlistTV2);
            availQty = view.findViewById(R.id.itemlistTV3);
            selectedQty = view.findViewById(R.id.itemlistTV4);
            minus_btn = view.findViewById(R.id.minusItem);
            add_btn = view.findViewById(R.id.addItem);
        }
    }

    @NonNull
    @Override
    public four_items_recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.four_list_item, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String item_name = fourItemList.get(position).getItem_name();
        holder.nameTxt.setText(item_name);

        String listprice = fourItemList.get(position).getItem_name();
        holder.listingPrice.setText(listprice);

        String avail = fourItemList.get(position).getItem_name();
        holder.availQty.setText(avail);

        String select = fourItemList.get(position).getItem_name();
        holder.selectedQty.setText(select);
    }

    @Override
    public int getItemCount() {
        return fourItemList.size();
    }
}
