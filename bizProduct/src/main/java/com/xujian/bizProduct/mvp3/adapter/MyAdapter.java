package com.xujian.bizProduct.mvp3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xujian.bizProduct.mvp3.presenter.ILoginPresenter;
import com.xujian.frameworkcore.recycle.YMTRecycleAdapter;
import com.xujian.frameworkcore.recycle.YMTViewHolder;

import java.util.ArrayList;

/**
 * Created by xujian on 2017/3/19.
 */
public class MyAdapter extends YMTRecycleAdapter {
    public final static int VIEW_TYPE_NOTE = 0;
    public final static int VIEW_TYPE_PRODUCT = 1;

    private ILoginPresenter presenter;

    public MyAdapter(ILoginPresenter iFragmentPresenter) {
        this.presenter = iFragmentPresenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NOTE:
                return new YMTViewHolder(null);
            case VIEW_TYPE_PRODUCT:
                return new YMTViewHolder(null);
            default:
                return new YMTViewHolder(new TextView(parent.getContext()));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_NOTE:
                break;
            case VIEW_TYPE_PRODUCT:
                break;
        }
    }
}
