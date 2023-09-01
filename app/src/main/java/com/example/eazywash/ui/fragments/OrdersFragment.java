package com.example.eazywash.ui.fragments;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.eazywash.R;
import com.example.eazywash.ui.fragments.subfragments.CompletedFragment;
import com.example.eazywash.ui.fragments.subfragments.InProgressFragment;
import com.example.eazywash.utils.*;
import com.google.android.material.tabs.TabLayout;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrdersFragment extends DialogFragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        initComponent();
        return view;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
//        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle("Orders");
    }

    public void initComponent() {
        ViewPager view_pager = (ViewPager) view.findViewById(R.id.view_pager);
        TabLayout tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        setupViewPager(view_pager);
        tab_layout.setupWithViewPager(view_pager);
        Objects.requireNonNull(tab_layout.getTabAt(0)).setIcon(R.drawable.ic_add).setText("In Progress (4)");
        Objects.requireNonNull(tab_layout.getTabAt(1)).setIcon(R.drawable.ic_orders).setText("Completed");

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Objects.requireNonNull(tab.getIcon()).setColorFilter(getResources().getColor(R.color.colorTextIcons), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Objects.requireNonNull(tab.getIcon()).setColorFilter(getResources().getColor(R.color.ColorYellowNote), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter viewPagerAdapter = new SectionsPagerAdapter(((AppCompatActivity) requireActivity()).getSupportFragmentManager());
        viewPagerAdapter.addFragment(InProgressFragment.newInstance());    // index 0
        viewPagerAdapter.addFragment(CompletedFragment.newInstance());   // index 1
        viewPager.setPageTransformer(false, new TabletPageTransformer());
        viewPager.setAdapter(viewPagerAdapter);
    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @NotNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        public String getTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}