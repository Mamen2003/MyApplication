package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.Adapter2;
import com.example.myapplication.model.model;
import com.example.myapplication.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PordukActivity extends AppCompatActivity {
    RecyclerView rvproduk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        rvproduk = findViewById(R.id.recommended_recycler);
        rvproduk.setHasFixedSize(true);

        getProducts();
    }

    private void getProducts() {
        Call<List<model>> apicall=RetrofitClient.getInstance().getAPI().getProducts();
        apicall.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> activityProduk = response.body();
                Toast.makeText(PordukActivity.this, "Got Produk", Toast.LENGTH_SHORT).show();
                setAdapter(activityProduk);
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(PordukActivity.this,"eror", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setAdapter(List<model> activityProduk) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvproduk.setLayoutManager(gridLayoutManager);
        Adapter2 adapter2 = new Adapter2(this,activityProduk);
        rvproduk.setAdapter(adapter2);
    }


}
