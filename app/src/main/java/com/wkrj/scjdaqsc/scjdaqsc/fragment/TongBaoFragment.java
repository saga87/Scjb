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
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.activity.BaoGuangActivity;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.TongBaoAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.model.BaoGuangModel;
import com.wkrj.scjdaqsc.scjdaqsc.view.PullListView.PullListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxn on 2017/6/17.
 */

public class TongBaoFragment extends android.support.v4.app.Fragment {
    private View view;
    private PullListView mPullListView;
    private TongBaoAdapter mAdapter;
    private int page = 1;
    private int pageNum = 20;
    private List<BaoGuang> bgs = new ArrayList<>();
    private BaoGuangModel model;
    private String companyId;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    mAdapter = new TongBaoAdapter(getActivity(), bgs);
                    mPullListView.setAdapter(mAdapter);
                    mPullListView.performRefresh();

                    mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            BaoGuang bg = bgs.get(position - 1);
                            Intent intent = new Intent(getActivity(), BaoGuangActivity.class);
                            intent.putExtra("haha",(Serializable) bg);
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    mAdapter.addData(bgs);
                    mPullListView.getMoreComplete();
                    break;
                case 3:
                    mAdapter.refreshData(bgs);
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
        view = inflater.inflate(R.layout.fragment_tongbao,null);

        initViews();
        //获取数据
        getModel();
        return view;
    }
    /**
     * 获取数据
     */
    private void getModel() {
        model = new BaoGuangModel();
        model.baoGuangList(1, pageNum, companyId, "10000005450049", new ICallBack() {
            @Override
            public void succeed(Object object) {
                BGlist bg = (BGlist) object;
                bgs = bg.getRows();
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
        mPullListView = (PullListView) view.findViewById(R.id.pull_listview_tb);

        try {
            Bundle bandle = getActivity().getIntent().getExtras();
            companyId = bandle.getString("exp");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }

    /**
     * 上拉加载数据
     */
    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.baoGuangList(page, pageNum, companyId, "10000005450049", new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        BGlist bg = (BGlist) object;
                        bgs = bg.getRows();
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
        }, 2000);
    }
    /**
     * 下拉刷新数据
     */
    private void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.baoGuangList(page, pageNum, companyId, "10000005450049", new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        BGlist bg = (BGlist) object;
                        bgs = bg.getRows();
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
        }, 500);
    }
}
