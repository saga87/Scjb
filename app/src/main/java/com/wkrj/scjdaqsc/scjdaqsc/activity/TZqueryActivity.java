package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmType;
import com.wkrj.scjdaqsc.scjdaqsc.model.DuchaModel;
import java.util.ArrayList;
import java.util.List;

public class TZqueryActivity extends BaseActivity {
    private Button btn_tz_query;
    private LinearLayout ll_tzquery_back;
    private EditText ed_tz_name;
    private Spinner sp_tz_type,sp_tz_qingkong;
    private  ArrayList<FirmType> types;
    List<String> str1 = new ArrayList<String>();
    private DuchaModel model;
    private String companyId;
    private long s1;
    private int d;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ArrayAdapter<String> arr_adapter1 = new ArrayAdapter<String>(TZqueryActivity.this, android.R.layout.simple_spinner_dropdown_item, str1);
                    //设置样式
                    arr_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_tz_type.setAdapter(arr_adapter1);

                    sp_tz_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            s1 = types.get(position).getType_id();
                        }
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tzquery);
        setView();
        setAdapter();
        setListener();
    }

    private void setAdapter() {
        model = new DuchaModel();
        model.firmType(new ICallBack() {
            @Override
            public void succeed(Object object) {
                types = (ArrayList<FirmType>) object;
                for (int i=0;i<types.size();i++){
                    str1.add(types.get(i).getType_name());
                }
                Message message =Message.obtain();
                message.what = 1;
                handler.sendMessage(message);
            }
            public void error(Object object) {
            }
        });
        List<String> str = new ArrayList<String>();
        str.add("有隐患");
        str.add("无隐患");
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, str);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tz_qingkong.setAdapter(arr_adapter);
    }

    private void setListener() {
        btn_tz_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_tz_name.getText().toString();
                if (name.equals("")){
                    Toast.makeText(TZqueryActivity.this,"数据不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String s2 = sp_tz_qingkong.getSelectedItem().toString();
                if(s2.equals("有隐患")){
                    d = 1;
                }else {
                    d = 0;
                }
                Intent intent = new Intent(TZqueryActivity.this,DuCha2Activity.class);
                intent.putExtra("companyId",companyId);
                intent.putExtra("name",name);
                intent.putExtra("s1",s1);
                intent.putExtra("d",d);
                startActivity(intent);
            }
        });
        ll_tzquery_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setView() {
        btn_tz_query = (Button) findViewById(R.id.btn_tz_query);
        ed_tz_name = (EditText) findViewById(R.id.ed_tz_name);
        sp_tz_type = (Spinner) findViewById(R.id.sp_tz_type);
        sp_tz_qingkong = (Spinner) findViewById(R.id.sp_tz_qingkong);
        ll_tzquery_back = (LinearLayout) findViewById(R.id.ll_tzquery_back);

        try {
            Bundle bandle = getIntent().getExtras();
            companyId = bandle.getString("ll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
