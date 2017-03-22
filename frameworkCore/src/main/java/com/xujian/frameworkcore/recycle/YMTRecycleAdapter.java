package com.xujian.frameworkcore.recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujian on 2016/9/14.
 */
public abstract class YMTRecycleAdapter extends RecyclerView.Adapter {
    protected Context context;
    protected LayoutInflater inflater;
    protected final Object lock = new Object();
    protected List<AdapterDataItem> dataList = new ArrayList<>();

    protected SparseBooleanArray updateArrary = new SparseBooleanArray();

    //避免异步操作时增删改查出现问题
    private static Object mLock = new Object();

    public YMTRecycleAdapter() {
    }

    public YMTRecycleAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getViewType();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public AdapterDataItem getItem(int position) {
        if (position > dataList.size() - 1) return new AdapterDataItem(-1, "");
        return dataList.get(position);
    }

    public void add(AdapterDataItem dataItem) {
        synchronized (lock) {
            this.dataList.add(dataItem);
            notifyDataSetChanged();
        }
    }


    public void addAll(List<AdapterDataItem> dataItems) {
        synchronized (lock) {
            this.dataList.addAll(dataItems);
            notifyDataSetChanged();
        }
    }

    public void set(List<AdapterDataItem> dataItems) {
        synchronized (lock) {
            this.dataList.clear();
            this.dataList.addAll(dataItems);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        this.dataList.clear();
        notifyDataSetChanged();
    }
}
