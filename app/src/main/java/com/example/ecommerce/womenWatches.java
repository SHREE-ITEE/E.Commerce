package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.WomenGridAdapter;
import Model.womenGrid;
import de.hdodenhof.circleimageview.CircleImageView;

public class womenWatches extends AppCompatActivity {
GridView womenGridView;
ArrayList<womenGrid> womenGrids;
WomenGridAdapter womenGridAdapter;
final private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("watches").child("women");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_watches);
        womenGridView=findViewById(R.id.womenGridView);
        womenGrids=new ArrayList<>();
        womenGridAdapter= new WomenGridAdapter(womenGrids,this);
        womenGridView.setAdapter(womenGridAdapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                  womenGrid womengrid;
                    womengrid = dataSnapshot.getValue(womenGrid.class);
                    womenGrids.add(womengrid);
                }
                womenGridAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}