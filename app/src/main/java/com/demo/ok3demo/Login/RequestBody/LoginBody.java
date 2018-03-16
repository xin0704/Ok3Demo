package com.demo.ok3demo.Login.RequestBody;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by admin on 2018/3/15.
 */

public class LoginBody {

    public static RequestBody login(String name, String pwd) {

        RequestBody formBody = new FormBody.Builder()
                .add("userName", name)
                .add("userPwd", pwd)
                .build();

        return formBody;
    }

}
