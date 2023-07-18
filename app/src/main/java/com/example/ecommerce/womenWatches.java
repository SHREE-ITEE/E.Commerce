package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

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
 DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_watches);
        womenGridView=findViewById(R.id.womenGridView);
        womenGrids=new ArrayList<>();

        getData();


    }
    private void getData()
    {
        databaseReference=FirebaseDatabase.getInstance().getReference("watches").child("women");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                womenGrids.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    womenGrid womengrid = dataSnapshot.getValue(womenGrid.class);
                    Toast.makeText(getApplicationContext(), ""+womengrid.getImage(), Toast.LENGTH_SHORT).show();
                    womenGrids.add(womengrid);
                   // womenGrid womengrid=dataSnapshot.getValue(womenGrid.class);
                    //Toast.makeText(getApplicationContext(),womengrid.getId(),Toast.LENGTH_SHORT).show();
                }
                womenGridAdapter= new WomenGridAdapter(womenGrids,womenWatches.this);
                womenGridView.setAdapter(womenGridAdapter);
                womenGridAdapter.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}