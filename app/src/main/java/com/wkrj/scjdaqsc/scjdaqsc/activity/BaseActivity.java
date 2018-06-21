package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.wkrj.scjdaqsc.scjdaqsc.util.ActivityCollector;

/**
 * Created by fxn on 2017/7/18.
 */

public class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加该活动
        ActivityCollector.addActivity(this);
        IntentFilter filter= new IntentFilter();
        filter.addAction("com.example.corn");
        registerReceiver(receiver , filter);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
            builder.setMessage("该用户在其他设备登录，请退出程序");
            builder.setTitle("登录异常");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which)
                {
                    ActivityCollector.finishAll();
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.setCancelable(false);
            alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event){
                    if (keyCode == KeyEvent.KEYCODE_SEARCH){
                        return true;
                    }else{
                        return false; //默认返回 false
                    }
                }
            });
            alertDialog.show();
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }
}
