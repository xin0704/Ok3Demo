package com.demo.ok3demo;

import android.app.Application;

import com.vondear.rxtools.RxTool;

/**
 * Created by admin on 2018/3/15.
 */

public class Ok3DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RxTool.init(this);
    }
}
