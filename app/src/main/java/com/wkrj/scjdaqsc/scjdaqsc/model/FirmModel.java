package com.wkrj.scjdaqsc.scjdaqsc.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmObg;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmType;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by fxn on 2017/6/21.
 */

public class FirmModel {
    /**
     * 该部门企业数量
     */
    public void firmList(int page , int pagesize, String deptName, final ICallBack callBack){
        //创建一个Request
        String u = UrlUtils.url+"wkrj/mobile/wkrjMobileEnterprise/enterpriseList.ht?page="+page+"&pagesize="+pagesize+"&deptName="+deptName;
        //创建一个Request
        final Request request = new Request.Builder()
                .url(u)
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
                    FirmObg list = gson.fromJson(htmlStr, FirmObg.class);
                    callBack.succeed(list);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     *  查询企业数量
     */
    public void firmQueryList(int page , int pagesize, String deptName, String enterpriseName, String enterpriseState,final ICallBack callBack) {
        //创建一个Request
        FormBody body = new FormBody.Builder()
                .add("page", page+"")
                .add("pagesize", pagesize+"")
                .add("deptName", deptName)
                .add("enterpriseName", enterpriseName)
                .add("enterpriseState", enterpriseState)
                .build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileEnterprise/enterpriseList.ht")
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
                    FirmObg list = gson.fromJson(htmlStr, FirmObg.class);
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
