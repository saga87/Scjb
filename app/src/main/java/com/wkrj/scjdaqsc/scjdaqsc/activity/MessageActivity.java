package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;

public class MessageActivity extends BaseActivity {
    private LinearLayout ll_message_ajb,ll_message_jw,ll_message_dzb,ll_message_nw,ll_message_ljxq,ll_message_jjw,ll_message_sqk,ll_message_qdzz;
    private LinearLayout ll_message_back;
    private TextView tv_message_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        //初始化控件
        setView();
        //控件监听
        setListener();
    }
    /**
     * 控件监听
     */
    private void setListener() {
        SharedPreferences preferences = this.getSharedPreferences("wwj", Context.MODE_PRIVATE);
        String enterprise_id = preferences.getString("enterprise_id", "");
        long user_id = preferences.getLong("user_id", 0);
        long dept_id = preferences.getLong("dept_id", 0);
        final String dept = String.valueOf(dept_id);

        ll_message_ajb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830001")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830001");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_jw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830002")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830002");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_dzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830003")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830003");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_nw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830004")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830004");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_ljxq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830005")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830005");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_jjw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830006")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830006");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_sqk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830007")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830007");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_qdzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830008")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(MessageActivity.this, FirmActivity.class);
                    intent.putExtra("exp", "10000005830008");
                    startActivity(intent);
                }else {
                    Toast.makeText(MessageActivity.this,"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
    /**
     * 初始化控件
     */
    private void setView() {
        ll_message_back = (LinearLayout) findViewById(R.id.ll_message_back);
        ll_message_ajb = (LinearLayout) findViewById(R.id.ll_message_ajb);
        ll_message_jw = (LinearLayout) findViewById(R.id.ll_message_jw);
        ll_message_dzb = (LinearLayout) findViewById(R.id.ll_message_dzb);
        ll_message_nw = (LinearLayout) findViewById(R.id.ll_message_nw);
        ll_message_ljxq = (LinearLayout) findViewById(R.id.ll_message_ljxq);
        ll_message_jjw = (LinearLayout) findViewById(R.id.ll_message_jjw);
        ll_message_sqk = (LinearLayout) findViewById(R.id.ll_message_sqk);
        ll_message_qdzz = (LinearLayout) findViewById(R.id.ll_message_qdzz);

        tv_message_home = (TextView) findViewById(R.id.tv_message_home);
    }
}
