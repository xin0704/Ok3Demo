package com.demo.ok3demo.Login.Activity;

import android.view.View;
import android.widget.EditText;

import com.demo.ok3demo.Base.BaseActivity;
import com.demo.ok3demo.Bean.User;
import com.demo.ok3demo.Login.Presenter.LoginPresenter;
import com.demo.ok3demo.Login.View.LoginView;
import com.demo.ok3demo.R;
import com.vondear.rxtools.view.RxTitle;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView<User> {

    @BindView(R.id.rx_title)
    RxTitle mTvTitle;

    @BindView(R.id.user_name)
    EditText mEtName;

    @BindView(R.id.user_pwd)
    EditText mEtPwd;

    private LoginPresenter presenter = new LoginPresenter();

    @Override
    protected void initData() {
    }

    @Override
    protected void initViews() {

        presenter.attachView(this);

    }

    @Override
    protected void initListener() {


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void getUserData(User user) {


    }

    @OnClick(R.id.login)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:

                String name = mEtName.getText().toString().trim();

                String pwd = mEtPwd.getText().toString().trim();

                presenter.login(name, pwd);

                break;
        }
    }
}
