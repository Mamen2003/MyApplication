package com.example.myapplication.retrofit;

import com.example.myapplication.model.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
     String BASE_URL = "https://mobileragetbags.000webhostapp.com/raget_bags";

    @GET("retrive.php")
    Call<List<model>> getProducts();





    // lets make our model class of json data.

}
