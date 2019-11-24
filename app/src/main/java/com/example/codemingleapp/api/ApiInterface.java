package com.example.codemingleapp.api;

import com.example.codemingleapp.model.Example;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @FormUrlEncoded
    @POST("MasterGet/client")
    Single<List<Example>> getResponseData(@Header("x-api-key") String apikey,
                                          @Field("userid") String userid);
}
