package com.example.bustracker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bustracker.db.BusDatabase;
import com.example.bustracker.db.Rider;

import java.util.List;

public class RiderViewer extends AppCompatActivity {
    private RiderListAdapter riderListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_viewer);

        Button addNewRiderButton = findViewById(R.id.addNewRiderButton);
        addNewRiderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RiderViewer.this, AddNewRiderActivity.class));
            }
        });

        initRecyclerView();

        loadRiderList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.riderRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        riderListAdapter = new RiderListAdapter(this);

        recyclerView.setAdapter(riderListAdapter);
    }

    private void loadRiderList() {
        BusDatabase db = BusDatabase.getBusDatabase(this.getApplicationContext());
        List<Rider> riderList = db.busDao().getRiders();
        riderListAdapter.setRiderList(riderList);
    }
}