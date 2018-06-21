package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.TzXqAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Ducha;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Filefj;
import com.wkrj.scjdaqsc.scjdaqsc.photo.PreviewImage;
import com.wkrj.scjdaqsc.scjdaqsc.photo.model.ImageBDInfo;
import com.wkrj.scjdaqsc.scjdaqsc.photo.model.ImageInfo;
import com.wkrj.scjdaqsc.scjdaqsc.util.UrlUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TzXqActivity extends BaseActivity {
    private TextView tv_tz_jcsj,tv_tz_qync,tv_tz_address,tv_tz_fzr,tv_tz_lxdh,tv_tz_czwtyh,tv_tz_zgcs,tv_tz_fcsj,tv_tz_fcqk,tv_tz_jcdw;
    private TextView tv_tz_beizhu;
    private LinearLayout ll_tz_xq_back;
    private ListView lfs_listview_fujian;
    ArrayList<ImageInfo> data = new ArrayList<ImageInfo>();
    ImageBDInfo bdInfo = new ImageBDInfo();
    ImageInfo imageInfo = new ImageInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tz_xq);
        setView();
        setModel();
    }

    private void setModel() {
        Ducha du  = null;
        try {
            Bundle bundle = getIntent().getExtras();
            du = (Ducha) bundle.getSerializable("lj");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv_tz_jcsj.setText(du.getTz_checktime());
        tv_tz_qync.setText(du.getTz_checkqyname());
        tv_tz_address.setText(du.getTz_checkaddress());
        tv_tz_fzr.setText(du.getTz_dutyuser());
        tv_tz_lxdh.setText(du.getTz_tel());
        tv_tz_czwtyh.setText(du.getTz_exitproblem());
        tv_tz_zgcs.setText(du.getTz_zgcs());
        tv_tz_fcsj.setText(du.getTz_fctime());
        tv_tz_fcqk.setText(du.getTz_fcqk());
        tv_tz_jcdw.setText(du.getTz_jcdw());
        tv_tz_beizhu.setText(du.getTz_other());

        ll_tz_xq_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final List<Filefj> files = du.getTz_file();
        TzXqAdapter adapter = new TzXqAdapter(this,files);
        lfs_listview_fujian.setAdapter(adapter);
        lfs_listview_fujian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String f = files.get(position).getPdfname();
                if (f.contains(".pdf")){
                    Intent intent = new Intent(TzXqActivity.this,PdfActivity.class);
                    intent.putExtra("file",f); 
                    startActivity(intent);
                }else {
                    imageInfo.width = 1280;
                    imageInfo.height = 720;
                    imageInfo.url = UrlUtils.url+f;
                    data.add(imageInfo);
                    bdInfo.x = 260;
                    bdInfo.y = 152;
                    bdInfo.width = 200;
                    bdInfo.height = 200;
                    Intent intent = new Intent(TzXqActivity.this, PreviewImage.class);
                    intent.putExtra("data", (Serializable) data);
                    intent.putExtra("bdinfo",bdInfo);
                    intent.putExtra("index",0);
                    startActivity(intent);
                }
            }
        });
    }

    private void setView() {
        ll_tz_xq_back = (LinearLayout) findViewById(R.id.ll_tz_xq_back);
        tv_tz_jcsj = (TextView) findViewById(R.id.tv_tz_jcsj);
        tv_tz_qync = (TextView) findViewById(R.id.tv_tz_qync);
        tv_tz_address = (TextView) findViewById(R.id.tv_tz_address);
        tv_tz_fzr = (TextView) findViewById(R.id.tv_tz_fzr);
        tv_tz_lxdh = (TextView) findViewById(R.id.tv_tz_lxdh);
        tv_tz_czwtyh = (TextView) findViewById(R.id.tv_tz_czwtyh);
        tv_tz_zgcs = (TextView) findViewById(R.id.tv_tz_zgcs);
        tv_tz_fcsj = (TextView) findViewById(R.id.tv_tz_fcsj);
        tv_tz_fcqk = (TextView) findViewById(R.id.tv_tz_fcqk);
        tv_tz_jcdw = (TextView) findViewById(R.id.tv_tz_jcdw);
        tv_tz_beizhu = (TextView) findViewById(R.id.tv_tz_beizhu);
        lfs_listview_fujian = (ListView) findViewById(R.id.lfs_listview_fujian);
    }
}
