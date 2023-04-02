package com.example.myhomebudgetjava.ui.fragments.bills;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhomebudgetjava.data.DataProvider;
import com.example.myhomebudgetjava.data.model.Bill;
import com.example.myhomebudgetjava.databinding.RecyclerviewItemViewBinding;

public class BillsAdapter extends RecyclerView.Adapter<BillsViewHolder> {

    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BillsViewHolder(RecyclerviewItemViewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull BillsViewHolder holder, int position) {
        Bill item = DataProvider.bills[position];
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return DataProvider.accounts.length;
    }

}

