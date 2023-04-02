package com.example.myhomebudgetjava.ui.fragments.accounts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.databinding.FragmentAccountsBinding;


public class AccountsFragment extends Fragment {

    private FragmentAccountsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccountsBinding.inflate(inflater);
        return binding.getRoot();
    }
}