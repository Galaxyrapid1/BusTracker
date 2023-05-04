package com.example.bustracker.db;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface BusDao {
    @Insert
    void registerDriver(Driver driver);

    @Insert
    void registerRider(Rider rider);

    List<Driver> getDrivers();

    List<Rider> getRiders();
}
