package com.example.bustracker.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Driver.class, Rider.class}, version = 1)
public abstract class BusDatabase extends RoomDatabase {
    private static final String dbName = "bus";
    private static BusDatabase busDatabase;

    public static synchronized BusDatabase getBusDatabase(Context context) {
        if (busDatabase == null)
            busDatabase = Room.databaseBuilder(context, BusDatabase.class, dbName).fallbackToDestructiveMigration().build();

        return busDatabase;
    }

    public abstract BusDao busDao();
}