package com.wkrj.scjdaqsc.scjdaqsc.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.NoticeList;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by fxn on 2017/6/20. 通知数据的工具类
 */
public class NoticeModel {
    /**
     * 获取通知公告数据
     */
    public void getNoticeList(int page, int pagesize, final ICallBack callBack){
        //创建一个Request
        final Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileNotice/noticeList.ht?page="+page+"&pagesize="+pagesize)
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
                    NoticeList list = gson.fromJson(htmlStr, NoticeList.class);
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
