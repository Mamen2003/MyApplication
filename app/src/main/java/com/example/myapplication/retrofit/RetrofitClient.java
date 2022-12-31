package com.example.myapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private ApiInterface API;


    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        API = retrofit.create(ApiInterface.class);

    }

    public static synchronized RetrofitClient getInstance(){

        if(instance == null){
            instance = new RetrofitClient();


        }
        return instance;

    }
    public ApiInterface getAPI(){
        return API;
    }

}
