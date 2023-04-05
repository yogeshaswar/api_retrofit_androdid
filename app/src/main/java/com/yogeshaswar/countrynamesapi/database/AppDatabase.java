package com.yogeshaswar.countrynamesapi.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.yogeshaswar.countrynamesapi.models.CountryModel;

@Database(entities = {CountryModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "country.db";

    // dao
    public abstract CountryModelDao countryModelDao();
    // database instance
    private static AppDatabase INSTANCE;
    public static synchronized AppDatabase getINSTANCE(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).
                    fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
}
