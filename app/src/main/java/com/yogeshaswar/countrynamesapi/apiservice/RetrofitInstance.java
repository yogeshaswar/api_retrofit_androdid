package com.yogeshaswar.countrynamesapi.apiservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "https://api.printful.com";
    private static Retrofit retrofit = null;

    // method that returns an instance of service
    public static GetCountryDataService getCountryDataService() {
        // if null
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GetCountryDataService.class);
    }
}
