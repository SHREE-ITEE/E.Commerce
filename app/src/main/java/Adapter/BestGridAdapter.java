package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.DetailedProduct;
import com.example.ecommerce.R;

import java.util.ArrayList;

import Model.bestGrid;
import home.homeFragment;

public class BestGridAdapter extends BaseAdapter {
    private ArrayList<bestGrid> bestGrids;
    Context context;
    LayoutInflater layoutInflater;

    public BestGridAdapter(ArrayList<bestGrid> bestGrids, Context context) {
        this.bestGrids=bestGrids;
        this.context=context;

    }

    @Override
    public int getCount() {
        return bestGrids.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater==null) {
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.best_card,null);
        }
        ImageView bimage=convertView.findViewById(R.id.bimage);
        TextView bprice=convertView.findViewById(R.id.bprice);

        Glide.with(context).load(bestGrids.get(position).getImage()).into(bimage);
        bprice.setText(bestGrids.get(position).getPrice());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailedProduct.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:tools="http://schemas.android.com/tools"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    xmlns:app="http://schemas.android.com/apk/res-auto"
//    tools:context="home.homeFragment"
//    android:background="#313131">
//
//
//        <RelativeLayout
//            android:layout_width="match_parent"
//            android:layout_height="wrap_content">
//            <RelativeLayout
//                android:id="@+id/text"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:layout_marginStart="40dp"
//                android:layout_marginEnd="40dp"
//                android:layout_marginTop="30dp">
//
//                <TextView
//                    android:id="@+id/text1"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:fontFamily="@font/antic_didone"
//                    android:text="Welcome to the World"
//                    android:textColor="@color/white"
//                    android:textSize="30dp"
//                    android:textStyle="bold"
//                    android:layout_centerHorizontal="true"/>
//
//                <TextView
//                    android:id="@+id/text2"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_below="@id/text1"
//                    android:fontFamily="@font/antic_didone"
//                    android:paddingStart="20dp"
//                    android:text="of Luxurious watch"
//                    android:textColor="@color/white"
//                    android:textSize="30dp"
//                    android:textStyle="bold"
//                    android:layout_centerHorizontal="true"/>
//                <TextView
//                    android:id="@+id/text3"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_below="@id/text2"
//                    android:text="Find your perfect wrist"
//                    android:textColor="#7F7F7F"
//                    android:layout_centerHorizontal="true"
//                    android:layout_marginTop="5dp"
//                    android:textSize="18dp"/>
//            </RelativeLayout>
//
//            <TextView
//                android:id="@+id/bestSeller"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="Best Sellers"
//                android:textSize="20dp"
//                android:textColor="@color/white"
//                android:fontFamily="@font/antic_didone"
//                android:layout_below="@id/text"
//                android:layout_marginTop="60dp"
//                android:layout_marginStart="20dp"
//                android:textStyle="bold"/>
//
//            <GridView
//                android:id="@+id/bestGridView"
//                android:layout_width="match_parent"
//                android:layout_height="match_parent"
//                android:layout_below="@+id/bestSeller"
//                android:numColumns="2"
//                android:layout_marginTop="40dp"/>
//        </RelativeLayout>
//
//
//
//</RelativeLayout>