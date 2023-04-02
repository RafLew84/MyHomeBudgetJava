package com.example.myhomebudgetjava.ui.fragments.overview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhomebudgetjava.databinding.FragmentOverviewBinding;

public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOverviewBinding.inflate(inflater);
        return binding.getRoot();
    }
}