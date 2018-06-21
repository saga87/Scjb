package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Notice;

public class NoticeActivity extends BaseActivity {
    private TextView tv_notice_title,tv_notice_time,tv_notice_contact;
    private LinearLayout ll_notice_back;
    private Notice bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        setView();
        setListener();
    }

    private void setListener() {
        tv_notice_title.setText(bg.getNotice_title());
        tv_notice_time.setText(bg.getNotice_inputtime());
        tv_notice_contact.setText(bg.getNotice_content());

        ll_notice_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setView() {
        try {
            Bundle bundle = getIntent().getExtras();
            bg = (Notice) bundle.getSerializable("wuyu");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv_notice_title = (TextView) findViewById(R.id.tv_notice_title);
        tv_notice_time = (TextView) findViewById(R.id.tv_notice_time);
        tv_notice_contact = (TextView) findViewById(R.id.tv_notice_contact);
        ll_notice_back = (LinearLayout) findViewById(R.id.ll_notice_back);
    }
}
