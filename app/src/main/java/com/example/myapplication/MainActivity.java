package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.KeranjangFragment;
import com.example.myapplication.model.model;
import com.example.myapplication.retrofit.ApiInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //navbar
    BottomNavigationView bottomNavigationView;
    HomeFragment homefragment = new HomeFragment();
    KeranjangFragment cartfragment = new KeranjangFragment();
    AkunFragment akunfragment = new AkunFragment();

    //database
    ApiInterface apiInterface;
    RecyclerView popular_recycler, recommended_recycler, all_item_recycler;

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<model> Lisdata = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.popular_recycler);
        rvData = findViewById(R.id.recommended_recycler);
        rvData = findViewById(R.id.all_item_recycler);
        lmData = new GridLayoutManager(this, 1,GridLayoutManager.HORIZONTAL, false);
        rvData.setLayoutManager(lmData);
        apiInterface.getProducts();

        //navbar
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homefragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homefragment).commit();
                        return true;
                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,cartfragment).commit();
                        return true;
                    case R.id.akun:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,akunfragment).commit();
                        return true;
                }

                return false;
            }
        });

     }


    private class AkunFragment extends Fragment {
        @NonNull
        @Override
        public CreationExtras getDefaultViewModelCreationExtras() {
            return super.getDefaultViewModelCreationExtras();
        }
    }


}