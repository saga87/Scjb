package com.wkrj.scjdaqsc.scjdaqsc.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmName;
import com.wkrj.scjdaqsc.scjdaqsc.model.FirmNameModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by fxn on 2017/6/19.
 */

public class App extends Application{
    private static OkHttpClient client;
    private static Context context;
    private static List<FirmName> name;
    public DisplayImageOptions options;
    private static String token;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        client = new OkHttpClient.Builder()
                //设置超时，不设置可能会报异常
                .connectTimeout(1000, TimeUnit.MINUTES)
                .readTimeout(1000, TimeUnit.MINUTES)
                .writeTimeout(1000, TimeUnit.MINUTES)
                .build();
        initImageLoader(getApplicationContext());
        FirmNameModel model = new FirmNameModel();
        model.firmName(new ICallBack() {
            public void succeed(Object object) {
                name = (List<FirmName>) object;
            }
            public void error(Object object) {
            }
        });
        // XGPushConfig.enableDebug(this, true);
        // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
        Context context = getApplicationContext();
        XGPushManager.registerPush(context);

        // 取消绑定账号（别名）：registerPush(context,"*")，即account="*"为取消绑定，解绑后，该针对该账号的推送将失效
        // 反注册（不再接收消息）：unregisterPush(context)
        // 设置标签：setTag(context, tagName)
        // 删除标签：deleteTag(context, tagName)
        XGPushConfig.enableDebug(this, true);
        //注册方法
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                Log.v("TPush", "注册成功,Token值为：" + data);
                token = (String) data;
            }
            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.v("TPush", "注册失败,错误码为：" + errCode + ",错误信息：" + msg);
            }
        });

    }
    public static String getToken(){
        return token;
    }
    public static Context getContext(){
        return context;
    }
    public static OkHttpClient getClient(){
        return client;
    }
    public static List<FirmName> getFirmName(){
        return name;
    }
    public void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .memoryCacheSize(2 * 1024 * 1024) //缓存到内存的最大数据
                .memoryCacheSize(50 * 1024 * 1024) //设置内存缓存的大小
                .diskCacheFileCount(200)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
}
