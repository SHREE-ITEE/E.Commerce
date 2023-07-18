package home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ecommerce.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.BestGridAdapter;
import Adapter.WomenGridAdapter;
import Model.bestGrid;
import Model.womenGrid;


public class homeFragment extends Fragment {
    GridView GridView;
    ArrayList<bestGrid> bestGrids;
    BestGridAdapter bestGridAdapter;
    final private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("watches").child("bestsellers");



    public homeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_home,container,false);
        GridView=root.findViewById(R.id.GridView);
        bestGrids=new ArrayList<>();
        bestGridAdapter=new BestGridAdapter(bestGrids,getContext());
        GridView.setAdapter(bestGridAdapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    bestGrid bestgrid;
                    bestgrid=dataSnapshot.getValue(bestGrid.class);
                    bestGrids.add(bestgrid);
                }
                bestGridAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        return root;
    }
}