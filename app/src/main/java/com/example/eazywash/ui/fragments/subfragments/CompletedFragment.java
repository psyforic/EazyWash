package com.example.eazywash.ui.fragments.subfragments;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.R;
import com.example.eazywash.adapter.CreateOrderAdapter;
import com.example.eazywash.adapter.OrderAdapter;
import com.example.eazywash.models.Order;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;

public class CompletedFragment extends DialogFragment {
    RecyclerView recyclerView;
    ArrayList<Order> orderItemsList;
    View view;
    CreateOrderAdapter createOrderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_completed, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCompleteOrders);
        initComponent();
        return view;
    }

    public void initComponent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        orderItemsList = new ArrayList<>();
        orderItemsList.add(new Order("#250004", "Delivery", 125.00, "Wash & Fold", 0));
        orderItemsList.add(new Order("#050823", "Pick-up", 250.00, "Laundry", 1));
        orderItemsList.add(new Order("#130923", "Delivery", 185.00, "Dry Cleaning", 0));
        orderItemsList.add(new Order("#190923", "Delivery", 300.00, "Steam Iron", 0));
        orderItemsList.add(new Order("#250004", "Pick-up", 170.00, "Shoe Cleaning", 1));
        orderItemsList.add(new Order("#250006", "Pick-up", 170.00, "Car Seat & Sofa", 1));
        createOrderAdapter = new CreateOrderAdapter(getActivity(), orderItemsList);
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
            TastyToast.makeText(getContext(), "Clicked " + order, TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
        });

    }
//    @Override
//    public void onClick(final View view) {
//        int itemPosition = this.recyclerView.getChildAdapterPosition(view);
////        String item = String.valueOf(orderItemsList.get(itemPosition));
//        Toast.makeText(getContext(), "Clicked", Toast.LENGTH_LONG).show();
//    }

    public static CompletedFragment newInstance() {
        CompletedFragment fragment = new CompletedFragment();
        return fragment;
    }

//    @Override
//    public void onItemClick(int position, boolean selected) {
//        TastyToast.makeText(getContext(), "Clicked " + orderItemsList.get(position), TastyToast.LENGTH_LONG, TastyToast.SUCCESS).show();
//    }
}