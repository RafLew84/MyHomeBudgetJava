package com.example.myhomebudgetjava.util;

import android.content.Context;
import android.graphics.Color;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myhomebudgetjava.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public final class TabSetupUtil {
    private TabSetupUtil(){}

    private static final int[] tabTitles = {R.string.overview, R.string.accounts, R.string.bills};
    private static final int[] tabIcons = {
            R.drawable.ic_overview,
            R.drawable.ic_accounts,
            R.drawable.ic_bills};

    public static void tabLayoutSetup(Context context, TabLayout tabLayout, ViewPager2 viewPager) {
        setupTabMediator(context, tabLayout, viewPager);
        setupTabSelection(context, tabLayout);
    }

    private static void setupTabMediator(
            Context context,
            TabLayout tabLayout,
            ViewPager2 viewPager ){
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setIcon(ContextCompat.getDrawable(context, tabIcons[position]));
                    if (position == 0) {
                        tab.setText(context.getString(tabTitles[position]));
                        Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);
                    }
                }
        ).attach();
    }

    private static void setupTabSelection(Context context, TabLayout tabLayout) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(context.getString(tabTitles[tab.getPosition()]));
                Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText("");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
