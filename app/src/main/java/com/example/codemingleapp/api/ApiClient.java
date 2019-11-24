package com.example.codemingleapp.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    static ApiInterface apiInterface;
    static OkHttpClient okHttpClient=new OkHttpClient();
    static final String base_url="https://www.smartadvocatediary.com/codeigniter/api/";
    public static ApiInterface getClient(){

        apiInterface=new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build().create(ApiInterface.class);

        return apiInterface;
    }
}
