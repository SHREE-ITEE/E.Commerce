package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;

import java.util.ArrayList;

import Model.womenGrid;

public class WomenGridAdapter extends BaseAdapter {
    private ArrayList<womenGrid> womenGrids;
    private Context context;
    LayoutInflater layoutInflater;

    public WomenGridAdapter() {
    }

    public WomenGridAdapter(ArrayList<womenGrid> womenGrids,Context context) {
        this.womenGrids = womenGrids;
        this.context=context;
    }

    @Override
    public int getCount() {
        return womenGrids.size();
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
            convertView=layoutInflater.inflate(R.layout.women_card,null);
        }
        ImageView wimage=convertView.findViewById(R.id.wimage);
        TextView wprice=convertView.findViewById(R.id.wprice);

        Glide.with(context).load(womenGrids.get(position).getImage()).into(wimage);
        wprice.setText(womenGrids.get(position).getPrice());
        return convertView;
    }
}
