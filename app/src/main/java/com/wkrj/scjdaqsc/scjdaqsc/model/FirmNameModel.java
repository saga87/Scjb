package com.wkrj.scjdaqsc.scjdaqsc.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmName;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmType;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;

/**
 * Created by fxn on 2017/7/1.
 */

public class FirmNameModel {
    /**
     * 该部门企业类型
     */
    public void firmName(final ICallBack callBack){
        //创建一个Request
        String u = UrlUtils.url+"wkrj/mobile/wkrjMobileEnterprise/getAllEnterprise.ht";
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
                    //Json的解析类对象
                    JsonParser parser = new JsonParser();
                    String htmlStr =  response.body().string();
                    //将JSON的String 转成一个JsonArray对象
                    JsonArray jsonArray = parser.parse(htmlStr).getAsJsonArray();
                    Gson gson = new Gson();
                    ArrayList<FirmName> names = new ArrayList<>();
                    //加强for循环遍历JsonArray
                    for (JsonElement user : jsonArray) {
                        //使用GSON，直接转成Bean对象
                        FirmName n = gson.fromJson(user, FirmName.class);
                        names.add(n);
                    }
                    callBack.succeed(names);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
