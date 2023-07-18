package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.watchItemAdapter;
import Model.watchItem;
import Model.womenGrid;
import cart.cartFragment;
import wishlist.wishlistFragment;

public class DetailedProduct extends AppCompatActivity {
    ImageView productImage,back,gwishlist,gcart;
    TextView productName,productPrice, pdescription;
    MaterialCardView moveWishlist,moveCart;
    ArrayList<womenGrid> womenGrids;
    watchItemAdapter watchitemAdapter;
    womenGrid mwomenGrid;
    Fragment selectedFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product);
        String productId = getIntent().getStringExtra("item_id");
        productImage=findViewById(R.id.productImage);
        productName=findViewById(R.id.productName);
        productPrice=findViewById(R.id.productPrice);
        pdescription=findViewById(R.id.description);
        moveWishlist=findViewById(R.id.moveWishlist);
        moveCart=findViewById(R.id.moveCart);
        back=findViewById(R.id.back);
        gwishlist=findViewById(R.id.gwishlist);
        gcart=findViewById(R.id.gcart);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailedProduct.this, womenWatches.class);

                startActivity(intent);
            }
        });
        gwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wish=new Intent(DetailedProduct.this, wishlistFragment.class);
                startActivity(wish);
            }
        });
        gcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cart=new Intent(DetailedProduct.this, cartFragment.class);
                startActivity(cart);
            }
        });
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("watches").child("women");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    String name=snapshot.child("name").getValue(String.class);
                    String description=snapshot.child("description").getValue(String.class);
                    productName.setText(name);
                    pdescription.setText(description);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}