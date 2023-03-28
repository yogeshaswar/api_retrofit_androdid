package com.yogeshaswar.countrynamesapi.apiservice;

import com.yogeshaswar.countrynamesapi.models.ResultModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {
    @GET("countries")
    Call<ResultModel> getResult();
}
