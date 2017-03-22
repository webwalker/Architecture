/*
 * Copyright (C) 2015 The Android Open Source Project
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
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xujian.bizProduct.mvp1.model.TasksFilterType;
import com.xujian.bizProduct.mvp1.presenter.TasksPresenter;
import com.xujian.bizProduct.utils.ActivityUtils;

public class TasksActivity extends AppCompatActivity {

    private static final String CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY";

    private DrawerLayout mDrawerLayout;

    private TasksPresenter mTasksPresenter;

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

        TasksFragment tasksFragment = (TasksFragment) getSupportFragmentManager().findFragmentById(0);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = TasksFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, 0);
        }

        // Create the presenter
        mTasksPresenter = new TasksPresenter(
                null,
                tasksFragment,
                null);

        // Load previously saved state, if available.
        if (savedInstanceState != null) {
            TasksFilterType currentFiltering =
                    (TasksFilterType) savedInstanceState.getSerializable(CURRENT_FILTERING_KEY);
            mTasksPresenter.setFiltering(currentFiltering);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(CURRENT_FILTERING_KEY, mTasksPresenter.getFiltering());
        super.onSaveInstanceState(outState);
    }

    private void setupDrawerContent(NavigationView navigationView) {

    }
}
