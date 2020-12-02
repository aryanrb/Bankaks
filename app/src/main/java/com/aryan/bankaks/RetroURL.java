package com.aryan.bankaks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroURL {

    public static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-staging.bankaks.com/task/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
