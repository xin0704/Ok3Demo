package com.demo.ok3demo.Http;

/**
 * Created by admin on 2018/3/15.
 */

public interface ICallBack {


    void onSuccess(String data);

    void onFail(String err_msg);

    void onComplete();


}
