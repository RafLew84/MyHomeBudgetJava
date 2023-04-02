package com.example.myhomebudgetjava.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myhomebudgetjava.ui.fragments.accounts.AccountsFragment;
import com.example.myhomebudgetjava.ui.fragments.bills.BillsFragment;
import com.example.myhomebudgetjava.ui.fragments.overview.OverviewFragment;

public class FinanceAdapter extends FragmentStateAdapter {

    private final Fragment[] fragments = {
            new OverviewFragment(),
            new AccountsFragment(),
            new BillsFragment()
    };

    public FinanceAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}