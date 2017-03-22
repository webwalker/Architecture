package com.xujian.frameworkcore.recycle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * Created by xujian on 2016/9/14.
 */
public class YMTViewHolder extends RecyclerView.ViewHolder {

    public YMTViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public YMTViewHolder(View itemView, boolean widthMatchParent) {
        this(itemView);
        if (widthMatchParent) {
            Context context = itemView.getContext();
            if (context != null) {
                WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                if (manager != null && manager.getDefaultDisplay() != null) {
                    int width = manager.getDefaultDisplay().getWidth();
                    int height = RecyclerView.LayoutParams.WRAP_CONTENT;
                    if (itemView.getLayoutParams() != null) {
                        height = itemView.getLayoutParams().height;
                    }
                    itemView.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
                }
            }
        }
    }

    public View getItemView() {
        return itemView;
    }
}
