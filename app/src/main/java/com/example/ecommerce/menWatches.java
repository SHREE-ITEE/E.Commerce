package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.MenGridAdapter;
import Adapter.WomenGridAdapter;
import Model.menGrid;
import Model.womenGrid;

public class menWatches extends AppCompatActivity {
    GridView menGridView;
    ArrayList<menGrid> menGrids;
    MenGridAdapter menGridAdapter;
    final private DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("watches").child("men");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_watches);
        menGridView=findViewById(R.id.menGridView);
        menGrids=new ArrayList<>();
        menGridAdapter=new MenGridAdapter(menGrids,this);
        menGridView.setAdapter(menGridAdapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    menGrid menGrid;
                    menGrid=dataSnapshot.getValue(Model.menGrid.class);
                    menGrids.add(menGrid);
                }
                menGridAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}