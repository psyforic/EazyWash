package com.example.eazywash;

import android.annotation.SuppressLint;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eazywash.ui.fragments.HomeFragment;
import com.example.eazywash.ui.fragments.OrdersFragment;
import com.example.eazywash.ui.fragments.SupportFragment;
import com.example.eazywash.ui.fragments.subfragments.CompletedFragment;
import com.example.eazywash.ui.fragments.subfragments.MenuFragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    public ActionBar actionBar;
    FloatingActionButton fab;
    BottomAppBar bottomAppBar;
    CompletedFragment completedFragment = new CompletedFragment();
    MenuFragment menuFragment = new MenuFragment();
    HomeFragment homeFragment = new HomeFragment();
    OrdersFragment ordersFragment = new OrdersFragment();
    SupportFragment supportFragment = new SupportFragment();
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initToolbar();
        initData();
    }

    private void initData() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompletedFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_orders);
        //  bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setEnabled(true);
        setClickListeners();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Eazy Wash");

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
    }

    @SuppressLint("NonConstantResourceId")
    private void setClickListeners() {

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_menu:
                    chooseFragment(completedFragment);
                    break;
                case R.id.nav_orders:
                    chooseFragment(ordersFragment);
                    break;
                // case R.id.nav_home:
//                    chooseFragment(homeFragment);
//                    break;
                case R.id.nav_support:
                    chooseFragment(supportFragment);
                    break;
            }
            return true;
        });
    }

    private void chooseFragment(DialogFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_bottom, android.R.anim.fade_out);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}