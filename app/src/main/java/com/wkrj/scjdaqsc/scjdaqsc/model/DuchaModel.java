package com.wkrj.scjdaqsc.scjdaqsc.model;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.DuchaObg;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmType;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by fxn on 2017/6/24.
 */

public class DuchaModel {
    private static final String CONTENT_TYPE = "multipart/form-data"; //内容类型
    private static final String BOUNDARY = "FlPm4LpSXsE" ; //UUID.randomUUID().toString(); //边界标识 随机生成 String PREFIX = "--" , LINE_END = "\r\n";
    /**
     *  获取监管督查的数据
     */
    public void duchaList(int page , int pagesize, String deptName,final ICallBack callBack) {
        //创建一个Request
        FormBody body = new FormBody.Builder()
                .add("page", page+"")
                .add("pagesize", pagesize+"")
                .add("deptName", deptName)
                .build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileJgdc/jgdcList.ht")
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
                    DuchaObg bglist = gson.fromJson(htmlStr, DuchaObg.class);
                    callBack.succeed(bglist);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     *  获取查询监管督查的数据
     */
    public void duchaQueryList(int page , int pagesize, String deptName, String enterpriseName,long enterpriseType,int yhqk, final ICallBack callBack) {
        //创建一个Request
        FormBody body = new FormBody.Builder()
                .add("page", page+"")
                .add("pagesize", pagesize+"")
                .add("deptName", deptName)
                .add("enterpriseName", enterpriseName)
                .add("enterpriseType", enterpriseType+"")
                .add("yhqk", yhqk+"")
                .build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileJgdc/jgdcList.ht")
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
                    DuchaObg bglist = gson.fromJson(htmlStr, DuchaObg.class);
                    callBack.succeed(bglist);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * 该部门企业类型
     */
    public void firmType(final ICallBack callBack){
        //创建一个Request
        String u = UrlUtils.url+"wkrj/mobile/wkrjMobileJgdc/getAllEnterpriseType.ht";
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
                    ArrayList<FirmType> names = new ArrayList<>();
                    //加强for循环遍历JsonArray
                    for (JsonElement user : jsonArray) {
                        //使用GSON，直接转成Bean对象
                        FirmType n = gson.fromJson(user, FirmType.class);
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
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    /**
     *  获取查询监管督查的数据
     */
    public void addDucha(long user_id,long firmtype , String time, Long firmId, String address, String user, String tel,
                         String problem, String zgcs,String zgsj, String tz_jcdw, String tz_other, List<String> mImgUrls, final ICallBack callBack) {
        // mImgUrls为存放图片的url集合
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (int i = 0; i < mImgUrls.size(); i++) {
            File f = new File(mImgUrls.get(i));
            if (f != null) {
                builder.addFormDataPart("img", f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
            }
        }
        builder.addFormDataPart("user_id",user_id+"");
        builder.addFormDataPart("tz_qytype",firmtype+"");
        builder.addFormDataPart("tz_checktime", time);
        builder.addFormDataPart("tz_checkqyname",firmId+"");
        builder.addFormDataPart("tz_checkaddress",address);
        builder.addFormDataPart("tz_dutyuser",user);
        builder.addFormDataPart("tz_tel",tel);
        builder.addFormDataPart("tz_exitproblem",problem);
        builder.addFormDataPart("tz_zgcs",zgcs);
        builder.addFormDataPart("tz_zgtime",zgsj);
        builder.addFormDataPart("tz_jcdw",tz_jcdw);
        builder.addFormDataPart("tz_other",tz_other);
        MultipartBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(UrlUtils.url+"wkrj/mobile/wkrjMobileJgdc/addOrUpdate.ht")
                .header("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY)
                .post(requestBody)
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
                    String htmlStr = response.body().string();
                    callBack.succeed(htmlStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
