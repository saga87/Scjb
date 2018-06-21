package com.wkrj.scjdaqsc.scjdaqsc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.activity.FirmActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.FirmMessageActivity;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.FirmMessageAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmList;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmObg;
import com.wkrj.scjdaqsc.scjdaqsc.model.FirmModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxn on 2017/6/21.
 */

public class FirmQueryFragment extends android.support.v4.app.Fragment {
    private View view;
    private EditText et_firm_name;
    private LinearLayout ll_firm_query_back;
    private Spinner sp_firm_type;
    private Button btn_firm_seek;
    private ListView list_firm_query;
    private String companyId;
    private FirmModel model;
    private String enterpriseState;
    private List<FirmList> firms;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_frim_query,null);

        //初始化控件
        setView();
        //设置Adapter
        setAdapter();
        //设置listener;
        setOnlistener();
        return view;
    }

    private FirmMessageAdapter adapter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    adapter = new FirmMessageAdapter(getActivity(),firms);
                    list_firm_query.setAdapter(adapter);

                    list_firm_query.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            FirmList firm = firms.get(position);
                            Intent intent = new Intent(getActivity(), FirmMessageActivity.class);
                            intent.putExtra("xixi", (Serializable) firm);
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    if(adapter!=null){
                        adapter.refreshData(firms);
                    }
                    Toast.makeText(getActivity(),"数据获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void setAdapter() {
        List<String> str1 = new ArrayList<String>();
        str1.add("正常生产");
        str1.add("关闭生产");
        ArrayAdapter<String> arr_adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, str1);
        //设置样式
        arr_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_firm_type.setAdapter(arr_adapter1);
    }
    private void setOnlistener() {
        model = new FirmModel();

        btn_firm_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et_firm_name.getText().toString();
                String s = sp_firm_type.getSelectedItem().toString();
                if (str.equals("")){
                    Toast.makeText(getActivity(),"数据不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(s.equals("正常生产")){
                    enterpriseState = "10000006050008";
                }else {
                    enterpriseState = "10000006050009";
                }
                model.firmQueryList(1, 100, companyId, str, enterpriseState, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        FirmObg bg = (FirmObg) object;
                        firms = bg.getRows();
                        if(firms.size()==0){
                            Message message =Message.obtain();
                            message.what = 2;
                            handler.sendMessage(message);
                            return;
                        }
                        Message message =Message.obtain();
                        message.what = 1;
                        handler.sendMessage(message);
                    }
                    @Override
                    public void error(Object object) {
                        Message message =Message.obtain();
                        message.what = 2;
                        handler.sendMessage(message);
                    }
                });

            }
        });
        ll_firm_query_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirmActivity.setfinal();
            }
        });
    }

    private void setView() {
        et_firm_name = (EditText) view.findViewById(R.id.et_firm_name);
        sp_firm_type = (Spinner) view.findViewById(R.id.sp_firm_type);
        btn_firm_seek = (Button) view.findViewById(R.id.btn_firm_seek);
        list_firm_query = (ListView) view.findViewById(R.id.list_firm_query);
        ll_firm_query_back = (LinearLayout) view.findViewById(R.id.ll_firm_query_back);

        Bundle bandle = getActivity().getIntent().getExtras();
        companyId = bandle.getString("exp");
    }
}
