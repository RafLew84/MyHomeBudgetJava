package com.example.myhomebudgetjava.ui.fragments.accounts;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myhomebudgetjava.data.model.Account;
import com.example.myhomebudgetjava.databinding.RecyclerviewItemViewBinding;
import com.example.myhomebudgetjava.util.FormatterUtil;

public class AccountsViewHolder extends RecyclerView.ViewHolder {

    private RecyclerviewItemViewBinding binding;

    public AccountsViewHolder(RecyclerviewItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Account item){
        binding.RVNameTextView.setText(item.getName());
        binding.RVNumberTextView.setText(
                new StringBuilder(item.getNumber())
                        .replace(0, 6, "******").toString()
        );
        binding.RVValueTextView.setText(String.format(
                "%s zł",
                FormatterUtil.formatter.format(item.getAmount()))
        );
        binding.RVcolorBarView.setBackgroundColor(item.getColor());
    }
}
