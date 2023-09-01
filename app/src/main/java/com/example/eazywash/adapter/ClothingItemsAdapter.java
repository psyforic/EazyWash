package com.example.eazywash.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.R;
import com.example.eazywash.models.ClothingItems;
import com.sdsmdg.tastytoast.TastyToast;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClothingItemsAdapter extends RecyclerView.Adapter<ClothingItemsAdapter.MyViewHolder> {
    Context context;
    List<ClothingItems> clothingItemsList;
    int quantity = 0;
    private String[] clothing_items;

    public ClothingItemsAdapter(Context context, List<ClothingItems> clothingItemsList) {
        this.context = context;
        this.clothingItemsList = clothingItemsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clothing_piece_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        ClothingItems items = clothingItemsList.get(position);

        holder.tvItemPrice.setText(items.getPrice() + "");
        holder.tvItemType.setText(items.getItem());
        holder.tvItemQuantity.setText(items.getQuantity() + "");
        if (Integer.parseInt(String.valueOf(holder.tvItemQuantity.getText())) == 0 && quantity == 0) {
            holder.btnMinus.setEnabled(false);
        } else {
            holder.btnMinus.setEnabled(true);
        }
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++quantity;
                Toast.makeText(context, "Clicked" + quantity, Toast.LENGTH_SHORT).show();
                clothingItemsList.get(holder.getAdapterPosition()).setQuantity(quantity);
                holder.tvItemQuantity.setText(clothingItemsList.get(holder.getAdapterPosition()).getQuantity() + "");
                holder.btnMinus.setEnabled(true);
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --quantity;
                clothingItemsList.get(holder.getAdapterPosition()).setQuantity(quantity);
                holder.tvItemQuantity.setText(clothingItemsList.get(holder.getAdapterPosition()).getQuantity() + "");
                TastyToast.makeText(context, "Clicked " + quantity, TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clothingItemsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemType;
        TextView tvItemQuantity;
        TextView tvItemPrice;
        ImageView imgItem;
        ImageView btnAdd;
        ImageView btnMinus;
        CardView cardView;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tvItemType = itemView.findViewById(R.id.tvClothingItem);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvItemQuantity = itemView.findViewById(R.id.tvNoItems);
            imgItem = itemView.findViewById(R.id.imgItem);
            btnAdd = itemView.findViewById(R.id.btnAdd);
            btnMinus = itemView.findViewById(R.id.btnMinus);


        }
    }
}
