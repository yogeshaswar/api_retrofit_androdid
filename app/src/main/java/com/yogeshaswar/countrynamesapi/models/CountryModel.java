package com.yogeshaswar.countrynamesapi.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "country_data")
@Generated("jsonschema2pojo")
public class CountryModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("states")
    @Expose
    @Ignore
    private Object states;
    @SerializedName("region")
    @Expose
    private String region;

    public CountryModel() {

    }
    @Ignore
    public CountryModel(String name, String code, String region) {
        this.name = name;
        this.code = code;
        this.region = region;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getStates() {
        return states;
    }

    public void setStates(Object states) {
        this.states = states;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
