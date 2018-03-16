package com.demo.ok3demo.Base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import android.view.View;
import android.widget.Toast;

import com.demo.ok3demo.R;
import com.gyf.barlibrary.ImmersionBar;
import com.vondear.rxtools.RxBarTool;

import butterknife.ButterKnife;

/**
 * Created by admin on 2018/3/15.
 */

public abstract class BaseActivity extends FragmentActivity implements IBaseView, View.OnClickListener {

    protected abstract void initData();

    protected abstract void initViews();

    protected abstract void initListener();

    protected abstract int getContentViewId();

    public Context mContext;

    public Dialog loadingDialog;//转圈刷新效果

    protected ImmersionBar mImmersionBar;//沉浸式状态栏


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RxBarTool.setNoTitle(this);
        //绑定布局
        setContentView(getContentViewId());

        RxBarTool.setTransparentStatusBar(this);

        //绑定butter knife
        ButterKnife.bind(this);

        mContext = this;

        //初始化沉浸式状态栏
        initImmersionBar();
        //初始化加载效果
        initDialogStyle();

        initData();
        initViews();
        initListener();




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    /**
     * 设置转圈加载效果
     */
    private void initDialogStyle() {

        if (loadingDialog == null) {

            loadingDialog = new Dialog(this, R.style.CustomerDialog);

        }
        //设置布局
        loadingDialog.setContentView(R.layout.loading_view);
        //设置点击外部不被取消
        loadingDialog.setCanceledOnTouchOutside(false);

    }

    /**
     * 初始化沉浸式状态栏
     */
    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        //带标题的沉浸式状态栏
        mImmersionBar.init();

        mImmersionBar.statusBarView(R.id.top_view)
                .statusBarColor(R.color.status_bar_color)
                .statusBarDarkFont(true)
                .init();
    }


    @Override
    public void showLoadingDialog() {

        loadingDialog.show();

    }

    @Override
    public void hideLoadingDialog() {
        loadingDialog.dismiss();
    }

    @Override
    public void showToast(String msg) {

        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        message.setData(bundle);

        handler.sendMessage(message);

    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:

                    //弹信息提示  包括：请求服务器失败等
                    Bundle bundle = msg.getData();

                    if (bundle != null){
                        Toast.makeText(mContext, bundle.getString("msg"), Toast.LENGTH_SHORT).show();
                    }

                    break;
                default:
                    break;
            }

        }
    };
}
