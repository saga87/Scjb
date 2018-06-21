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
import android.widget.TextView;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeTActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.MainActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.NoticeActivity;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.GuangRongAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.NoticeAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BGlist;
import com.wkrj.scjdaqsc.scjdaqsc.entity.BaoGuang;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Notice;
import com.wkrj.scjdaqsc.scjdaqsc.entity.NoticeList;
import com.wkrj.scjdaqsc.scjdaqsc.model.BaoGuangModel;
import com.wkrj.scjdaqsc.scjdaqsc.model.NoticeModel;
import com.wkrj.scjdaqsc.scjdaqsc.view.PullListView.PullListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxn on 2017/6/16.
 */

public class InformFragment extends android.support.v4.app.Fragment {
    private View view;
    private PullListView mPullListView;
    private NoticeAdapter mAdapter;
    private int page = 1;
    private int pageNum = 20;
    private List<Notice> bgs = new ArrayList<>();
    private NoticeModel model;
    private LinearLayout ll_inform_back;
    private TextView tv_inform_home;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    mAdapter = new NoticeAdapter(getActivity(), bgs);
                    mPullListView.setAdapter(mAdapter);
                    mPullListView.performRefresh();

                    mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Notice bg = bgs.get(position-1);
                            Intent intent = new Intent(getActivity(), NoticeActivity.class);
                            intent.putExtra("wuyu",(Serializable) bg);
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
                    Toast.makeText(getContext(),"数据获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inform,null);

        initViews();
        //获取数据
        getModel();

        return view;
    }

    /**
     * 获取数据
     */
    private void getModel() {
        model = new NoticeModel();
        model.getNoticeList(1, pageNum, new ICallBack() {
            @Override
            public void succeed(Object object) {
                NoticeList noticeList = (NoticeList) object;
                bgs = noticeList.getRows();
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
        mPullListView = (PullListView) view.findViewById(R.id.pull_listview_inform);
        ll_inform_back = (LinearLayout) view.findViewById(R.id.ll_inform_back);
        tv_inform_home = (TextView) view.findViewById(R.id.tv_inform_home);

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

        tv_inform_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                MainActivity.setfinish();
            }
        });
        ll_inform_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeTActivity.class);
                startActivity(intent);
                MainActivity.setfinish();
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
                model.getNoticeList(page, pageNum, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        NoticeList noticeList = (NoticeList) object;
                        bgs = noticeList.getRows();
                        Message message = Message.obtain();
                        message.what = 2;
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
        }, 500);
    }
    /**
     * 下拉刷新数据
     */
    private void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                model.getNoticeList(page, pageNum, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        NoticeList noticeList = (NoticeList) object;
                        bgs = noticeList.getRows();
                        Message message = Message.obtain();
                        message.what = 3;
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
        }, 2000);
    }
}
