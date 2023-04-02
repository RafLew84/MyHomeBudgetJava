package com.example.myhomebudgetjava.ui.fragments.bills;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myhomebudgetjava.data.model.Bill;
import com.example.myhomebudgetjava.databinding.RecyclerviewItemViewBinding;
import com.example.myhomebudgetjava.util.FormatterUtil;

public class BillsViewHolder extends RecyclerView.ViewHolder {
    private final RecyclerviewItemViewBinding binding;

    public BillsViewHolder(RecyclerviewItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Bill item){
        binding.RVNameTextView.setText(item.getName());
        binding.RVNumberTextView.setText(item.getDate().format(FormatterUtil.dateFormatter));
        binding.RVValueTextView.setText(String.format(
                "- %s zł",
                FormatterUtil.formatter.format(item.getAmount()))
        );
        binding.RVcolorBarView.setBackgroundColor(item.getColor());
    }
}
