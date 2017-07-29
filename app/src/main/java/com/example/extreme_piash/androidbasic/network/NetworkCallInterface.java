package com.example.extreme_piash.androidbasic.network;

import com.example.extreme_piash.androidbasic.Model.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Extreme_Piash on 1/4/2017.
 */

public interface NetworkCallInterface {

    @GET("Categories/GetCategories")
    Call<BaseModel> getApiData();
}