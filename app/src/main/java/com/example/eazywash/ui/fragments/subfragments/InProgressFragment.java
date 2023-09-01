package com.example.eazywash.ui.fragments.subfragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.R;
import com.example.eazywash.adapter.OrderAdapter;
import com.example.eazywash.models.Order;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class InProgressFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Order> orderItemsList;
    View view;

    public static InProgressFragment newInstance() {
        return new InProgressFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_in_progress, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewOrders);
        initComponent();
        return view;
    }

    public void initComponent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        orderItemsList = new ArrayList<Order>();
        orderItemsList.add(new Order("#250004", "Delivery", 125.00, "Monday: 14:01 (01/09/23)", 0));
        orderItemsList.add(new Order("#050823", "Pick-up", 250.00, "Saturday: 10:01 (05/08/23)", 1));
        orderItemsList.add(new Order("#130923", "Delivery", 185.00, "Wednesday: 08:00 (13/09/23)", 0));
        orderItemsList.add(new Order("#190923", "Delivery", 300.00, "Friday: 15:01 (19/09/23)", 0));
        orderItemsList.add(new Order("#25000", "Pick-up", 170.00, "Sunday: 12:01 (04/09/23)", 1));
        OrderAdapter orderItemsAdapter = new OrderAdapter(getContext(), orderItemsList);
        recyclerView.setAdapter(orderItemsAdapter);

    }


}