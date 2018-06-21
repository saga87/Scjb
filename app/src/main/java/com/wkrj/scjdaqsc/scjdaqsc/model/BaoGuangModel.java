package com.wkrj.scjdaqsc.scjdaqsc.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by fxn on 2017/6/19.
 */
public class BaoGuangModel {
    /**
     *  获取曝光台的数据
     */
    public void baoGuangList(int page , int pagesize, String deptName, String type, final ICallBack callBack) {
        //创建一个Request
        FormBody body = new FormBody.Builder()
                .add("page", page+"")
                .add("pagesize", pagesize+"")
                .add("deptName", deptName)
                .add("type", type)
                .build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileBgt/list.ht")
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
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String htmlStr =  response.body().string();
                    Gson gson = new Gson();
                    BGlist bglist = gson.fromJson(htmlStr, BGlist.class);
                    callBack.succeed(bglist);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
