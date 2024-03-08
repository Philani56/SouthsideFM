package com.example.myapplication;

// MyAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] data;

    public MyAdapter(String[] data) {
        this.data = data;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String[] parts = data[position].split("\n");
        holder.textViewProgramName.setText(parts[0]);
        holder.textViewTiming.setText(parts[1]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewProgramName;
        TextView textViewTiming;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProgramName = itemView.findViewById(R.id.textViewProgramName);
            textViewTiming = itemView.findViewById(R.id.textViewTiming);

        }
    }
}

