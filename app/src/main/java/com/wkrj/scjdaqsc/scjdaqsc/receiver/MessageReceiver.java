package com.wkrj.scjdaqsc.scjdaqsc.receiver;

import android.content.Context;
import android.content.Intent;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;

/**
 * Created by fxn on 2017/7/11.
 */

public class MessageReceiver extends XGPushBaseReceiver {
    @Override
    public void onRegisterResult(Context context, int i, XGPushRegisterResult xgPushRegisterResult) {

    }

    @Override
    public void onUnregisterResult(Context context, int i) {

    }

    @Override
    public void onSetTagResult(Context context, int i, String s) {

    }

    @Override
    public void onDeleteTagResult(Context context, int i, String s) {

    }

    @Override
    public void onTextMessage(Context context, XGPushTextMessage xgPushTextMessage) {

    }

    @Override
    public void onNotifactionClickedResult(Context context, XGPushClickedResult xgPushClickedResult) {

    }

    @Override
    public void onNotifactionShowedResult(Context context, XGPushShowedResult xgPushShowedResult) {
        String str = xgPushShowedResult.getContent();
        if(str.indexOf("别处登录")!=-1){
            Intent intent = new  Intent();
            //设置intent的动作为com.example.broadcast，可以任意定义
            intent.setAction("com.example.corn");
            //发送无序广播
            App.getContext().sendBroadcast(intent);
        }else{

        }
    }
}
