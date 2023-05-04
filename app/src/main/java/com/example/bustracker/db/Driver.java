package com.example.bustracker.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Driver")
public class Driver {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "userName")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "Route")
    String route;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
