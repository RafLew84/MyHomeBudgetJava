package com.example.myhomebudgetjava.ui.fragments.bills;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.databinding.FragmentDetailInfoBinding;


public class BillsFragment extends Fragment {

    private FragmentDetailInfoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailInfoBinding.inflate(inflater);
        return binding.getRoot();
    }
}