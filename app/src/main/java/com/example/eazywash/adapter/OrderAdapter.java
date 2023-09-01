package com.example.eazywash.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.R;
import com.example.eazywash.models.Order;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    Context context;
    List<Order> orderItemsList;
    int quantity = 0;
    private String[] order_items;

    public OrderAdapter(Context context, List<Order> orderItemsList) {
        this.context = context;
        this.orderItemsList = orderItemsList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        Order items = orderItemsList.get(position);
        holder.tvDate.setText(items.getDateTime());
        holder.tvStatus.setText(items.getDelivery());
        holder.tvOrderNo.setText(String.format("Order : %s", items.getOderNumber()));
        holder.tvPrice.setText("R" + String.valueOf(items.getPrice()));
        if (items.getDeliveryStatus() == 0) {
            holder.view.setBackgroundColor(Color.parseColor("#BDBDBD"));
        } else {
            holder.view.setBackgroundColor(Color.parseColor("#bf0603"));
        }
        if (items.getOrderStatus() == 1 || items.getOrderStatus() == 0) {
            holder.view.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return orderItemsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrice, tvOrderNo, tvDate, tvStatus;
        View view;
        ImageView orderType;

        LinearLayout lyt_order_parent;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvOrderNo = itemView.findViewById(R.id.tvOrderNo);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            orderType = itemView.findViewById(R.id.imgItemType);
            lyt_order_parent = itemView.findViewById(R.id.lyt_order_parent);
            view = itemView.findViewById(R.id.delivery_status);
        }
    }
}
