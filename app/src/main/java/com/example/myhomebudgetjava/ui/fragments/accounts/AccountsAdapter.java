package com.example.myhomebudgetjava.ui.fragments.accounts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhomebudgetjava.data.DataProvider;
import com.example.myhomebudgetjava.data.model.Account;
import com.example.myhomebudgetjava.databinding.RecyclerviewItemViewBinding;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsViewHolder> {

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AccountsViewHolder(RecyclerviewItemViewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        Account item = DataProvider.accounts[position];
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return DataProvider.accounts.length;
    }
}
