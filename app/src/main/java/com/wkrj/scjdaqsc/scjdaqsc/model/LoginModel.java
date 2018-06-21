package com.wkrj.scjdaqsc.scjdaqsc.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmObg;
import com.wkrj.scjdaqsc.scjdaqsc.entity.LoginObg;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by fxn on 2017/6/29.
 */

public class LoginModel {
    /**
     * 登录
     */
    public void login(String username, String password,String token, final ICallBack callBack){
        //创建一个Request
        FormBody body = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .add("token", token)
                .build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileLogin/checkLogin.ht")
                .post(body)
                .build();
        //new call
        Call call = App.getClient().newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.error(e.getMessage().toString());
            }
            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    String htmlStr =  response.body().string();
                    Gson gson = new Gson();
                    LoginObg list = gson.fromJson(htmlStr, LoginObg.class);
                    callBack.succeed(list);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
