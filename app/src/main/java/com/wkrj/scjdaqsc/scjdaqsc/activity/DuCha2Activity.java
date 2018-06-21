package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.DuChaAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.callback.ICallBack;
import com.wkrj.scjdaqsc.scjdaqsc.entity.Ducha;
import com.wkrj.scjdaqsc.scjdaqsc.entity.DuchaObg;
import com.wkrj.scjdaqsc.scjdaqsc.model.DuchaModel;
import com.wkrj.scjdaqsc.scjdaqsc.view.PullListView.PullListView;

import java.io.Serializable;
import java.util.List;

public class DuCha2Activity extends BaseActivity {
    private PullListView mPullListView;
    private LinearLayout ll_du_cha2_back;
    private int page = 1;
    private int pageNum = 20;
    private DuchaModel model;
    private DuChaAdapter mAdapter;
    private String companyId,name;
    private long s1;
    private int d;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    mAdapter = new DuChaAdapter(DuCha2Activity.this, dus);
                    mPullListView.setAdapter(mAdapter);
                    mPullListView.performRefresh();

                    mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Ducha du = dus.get(position - 1);
                            Intent intent = new Intent(DuCha2Activity.this,TzXqActivity.class);
                            intent.putExtra("lj", (Serializable) du);
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    mAdapter.addData(dus);
                    mPullListView.getMoreComplete();
                    break;
                case 3:
                    mAdapter.refreshData(dus);
                    mPullListView.refreshComplete();
                    break;
                case 4:
                    Toast.makeText(DuCha2Activity.this,"数据获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private List<Ducha> dus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_cha2);
        mPullListView = (PullListView) findViewById(R.id.listview_du_cha2);
        ll_du_cha2_back = (LinearLayout) findViewById(R.id.ll_du_cha2_back);

        try {
            model = new DuchaModel();
            Bundle bandle = getIntent().getExtras();
            companyId = bandle.getString("companyId");
            name = bandle.getString("name");
            s1 = bandle.getLong("s1");
            d = bandle.getInt("d");
        }catch (Exception e){
            e.printStackTrace();
        }
        getModel();
        setListener();
    }
    /**
     * 获取数据
     */
    private void getModel() {
        model = new DuchaModel();
        model.duchaQueryList(page, pageNum, companyId,name,s1,d ,new ICallBack() {
            @Override
            public void succeed(Object object) {
                DuchaObg dulist = (DuchaObg) object;
                dus= dulist.getRows();
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
    private void setListener() {
        ll_du_cha2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                model.duchaQueryList(page, pageNum, companyId,name,s1,d ,new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        DuchaObg dulist = (DuchaObg) object;
                        dus= dulist.getRows();
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
                model.duchaQueryList(page, pageNum, companyId,name,s1,d ,new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        DuchaObg dulist = (DuchaObg) object;
                        dus= dulist.getRows();
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
