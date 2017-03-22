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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xujian.bizProduct.mvp1.contract.StatisticsContract;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Main UI for the statistics screen.
 */
public class StatisticsFragment extends Fragment implements StatisticsContract.View {

    private TextView mStatisticsTV;

    private StatisticsContract.Presenter mPresenter;

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public void setPresenter(@NonNull StatisticsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(0, container, false);
        mStatisticsTV = (TextView) root.findViewById(0);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if (active) {
            mStatisticsTV.setText(getString(0));
        }
    }

    @Override
    public void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks) {
        if (numberOfCompletedTasks == 0 && numberOfIncompleteTasks == 0) {
            mStatisticsTV.setText(getResources().getString(0));
        } else {
            String displayString = getResources().getString(0) + " "
                    + numberOfIncompleteTasks + "\n" + getResources().getString(
                    0) + " " + numberOfCompletedTasks;
            mStatisticsTV.setText(displayString);
        }
    }

    @Override
    public void showLoadingStatisticsError() {
        mStatisticsTV.setText(getResources().getString(0));
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
