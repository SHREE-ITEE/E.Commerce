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

import Model.menGrid;
import Model.womenGrid;


public class MenGridAdapter extends BaseAdapter {
    private ArrayList<menGrid> menGrids;
    private Context context;
    LayoutInflater layoutInflater;
    public MenGridAdapter(ArrayList<menGrid> menGrids, Context context) {
        this.menGrids = menGrids;
        this.context=context;
    }

    @Override
    public int getCount() {
        return menGrids.size();
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
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.men_card,null);
        }
        ImageView mimage=convertView.findViewById(R.id.mimage);
        TextView mprice=convertView.findViewById(R.id.mprice);

        Glide.with(context).load(menGrids.get(position).getImage()).into(mimage);
        mprice.setText(menGrids.get(position).getPrice());
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
