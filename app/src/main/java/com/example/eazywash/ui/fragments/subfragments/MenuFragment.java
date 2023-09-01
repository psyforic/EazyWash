package com.example.eazywash.ui.fragments.subfragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.balysv.materialripple.MaterialRippleLayout;
import com.example.eazywash.R;
import com.google.android.material.card.MaterialCardView;
import com.sdsmdg.tastytoast.TastyToast;


public class MenuFragment extends DialogFragment {

    View view;
    MaterialCardView laundryCard, dryCleaningCard, carSeatCard, steamIronCard, shoeCleaningCard, washFoldCard;
    MaterialRippleLayout rplLyt_Laundry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        iniComponents();
        onCLickListeners();
        return view;
    }


    private void iniComponents() {
        laundryCard = view.findViewById(R.id.laundryCard);
        dryCleaningCard = view.findViewById(R.id.dry_cleanCard);
        carSeatCard = view.findViewById(R.id.car_seatCard);
        steamIronCard = view.findViewById(R.id.steam_ironCard);
        shoeCleaningCard = view.findViewById(R.id.shoe_cleaningCard);
        washFoldCard = view.findViewById(R.id.wash_foldCard);
        rplLyt_Laundry = view.findViewById(R.id.rplLyt_Laundry);
    }

    private void onCLickListeners() {
        rplLyt_Laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TastyToast.makeText(getContext(), "Clicked", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
            }
        });
        laundryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TastyToast.makeText(getContext(), "Clicked", TastyToast.LENGTH_LONG, TastyToast.ERROR).show();
            }
        });
    }

    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

}