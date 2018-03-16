package com.demo.ok3demo.Login.Presenter;

import android.text.TextUtils;
import android.util.Log;

import com.demo.ok3demo.Base.IBasePresenter;
import com.demo.ok3demo.Bean.User;
import com.demo.ok3demo.Http.HttpUtil;
import com.demo.ok3demo.Http.ICallBack;
import com.demo.ok3demo.Login.RequestBody.LoginBody;
import com.demo.ok3demo.Login.View.LoginView;
import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/15.
 */

public class LoginPresenter extends IBasePresenter<LoginView> {

    private String url = "http://www.uedrive.com:81/common/user/android/login";

    public void login(String name, String pwd) {

        if (!isViewAttached()) {
            return;
        }

        if (TextUtils.isEmpty(name)) {
            view.showToast("用户名不能为空");
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            view.showToast("密码不能为空");
            return;
        }

        view.showLoadingDialog();

        HttpUtil.getInstance().postMapData(url, LoginBody.login(name, pwd), new ICallBack() {
            @Override
            public void onSuccess(String data) {

                User user = new Gson().fromJson(data, User.class);

                view.getUserData(user);

            }

            @Override
            public void onFail(String err_msg) {
                view.showToast(err_msg);
            }

            @Override
            public void onComplete() {
                view.hideLoadingDialog();
            }
        });


    }

}
