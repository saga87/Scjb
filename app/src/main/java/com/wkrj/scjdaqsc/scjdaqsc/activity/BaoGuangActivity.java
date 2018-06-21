package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Notice;

public class BaoGuangActivity extends BaseActivity {
    private TextView tv_baoguang_title,tv_baoguang_time,tv_baoguang_contact;
    private BaoGuang bg;
    private LinearLayout ll_bao_guang_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_guang);
        setView();
        setListener();
    }
    private void setListener() {
        String str = bg.getBgt_content();
        String s = str.substring(3, str.length() - 4);

        tv_baoguang_title.setText(bg.getBgt_inputuser());
        tv_baoguang_time.setText(bg.getBgt_checktime());
        tv_baoguang_contact.setText(s);

        ll_bao_guang_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setView() {
        try {
            Bundle bundle = getIntent().getExtras();
            bg = (BaoGuang) bundle.getSerializable("haha");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv_baoguang_title = (TextView) findViewById(R.id.tv_baoguang_title);
        tv_baoguang_time = (TextView) findViewById(R.id.tv_baoguang_time);
        tv_baoguang_contact = (TextView) findViewById(R.id.tv_baoguang_contact);
        ll_bao_guang_back = (LinearLayout) findViewById(R.id.ll_bao_guang_back);
    }
}
