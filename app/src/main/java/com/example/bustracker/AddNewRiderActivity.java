package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bustracker.db.BusDatabase;
import com.example.bustracker.db.Rider;

public class AddNewRiderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_rider);

        final EditText riderName = findViewById(R.id.riderName);
        final EditText riderPassword = findViewById(R.id.riderPassword);
        Button saveRider = findViewById(R.id.saveRider);
        saveRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewRider(riderName.getText().toString(), riderPassword.getText().toString());
                Intent intent = new Intent(AddNewRiderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveNewRider(String name, String password) {
        BusDatabase db = BusDatabase.getBusDatabase(this.getApplicationContext());

        Rider rider = new Rider();
        rider.setUsername(name);
        rider.setPassword(password);
        db.busDao().registerRider(rider);

        finish();
    }
}