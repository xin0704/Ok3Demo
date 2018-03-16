package com.demo.ok3demo.Base;

/**
 * Created by admin on 2018/3/15.
 */

public class IBasePresenter<V extends IBaseView> {

    public V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView(){
        view = null;
    }

    public boolean isViewAttached(){
        return view != null;
    }

}
