package com.xujian.bizProduct.mvp3.model;

/**
 * Created by xujian on 2017/3/19.
 */
public interface IUser {
    String getName();

    String getPasswd();

    int checkUserValidity(String name, String passwd);
}
