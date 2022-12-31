package com.example.myapplication.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.myapplication.R;
import com.example.myapplication.model.AdapterModel;
import com.example.myapplication.model.model;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //RecyclerView
    RecyclerView recyclerView;
    List<AdapterModel> itemList;

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<model> Lisdata = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        //RecyclerView
        recyclerView = view.findViewById(R.id.recommended_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    private List<AdapterModel> getItemList() {

        itemList = new ArrayList<>();
        itemList.add(new AdapterModel(R.drawable.ic_launcher_background, ""));
        itemList.add(new AdapterModel(R.drawable.ic_launcher_background, ""));
        itemList.add(new AdapterModel(R.drawable.ic_launcher_background, ""));
        return itemList;
    }
}