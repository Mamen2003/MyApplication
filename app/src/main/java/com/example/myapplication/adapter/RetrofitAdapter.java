package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.model.AdapterModel;
import com.example.myapplication.model.model;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.ViewHolder>{
    List<AdapterModel> itemList2;

    public RetrofitAdapter(List<AdapterModel>itemList){this.itemList2 = itemList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recomended,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemimage.setImageResource(itemList2.get(position).getImage());
        holder.itemtxt.setText(itemList2.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemimage;
        TextView itemtxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemimage = itemView.findViewById(R.id.recommended_image);
            itemtxt = itemView.findViewById(R.id.recommended_name);
        }
    }
}