/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xujian.bizProduct.mvp1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xujian.bizProduct.mvp1.presenter.StatisticsPresenter;
import com.xujian.bizProduct.utils.ActivityUtils;

/**
 * Show statistics for tasks.
 */
public class StatisticsActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(0);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(0);
        mDrawerLayout.setStatusBarBackground(0);
        NavigationView navigationView = (NavigationView) findViewById(0);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        StatisticsFragment statisticsFragment = (StatisticsFragment) getSupportFragmentManager()
                .findFragmentById(0);
        if (statisticsFragment == null) {
            statisticsFragment = StatisticsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    statisticsFragment, 0);
        }

        new StatisticsPresenter(
                null, statisticsFragment,
                null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
    }
}
