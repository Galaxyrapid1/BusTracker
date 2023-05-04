package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bustracker.db.BusDatabase;
import com.example.bustracker.db.Driver;

import java.util.List;

public class DriverViewer extends AppCompatActivity {

    private DriverListAdapter driverListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_viewer);

        Button addNewRiderButton = findViewById(R.id.addNewDriverButton);
        addNewRiderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverViewer.this, AddNewRiderActivity.class));
            }
        });

        initRecyclerView();

        loadDriverList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.riderRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        driverListAdapter = new DriverListAdapter(this);

        recyclerView.setAdapter(driverListAdapter);
    }

    private void loadDriverList() {
        BusDatabase db = BusDatabase.getBusDatabase(this.getApplicationContext());
        List<Driver> driverList = db.busDao().getDrivers();
        driverListAdapter.setDriverList(driverList);
    }
}