package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import Model.watchItem;

public class watchItemAdapter extends RecyclerView.Adapter<watchItemAdapter.ViewHolder> {
    Context scontext;
    public ArrayList<watchItem> watchItems;
    public FirebaseUser firebaseUser;

    public watchItemAdapter(ArrayList<watchItem> watchItems,Context scontext) {
        this.watchItems = watchItems;
        this.scontext=scontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(scontext).inflate(R.layout.activity_detailed_product,parent,false);
        return new watchItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        final watchItem watchitem=watchItems.get(position);
        Glide.with(scontext).load(watchitem.getImage()).into(holder.productImage);
        holder.productName.setText(watchitem.getName());
        holder.productPrice.setText(watchitem.getPrice());
        holder.description.setText(watchitem.getDescription());

    }

    @Override
    public int getItemCount() {
        return watchItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        TextView productName,productPrice,description;
        MaterialCardView moveCart,moveWishlist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.productImage);
            productName=itemView.findViewById(R.id.productName);
            productPrice=itemView.findViewById(R.id.productPrice);
            description=itemView.findViewById(R.id.description);
            moveCart=itemView.findViewById(R.id.moveCart);
            moveWishlist=itemView.findViewById(R.id.moveWishlist);
        }
    }
}
