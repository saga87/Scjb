package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.wkrj.scjdaqsc.scjdaqsc.R;

public class HomeTActivity extends BaseActivity {
    private LinearLayout ll_ajdt_tzgg;
    private LinearLayout ll_ajdt_pgt;
    private LinearLayout ll_ajdt_jgdc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_t);
        //初始化控件
        setView();
        //控件监听
        setListener();
    }

    /**
     * 控件监听
     */
    private void setListener() {
        ll_ajdt_tzgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeTActivity.this,MainActivity.class);
                intent.putExtra("page","1");
                startActivity(intent);
                finish();
            }
        });
        ll_ajdt_pgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeTActivity.this,MainActivity.class);
                intent.putExtra("page","2");
                startActivity(intent);
                finish();
            }
        });
        ll_ajdt_jgdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeTActivity.this,MainActivity.class);
                intent.putExtra("page","3");
                startActivity(intent);
                finish();
            }
        });
    }
    /**
     * 初始化控件
     */
    private void setView() {
        ll_ajdt_tzgg = (LinearLayout) findViewById(R.id.ll_ajdt_tzgg);
        ll_ajdt_pgt = (LinearLayout) findViewById(R.id.ll_ajdt_pgt);
        ll_ajdt_jgdc = (LinearLayout) findViewById(R.id.ll_ajdt_jgdc);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        return false;
    }
}
