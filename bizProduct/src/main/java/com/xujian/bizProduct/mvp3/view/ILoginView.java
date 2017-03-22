package com.xujian.bizProduct.mvp3.view;

/**
 * Created by xujian on 2017/3/19.
 */
public interface ILoginView {
    public void onClearText();

    public void onLoginResult(Boolean result, int code);

    public void onSetProgressBarVisibility(int visibility);
}
