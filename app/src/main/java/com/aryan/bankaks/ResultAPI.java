package com.aryan.bankaks;

import com.aryan.bankaks.Model.BankaksModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ResultAPI {

    @GET("{type}")
    Call<BankaksModel> getBalanceDetail(@Path("type") String id);

}
