package com.xujian.bizProduct.mvp3.presenter;

import android.os.Handler;
import android.os.Looper;

import com.xujian.bizProduct.mvp3.model.IUser;
import com.xujian.bizProduct.mvp3.model.UserModel;
import com.xujian.bizProduct.mvp3.view.ILoginView;

/**
 * Created by xujian on 2017/3/19.
 */
public class LoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }

    @Override
    public void onDestroy() {
        iLoginView = null;
    }

    private void initUser() {
        user = new UserModel("mvp", "mvp");
    }
}
