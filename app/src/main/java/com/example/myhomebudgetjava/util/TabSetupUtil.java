package com.example.myhomebudgetjava.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myhomebudgetjava.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public final class TabSetupUtil {
    private TabSetupUtil(){}

    private static final float tabScaleLow = 0.7f;
    private static final float tabScaleHigh = 1f;

    private static final int[] tabTitles = {R.string.overview, R.string.accounts, R.string.bills};
    private static final int[] tabIcons = {
            R.drawable.ic_overview,
            R.drawable.ic_accounts,
            R.drawable.ic_bills};

    public static void tabLayoutSetup(Context context, TabLayout tabLayout, ViewPager2 viewPager) {
        setupTabMediator(context, tabLayout, viewPager);
        initialTabsSetup(tabLayout);
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

        ViewGroup viewGroup = (ViewGroup) tabLayout.getChildAt(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(context.getString(tabTitles[tab.getPosition()]));
                Objects.requireNonNull(tab.getIcon()).setTint(Color.WHITE);

                // zwracam aktualną zakładkę jako View
                View currentChild = viewGroup.getChildAt(tab.getPosition());

                // czas animacji pobrany z zasobów systemowych Android
                long duration = (long) context.getResources()
                        .getInteger(android.R.integer.config_mediumAnimTime);

                setupAnimation(currentChild, tabScaleHigh, duration);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText("");

                View previousChild = viewGroup.getChildAt(tab.getPosition());
                long duration = 1L;

                setupAnimation(previousChild, tabScaleLow, duration);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private static void initialTabsSetup(TabLayout tabLayout) {
        ViewGroup viewGroup = (ViewGroup) tabLayout.getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (i == tabLayout.getSelectedTabPosition())
                continue;
            View tab = viewGroup.getChildAt(i);
            tab.setScaleX(tabScaleLow);
            tab.setScaleY(tabScaleLow);
        }
    }

    private static void setupAnimation(View view, float scale, long duration) {
        view.animate()
                .scaleX(scale)
                .scaleY(scale)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(duration)
                .start();
    }
}
