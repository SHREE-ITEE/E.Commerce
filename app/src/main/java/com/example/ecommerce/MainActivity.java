package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cart.cartFragment;
import home.homeFragment;
import search.searchFragment;
import wishlist.wishlistFragment;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth userAuth;
    FirebaseUser currentUser;
    ImageView home,search,wishlist,cart;
    FrameLayout fragmentContainer;
    Fragment selectedFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userAuth = FirebaseAuth.getInstance();
        currentUser = userAuth.getCurrentUser();
        home = findViewById(R.id.home);
        search = findViewById(R.id.search);
        wishlist = findViewById(R.id.wishlist);
        cart = findViewById(R.id.cart);
        fragmentContainer = findViewById(R.id.fragmentContainer);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment = new homeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                home.setImageResource(R.drawable.home);
                wishlist.setImageResource(R.drawable.outline_favorite);
                cart.setImageResource(R.drawable.outline_cart);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment = new searchFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                home.setImageResource(R.drawable.outline_home);
                wishlist.setImageResource(R.drawable.outline_favorite);
                cart.setImageResource(R.drawable.outline_cart);

            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment = new wishlistFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                home.setImageResource(R.drawable.outline_home);
                wishlist.setImageResource(R.drawable.favorite);
                cart.setImageResource(R.drawable.outline_cart);

            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFragment = new cartFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
                home.setImageResource(R.drawable.outline_home);
                wishlist.setImageResource(R.drawable.outline_favorite);
                cart.setImageResource(R.drawable.cart);

            }
        });
        if (selectedFragment == null) {
            selectedFragment = new homeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
        }
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (currentUser == null) {
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
            MainActivity.this.finish();
        }
    }
}