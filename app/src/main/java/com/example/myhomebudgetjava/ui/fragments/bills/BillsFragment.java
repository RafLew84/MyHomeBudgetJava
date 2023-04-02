package com.example.myhomebudgetjava.ui.fragments.bills;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.data.DataProvider;
import com.example.myhomebudgetjava.data.model.Account;
import com.example.myhomebudgetjava.data.model.Bill;
import com.example.myhomebudgetjava.databinding.FragmentDetailInfoBinding;
import com.example.myhomebudgetjava.ui.fragments.accounts.AccountsAdapter;
import com.example.myhomebudgetjava.util.FormatterUtil;

import java.util.ArrayList;
import java.util.List;

import app.futured.donut.DonutSection;


public class BillsFragment extends Fragment {

    private FragmentDetailInfoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailInfoBinding.inflate(inflater);

        setupRecyclerView();
        setupDonutChart();
        setupTextViews();

        return binding.getRoot();
    }

    private void setupTextViews() {
        binding.totalAmountTextView.setText(String.format(
                "%s zł",
                FormatterUtil.formatter.format(DataProvider.totalBillsAmount))
        );
    }

    private void setupDonutChart() {
        List<DonutSection> values = new ArrayList<>();
        for (Bill item : DataProvider.bills){
            values.add(
                    new DonutSection(
                            item.getName(),
                            item.getColor(),
                            ((float) item.getAmount() / (float) DataProvider.totalBillsAmount))
            );
        }
        binding.donutViewAccount.submitData(values);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setAdapter(new BillsAdapter());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));
    }
}