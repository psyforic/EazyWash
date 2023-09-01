package com.example.eazywash.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.example.eazywash.R;
import com.example.eazywash.models.Order;
import com.google.android.material.card.MaterialCardView;
import com.sdsmdg.tastytoast.TastyToast;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CreateOrderAdapter extends RecyclerView.Adapter<CreateOrderAdapter.MyViewHolder> implements View.OnClickListener {
    Context context;
    List<Order> orderItemsList;
    private OnItemClickListener onItemClickListener;
    private String[] order_items;
    private static Order items;

    public CreateOrderAdapter(Context context, List<Order> orderItemsList) {
        this.context = context;
        this.orderItemsList = orderItemsList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_selection_item, parent, false);
//        view.setOnClickListener(onItemClickListener);
        return new CreateOrderAdapter.MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CreateOrderAdapter.MyViewHolder holder, int position) {
        //holder.bind(orderItemsList.get(position), listener);
        final MyViewHolder myViewHolder = holder;
        items = orderItemsList.get(position);
        myViewHolder.tvOrderType.setText(items.getDateTime());
        myViewHolder.cardOrder.setOnClickListener(view -> {
            TastyToast.makeText(view.getContext(), "Selected", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
            items.setSelected(!items.isSelected());
            //notifyDataSetChanged();
        });
        myViewHolder.imgItemType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TastyToast.makeText(view.getContext(), "Selected", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderItemsList.size();
    }

    @Override
    public void onClick(View view) {
        TastyToast.makeText(view.getContext(), "Selected", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnclickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvOrderType;
        ImageView tick, imgItemType;
        MaterialCardView cardOrder;
        CreateOrderAdapter.OnItemClickListener onItemClickListener;

        public MyViewHolder(@NonNull @NotNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            //  itemView.setOnClickListener(this);

            tvOrderType = itemView.findViewById(R.id.tvOrderType);
            tick = itemView.findViewById(R.id.tick);
            cardOrder = itemView.findViewById(R.id.cardOrder);
            imgItemType = itemView.findViewById(R.id.imgItemType);
            this.onItemClickListener = onItemClickListener;
            tick.setVisibility(itemView.isSelected() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            this.onItemClickListener.onItemClick(view, getAdapterPosition());
            TastyToast.makeText(view.getContext(), "Selected", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
            items.setSelected(!items.isSelected());
        }

//        @Override
//        public void onClick(View view) {
//            this.onItemClickListener.onItemClick(view, getAdapterPosition());
//            TastyToast.makeText(view.getContext(), "Selected", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
////            items.setSelected(!items.isSelected());
//        }
    }
}
