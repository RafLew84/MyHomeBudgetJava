package com.example.myhomebudgetjava.ui.fragments.overview;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.R;
import com.example.myhomebudgetjava.data.DataProvider;
import com.example.myhomebudgetjava.databinding.FragmentOverviewBinding;
import com.example.myhomebudgetjava.ui.fragments.accounts.AccountsAdapter;
import com.example.myhomebudgetjava.ui.fragments.bills.BillsAdapter;
import com.example.myhomebudgetjava.util.FormatterUtil;

public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater);

        setupAlertSection();
        setupAccountsSection();
        setupBillsSection();

        return binding.getRoot();
    }

    private void setupBillsSection() {
        binding.billsRecyclerView.setAdapter(new BillsAdapter());
        binding.billsRecyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));

        binding.billsButton.setOnClickListener(v -> {
            ViewPager2 viewPager2 = requireActivity().findViewById(R.id.viewPager);
            viewPager2.setCurrentItem(2);
        });

        binding.billsTotalAmountTextView.setText(String.format(
                "%s zł",
                FormatterUtil.formatter.format(DataProvider.totalBillsAmount)));
    }

    private void setupAccountsSection() {

        binding.accountsRecyclerView.setAdapter(new AccountsAdapter());
        binding.accountsRecyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));

        binding.accountsButton.setOnClickListener(v -> {
            ViewPager2 viewPager2 = requireActivity().findViewById(R.id.viewPager);
            viewPager2.setCurrentItem(1);
        });

        binding.accountTotalAmountTextView.setText(String.format(
                "%s zł",
                FormatterUtil.formatter.format(DataProvider.totalAccountsAmount)));
    }

    private void setupAlertSection() {

        binding.seeMoreButton.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext(), R.style.MyDialogTheme)
                    .setTitle(getString(R.string.alerts)) // tytuł
                    .setView(getLayoutInflater().inflate(R.layout.alert_dialog, null)) // layout
                    .setPositiveButton("OK", (dialogInterface, i) -> {}) // domyślny przycisk pozwalający na wyjście
                    .create() // utwórz AlertDialog
                    .show(); // wyświetl Dialog
        });
    }
}