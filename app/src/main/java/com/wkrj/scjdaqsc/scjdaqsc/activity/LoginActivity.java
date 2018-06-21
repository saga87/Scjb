package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.app.App;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.LoginObg;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Lon;
import com.wkrj.scjdaqsc.scjdaqsc.model.LoginModel;

public class LoginActivity extends BaseActivity {
    private EditText et_login_paw,et_login_name;
    private Button btn_login;
    private LoginModel model;
    private LoginObg loginObg;
    private String name;
    private String paw;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setView();
        setListener();
    }

    private void setListener() {
        model = new LoginModel();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login.setClickable(false);
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        btn_login.setClickable(true);
                    }
                }, 3000);
                name = et_login_name.getText().toString();
                paw = et_login_paw.getText().toString();
                token = App.getToken();
                if(token==null){
                    token = "";
                }
                model.login(name, paw, token,new ICallBack() {
                    public void succeed(Object object) {
                        try {
                            btn_login.setClickable(true);
                            loginObg = (LoginObg) object;
                            Lon log = loginObg.getObj();
                            //获得SharedPreferences对象
                            SharedPreferences preferences = LoginActivity.this.getSharedPreferences("wwj", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("enterprise_id", log.getEnterprise_id());
                            editor.putLong("user_id", log.getUser_id());
                            editor.putLong("dept_id", log.getDept_id());
                            editor.commit();
                            if( loginObg.isSuccess()){
                                Message message =Message.obtain();
                                message.what = 1;
                                handler.sendMessage(message);
                            }else {
                                Message message =Message.obtain();
                                message.what = 2;
                                handler.sendMessage(message);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    public void error(Object object) {
                        btn_login.setClickable(true);
                        Message message =Message.obtain();
                        message.what = 2;
                        handler.sendMessage(message);
                    }
                });
            }
        });
    }

    private void setView() {
        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_paw = (EditText) findViewById(R.id.et_login_paw);
        btn_login = (Button) findViewById(R.id.btn_login);
    }
}

