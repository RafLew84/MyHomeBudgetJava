package com.example.myhomebudgetjava.ui.fragments.bills;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.databinding.FragmentBillsBinding;


public class BillsFragment extends Fragment {

    private FragmentBillsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBillsBinding.inflate(inflater);
        return binding.getRoot();
    }
}