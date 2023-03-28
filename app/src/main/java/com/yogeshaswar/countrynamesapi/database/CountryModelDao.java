package com.yogeshaswar.countrynamesapi.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.yogeshaswar.countrynamesapi.models.CountryModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CountryModelDao {
    // methods
    @Insert
    void InsertCountry(CountryModel countryModel);
    @Query("SELECT * FROM country_data")
    List<CountryModel>getCountryData();
}
