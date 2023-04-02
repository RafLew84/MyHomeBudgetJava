package com.example.myhomebudgetjava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myhomebudgetjava.databinding.ActivityMainBinding;
import com.example.myhomebudgetjava.ui.adapters.FinanceAdapter;
import com.example.myhomebudgetjava.util.TabSetupUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.viewPager.setAdapter(new FinanceAdapter(this));
        TabSetupUtil.tabLayoutSetup(this, binding.tabLayout, binding.viewPager);
    }
}