package com.xujian.bizProduct.mvp3.presenter;

/**
 * Created by xujian on 2017/3/19.
 */
public interface ILoginPresenter {
    void clear();

    void doLogin(String name, String passwd);

    void setProgressBarVisiblity(int visiblity);

    void onDestroy();
}
