package com.test.inbenta;

import static com.test.inbenta.StockScreen.TAG;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterNewItem extends AppCompatActivity {

    EditText itemName, stockQty, purchasePrice, retailPrice;
    Button registerNewItemBtn;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_item);



        // Initialize views
        itemName = findViewById(R.id.itemName);
        stockQty = findViewById(R.id.stockQuantity);
        purchasePrice = findViewById(R.id.purchasePrice);
        retailPrice = findViewById(R.id.retailPrice);
        Spinner purchaseUomSpinner = findViewById(R.id.purchaseuomspinner);
        Spinner selectSellOptSpinner = findViewById(R.id.selectsellopt);
        Spinner sellOptSpinner = findViewById(R.id.sellopt);
        registerNewItemBtn = findViewById(R.id.btn_registernewitem);

        FirebaseAuth auth = FirebaseAuth.getInstance();


// Assuming the user has logged in
        FirebaseUser currentUser = auth.getCurrentUser();
        String userId  = currentUser.getUid();

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();
        // Set up the register button click listener
        registerNewItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditText fields
                String itemNameText = itemName.getText().toString().trim();
                int stockQuantityValue = Integer.parseInt(stockQty.getText().toString().trim());
                double purchasePriceValue = Double.parseDouble(purchasePrice.getText().toString().trim());
                double retailPriceValue = Double.parseDouble(retailPrice.getText().toString().trim());

                // Get selected items from spinners
                String selectedSpinner1Item = purchaseUomSpinner.getSelectedItem().toString();
                String selectedSpinner2Item = selectSellOptSpinner.getSelectedItem().toString();
                String selectedSpinner3Item = sellOptSpinner.getSelectedItem().toString();

                // Create a new item object or document with the gathered information
                Map<String, Object> newItem = new HashMap<>();
                newItem.put("ItemName", itemNameText);
                newItem.put("StockQuantity", stockQuantityValue);
                newItem.put("PurchasePrice", purchasePriceValue);
                newItem.put("RetailPrice", retailPriceValue);
                newItem.put("PurchaseUomSpnr", selectedSpinner1Item);
                newItem.put("selectSellOptSpner", selectedSpinner2Item);
                newItem.put("sellOptSpner", selectedSpinner3Item);
                //new
                // Add the new item to Firestore
                db.collection("users")
                        .document(userId)
                        .collection("items")
                        .add(newItem)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                // Item added successfully
                                Toast.makeText(RegisterNewItem.this, "Item added successfully!", Toast.LENGTH_SHORT).show();
                                // You can optionally finish the activity or navigate to another screen here
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Error occurred while adding item
                                Log.d(TAG, "Item Name: " + itemNameText + ", Stock Quantity: " + stockQuantityValue + ", Purchase Price: " + purchasePriceValue + ", Retail Price: " + retailPriceValue);
                                Toast.makeText(RegisterNewItem.this, "Error adding item: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });



        // Setup and handle purchase UOM spinner

        setupSpinner(purchaseUomSpinner, "select purchase Uom", "Please select a valid option", new String[]{"Pack", "Dozen", "Piece", "Ream", "Stick", "Box", "Bottle", "Meters", "Litre", "Pad", "Tablet", "Balon"});

        // Setup and handle select sell option spinner

        setupSpinner(selectSellOptSpinner, "select sell opt", "Please select a valid option", new String[]{"Pack/Dozen/Piece", "Pack/Piece", "Ream/Pack/Stick", "Ream/Pack", "Box/Bottle", "Piece", "Pack", "Box", "Bottle", "Ream", "Meters", "Litre"});

        // Setup and handle sell option spinner

        setupSpinner(sellOptSpinner, "sell opt", "Please select a valid option", new String[]{"opt", "baw unsa ni", "i dunno unsa e add"});
    }

    private void setupSpinner(Spinner spinner, String defaultSelection, String invalidSelectionMessage, String[] items) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = items[position];

                if (defaultSelection.equals(selectedValue)) {
                    Toast.makeText(RegisterNewItem.this, invalidSelectionMessage, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterNewItem.this, "Selected: " + selectedValue, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

    }
    public void  tostockscreen(View view){
        Intent intent = new Intent(this, StockScreen.class);
        startActivity(intent);
    }
}