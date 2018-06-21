package com.wkrj.scjdaqsc.scjdaqsc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.activity.FirmActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.FirmMessageActivity;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.FirmMessageAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.GuangRongAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmList;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmObg;
import com.wkrj.scjdaqsc.scjdaqsc.model.FirmModel;
import com.wkrj.scjdaqsc.scjdaqsc.view.PullListView.PullListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxn on 2017/6/21.
 */

public class FirmMessageFragment extends android.support.v4.app.Fragment {
    private String companyId;
    private LinearLayout ll_firm_fra_back;
    private int page = 1;
    private int pageNum = 20;
    private FirmModel model;
    private View view;
    private PullListView mPullListView;
    private FirmMessageAdapter mAdapter;
    private List<FirmList> firms = new ArrayList<>();

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    mAdapter = new FirmMessageAdapter(getActivity(), firms);
                    mPullListView.setAdapter(mAdapter);
                    mPullListView.performRefresh();

                    mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            FirmList firm = firms.get(position-1);
                            Intent intent = new Intent(getActivity(), FirmMessageActivity.class);
                            intent.putExtra("xixi", (Serializable) firm);
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    mAdapter.addData(firms);
                    mPullListView.getMoreComplete();
                    break;
                case 3:
                    mAdapter.refreshData(firms);
                    mPullListView.refreshComplete();
                    break;
                case 4:
                    Toast.makeText(getActivity(),"数据获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_frim_message,null);

        initViews();
        //获取数据
        getModel();
        return view;
    }
    /**
     * 获取数据
     */
    private void getModel() {
        model = new FirmModel();
        model.firmList(1, pageNum, companyId, new ICallBack() {
            @Override
            public void succeed(Object object) {
                FirmObg bg = (FirmObg) object;
                firms = bg.getRows();
                Message message =Message.obtain();
                message.what = 1;
                handler.sendMessage(message);
            }
            @Override
            public void error(Object object) {
                Message message =Message.obtain();
                message.what = 4;
                handler.sendMessage(message);
            }
        });
    }

    private void initViews() {
        mPullListView = (PullListView) view.findViewById(R.id.pull_listview_firm_message);
        ll_firm_fra_back = (LinearLayout) view.findViewById(R.id.ll_firm_fra_back);

        Bundle bandle = getActivity().getIntent().getExtras();
        companyId = bandle.getString("exp");
        mPullListView.setOnRefreshListener(new PullListView.OnRefreshListener() {

            @Override
            public void onRefresh() {
                page = 1;
                refreshData();
            }
        });
        mPullListView.setOnGetMoreListener(new PullListView.OnGetMoreListener() {

            @Override
            public void onGetMore() {
                page = page + 1;
                loadData();
            }
        });

        ll_firm_fra_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirmActivity.setfinal();
            }
        });
    }
    /**
     * 上拉加载数据
     */
    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.firmList(page, pageNum, companyId, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        FirmObg bg = (FirmObg) object;
                        firms = bg.getRows();
                        Message message = Message.obtain();
                        message.what = 2;
                        handler.sendMessage(message);
                    }
                    @Override
                    public void error(Object object) {
                        Message message = Message.obtain();
                        message.what = 4;
                        handler.sendMessage(message);
                    }
                });
            }
        }, 500);
    }
    /**
     * 下拉刷新数据
     */
    private void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.firmList(page, pageNum, companyId, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        FirmObg bg = (FirmObg) object;
                        firms = bg.getRows();
                        Message message = Message.obtain();
                        message.what = 3;
                        handler.sendMessage(message);
                    }
                    @Override
                    public void error(Object object) {
                        Message message = Message.obtain();
                        message.what = 4;
                        handler.sendMessage(message);
                    }
                });
            }
        }, 2000);
    }
}
