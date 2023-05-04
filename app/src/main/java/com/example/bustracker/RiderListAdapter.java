package com.example.bustracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bustracker.db.Rider;

import java.util.List;

public class RiderListAdapter extends RecyclerView.Adapter<RiderListAdapter.RiderViewHolder> {
    private Context context;
    private List<Rider> riderList;

    public RiderListAdapter(Context context) {
        this.context = context;
    }

    public void setRiderList(List<Rider> riderList) {
        this.riderList = riderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RiderListAdapter.RiderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rider_recycler_row, parent, false);

        return new RiderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiderListAdapter.RiderViewHolder holder, int position) {
        holder.tvName.setText(this.riderList.get(position).getUsername());
        holder.tvPassword.setText(this.riderList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return this.riderList.size();
    }

    public class RiderViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPassword;

        public RiderViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tvRiderName);
            tvPassword = view.findViewById(R.id.tvRiderPassword);
        }
    }
}
