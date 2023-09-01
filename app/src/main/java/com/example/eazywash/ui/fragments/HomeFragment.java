package com.example.eazywash.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.R;
import com.example.eazywash.adapter.ClothingItemsAdapter;
import com.example.eazywash.models.ClothingItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends DialogFragment {

    RecyclerView recyclerView;


    ArrayList<ClothingItems> clothingItemsList;
    View view;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        initComponent();
        return view;

    }

    public void initData() {
        Resources resources = getResources();
       // clothing_items = resources.getStringArray(R.array.clothing_items);
    }

    public void initComponent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        clothingItemsList = new ArrayList<ClothingItems>();
        clothingItemsList = new ArrayList<>();
        clothingItemsList.add(new ClothingItems(4, "Shirt", 30));
        clothingItemsList.add(new ClothingItems(3, "Sneakers", 88));
        clothingItemsList.add(new ClothingItems(0, "Coat", 65));
        clothingItemsList.add(new ClothingItems(2, "Pants", 45));
        clothingItemsList.add(new ClothingItems(6, "Socks", 40));
        ClothingItemsAdapter clothingItemsAdapter = new ClothingItemsAdapter(getContext(), clothingItemsList);
        recyclerView.setAdapter(clothingItemsAdapter);
    }
}