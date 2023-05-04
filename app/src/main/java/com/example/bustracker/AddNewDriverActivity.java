package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bustracker.db.BusDatabase;
import com.example.bustracker.db.Driver;
import com.example.bustracker.db.Rider;

public class AddNewDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_driver);

        final EditText driverName = findViewById(R.id.driverName);
        final EditText driverRoute = findViewById(R.id.driverRoute);
        final EditText driverPassword = findViewById(R.id.driverPassword);
        Button saveDriver = findViewById(R.id.saveDriver);
        saveDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewDriver(driverName.getText().toString(), driverRoute.getText().toString(), driverPassword.getText().toString());
                Intent intent = new Intent(AddNewDriverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveNewDriver(String name, String route, String password) {
        BusDatabase db = BusDatabase.getBusDatabase(this.getApplicationContext());

        Driver driver = new Driver();
        driver.setUsername(name);
        driver.setRoute(route);
        driver.setPassword(password);
        db.busDao().registerDriver(driver);

        finish();
    }
}