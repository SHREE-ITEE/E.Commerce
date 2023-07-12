package search;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.R;
import com.example.ecommerce.menWatches;
import com.example.ecommerce.womenWatches;


public class searchFragment extends Fragment {
    CardView women,men;


    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_search, container, false);
        women=root.findViewById(R.id.women);
        men=root.findViewById(R.id.men);
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent womenWatches=new Intent(getContext(),com.example.ecommerce.womenWatches.class);
                startActivity(womenWatches);
            }
        });
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menWatches=new Intent(getContext(), com.example.ecommerce.menWatches.class);
                startActivity(menWatches);
            }
        });

        return root;
    }
}