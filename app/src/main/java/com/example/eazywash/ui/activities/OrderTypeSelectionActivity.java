package com.example.eazywash.ui.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.MainActivity;
import com.example.eazywash.R;
import com.example.eazywash.adapter.CreateOrderAdapter;
import com.example.eazywash.models.Order;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

public class OrderTypeSelectionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Order> orderItemsList;
    View view;
    CreateOrderAdapter createOrderAdapter;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_type_selection);
        initComponent();
        setOnClickListeners();
    }

    public void initComponent() {
        btnContinue = findViewById(R.id.btnContinue);
        recyclerView = findViewById(R.id.orderType);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderTypeSelectionActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setHasFixedSize(true);
        orderItemsList = new ArrayList<>();
        orderItemsList.add(new Order("#250004", "Delivery", 125.00, "Wash & Fold", 0));
        orderItemsList.add(new Order("#050823", "Pick-up", 250.00, "Laundry", 1));
        orderItemsList.add(new Order("#130923", "Delivery", 185.00, "Dry Cleaning", 0));
        orderItemsList.add(new Order("#190923", "Delivery", 300.00, "Steam Iron", 0));
        orderItemsList.add(new Order("#250004", "Pick-up", 170.00, "Shoe Cleaning", 1));
        orderItemsList.add(new Order("#250006", "Pick-up", 170.00, "Car Seat & Sofa", 1));
        createOrderAdapter = new CreateOrderAdapter(OrderTypeSelectionActivity.this, orderItemsList);
        recyclerView.setAdapter(createOrderAdapter);
        // int itemPosition = this.recyclerView.getChildAdapterPosition(view);
//        createOrderAdapter.onClick(new CreateOrderAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                orderItemsList.get(position).setSelected(!orderItemsList.get(position).isSelected());
//                TastyToast.makeText(getContext(), "Clicked", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
        createOrderAdapter.setOnclickListener((view, position) -> {
            orderItemsList.get(position).setSelected(!orderItemsList.get(position).isSelected());
            Order order = orderItemsList.get(position);
            TastyToast.makeText(OrderTypeSelectionActivity.this, "Clicked " + order, TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
        });
    }

    public void setOnClickListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderTypeSelectionActivity.this, MainActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(OrderTypeSelectionActivity.this, "Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}