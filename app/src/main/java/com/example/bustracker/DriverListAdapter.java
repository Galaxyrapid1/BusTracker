package com.example.bustracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bustracker.db.Driver;

import java.util.List;

public class DriverListAdapter extends RecyclerView.Adapter<DriverListAdapter.DriverViewHolder>{
    private Context context;
    private List<Driver> driverList;

    public DriverListAdapter(Context context) {
        this.context = context;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DriverListAdapter.DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driver_recycler_row, parent, false);

        return new DriverListAdapter.DriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverListAdapter.DriverViewHolder holder, int position) {
        holder.tvName.setText(this.driverList.get(position).getUsername());
        holder.tvRoute.setText(this.driverList.get(position).getRoute());
        holder.tvPassword.setText(this.driverList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return this.driverList.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRoute;
        TextView tvPassword;

        public DriverViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tvDriverName);
            tvRoute = view.findViewById(R.id.tvDriverRoute);
            tvPassword = view.findViewById(R.id.tvDriverPassword);
        }
    }
}
