package com.yogeshaswar.countrynamesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yogeshaswar.countrynamesapi.adapter.CountryAdapter;
import com.yogeshaswar.countrynamesapi.apiservice.GetCountryDataService;
import com.yogeshaswar.countrynamesapi.apiservice.RetrofitInstance;
import com.yogeshaswar.countrynamesapi.database.AppDatabase;
import com.yogeshaswar.countrynamesapi.database.CountryModelDao;
import com.yogeshaswar.countrynamesapi.models.CountryModel;
import com.yogeshaswar.countrynamesapi.models.ResultModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // base url => https://api.printful.com       end point => countries
   ArrayList<CountryModel>countries;
   AppDatabase appDatabase;
    CountryModelDao countryModelDao;
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateUI();
        getApiData();
        // database
        appDatabase = AppDatabase.getINSTANCE(this);
        countryModelDao = appDatabase.countryModelDao();

    }

    private void initiateUI() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
    }

    public void getApiData() {
        GetCountryDataService getCountryDataService = RetrofitInstance.getCountryDataService();
        Call<ResultModel> call = getCountryDataService.getResult();
        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                Toast.makeText(MainActivity.this, ""+ response.code(), Toast.LENGTH_SHORT).show();
                ResultModel resultModel = response.body();
                if(!(resultModel==null) && (resultModel.getResult() != null)){
                    countries = (ArrayList<CountryModel>) resultModel.getResult();
                    countryAdapter = new CountryAdapter(countries);
                    recyclerView.setAdapter(countryAdapter);
                    //TODO: save data in room database and then show in recycler view
                }

            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}