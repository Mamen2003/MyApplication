package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.PordukActivity;
import com.example.myapplication.model.model;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewModel> {
    Context mContext;
    List<model> Models;

    public Adapter2(Context mContext,List<model>Models) {
        this.mContext = mContext;
        this.Models = Models;

    }

    @NonNull
    @Override
    public Adapter2.ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_recomended, parent, false);
        return new ViewModel(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.namatxt.setText(Models.get(position).getNama());
        holder.hargatxt.setText(Models.get(position).getHarga());
        holder.itemImage.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PordukActivity.class);
            v.getContext().startActivity(intent);
        });

        Glide.with(mContext).load(Models.get(position).getHeroImg()).placeholder(R.drawable.popular1)
                .error(R.drawable.ic_launcher_foreground).into(holder.itemImage);



    }

    @Override
    public int getItemCount() {
        return Models.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView namatxt, hargatxt;
        CardView cardproduk;
        public ViewModel(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.recommended_image);
            namatxt = itemView.findViewById(R.id.recommended_name);
            hargatxt = itemView.findViewById(R.id.recommended_harga);
            cardproduk = itemView.findViewById(R.id.cardrecommed);
        }
    }
}
