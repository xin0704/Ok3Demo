package com.demo.ok3demo.Http;

import android.text.TextUtils;

import com.demo.ok3demo.Bean.Data;
import com.demo.ok3demo.Constant.Constants;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2018/3/15.
 */

public class HttpUtil {

    private OkHttpClient okHttpClient;

    private static HttpUtil httpUtil;

    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            synchronized (HttpUtil.class) {
                if (httpUtil == null) {
                    httpUtil = new HttpUtil();
                }
            }
        }

        return httpUtil;
    }

    public HttpUtil() {
        okHttpClient = new OkHttpClient();
    }

    /**
     * post 提交Json数据
     *
     * @param url
     * @param json
     * @param iCallBack
     */
    public void postJsonData(String url, String json, final ICallBack iCallBack) {

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .addHeader("User-Agent", "UE-Mobile")
                .addHeader("Cookie", "8f639fa277f7e44708081379ab487401")
                .url(url)
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求服务器完成
                iCallBack.onComplete();
                //请求服务器失败
                iCallBack.onFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求服务器完成
                iCallBack.onComplete();
                //对服务器返回的数据做初步处理
                doResponse(response, iCallBack);
            }
        });

    }

    /**
     * post 提交键值对数据
     *
     * @param url
     * @param formBody
     * @param iCallBack
     */
    public void postMapData(String url, RequestBody formBody, final ICallBack iCallBack) {

        Request request = new Request.Builder()
                .addHeader("User-Agent", "UE-Mobile")
                .addHeader("Cookie", "8f639fa277f7e44708081379ab487401")
                .url(url)
                .post(formBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求服务器完成
                iCallBack.onComplete();
                //请求服务器失败
                iCallBack.onFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求服务器完成
                iCallBack.onComplete();
                //对服务器返回的数据做初步处理
                doResponse(response, iCallBack);
            }
        });
    }


    /**
     * get 提交数据
     *
     * @param url
     * @param iCallBack
     */
    public void getAllData(String url, final ICallBack iCallBack) {

        Request request = new Request.Builder()
                .addHeader("User-Agent", "UE-Mobile")
                .addHeader("Cookie", "8f639fa277f7e44708081379ab487401")
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求服务器完成
                iCallBack.onComplete();
                //请求服务器失败
                iCallBack.onFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求服务器完成
                iCallBack.onComplete();
                //对服务器返回的数据做初步处理
                doResponse(response, iCallBack);
            }
        });
    }


    /**
     * 处理服务器返回的数据
     *
     * @param response
     * @param iCallBack
     */
    private void doResponse(Response response, ICallBack iCallBack) throws IOException {

        Data data = new Gson().fromJson(response.body().string(), Data.class);

        if (data == null) {
            iCallBack.onFail("暂无数据");
            return;
        }

        if (Constants.code_200 != data.getCode()) {

            if (TextUtils.isEmpty(data.getMessage())) {
                iCallBack.onFail("获取数据失败");
            } else {
                iCallBack.onFail(data.getMessage());
            }
            return;
        }

        //请求数据成功
        iCallBack.onSuccess(new Gson().toJson(data.getResult()));

    }

}
