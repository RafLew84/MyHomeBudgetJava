package com.example.myhomebudgetjava.util;

import android.content.Context;

import androidx.viewpager2.widget.ViewPager2;

import com.example.myhomebudgetjava.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public final class TabSetupUtil {
    private TabSetupUtil(){}

    private static final int[] tabTitles = {R.string.overview, R.string.accounts, R.string.bills};

    public static void setupTabLayoutMediator(
            Context context,
            TabLayout tabLayout,
            ViewPager2 viewPager2
    ) {
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    tab.setText(context.getString(tabTitles[position]));
                }
        ).attach();
    }
}
