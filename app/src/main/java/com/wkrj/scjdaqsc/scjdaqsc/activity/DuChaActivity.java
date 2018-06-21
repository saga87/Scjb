package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class DuChaActivity extends BaseActivity {
    private PullListView mPullListView;
    private LinearLayout ll_du_cha_back;
    private DuchaModel model;
    private String companyId;
    private int page = 1;
    private int pageNum = 20;
    private DuChaAdapter mAdapter;
    private List<Ducha> dus;
    private Button btn_du_cha_tb,btn_du_cha_query;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    mAdapter = new DuChaAdapter(DuChaActivity.this, dus);
                    mPullListView.setAdapter(mAdapter);
                    mPullListView.performRefresh();

                    mPullListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Ducha du = dus.get(position - 1);
                            Intent intent = new Intent(DuChaActivity.this,TzXqActivity.class);
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
                    Toast.makeText(DuChaActivity.this,"数据获取失败",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_cha);

        initViews();
        //获取数据
        getModel();
        setListener();
    }

    private void setListener() {
        btn_du_cha_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuChaActivity.this,TZqueryActivity.class);
                intent.putExtra("ll",companyId);
                startActivity(intent);
            }
        });
        btn_du_cha_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuChaActivity.this,TZaddActivity.class);
                intent.putExtra("ll",companyId);
                startActivity(intent);
            }
        });
    }

    /**
     * 获取数据
     */
    private void getModel() {
        model = new DuchaModel();
        model.duchaList(1, pageNum, companyId, new ICallBack() {
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

    private void initViews() {
        mPullListView = (PullListView) findViewById(R.id.listview_du_cha);
        btn_du_cha_tb = (Button) findViewById(R.id.btn_du_cha_tb);
        btn_du_cha_query = (Button) findViewById(R.id.btn_du_cha_query);
        ll_du_cha_back = (LinearLayout) findViewById(R.id.ll_du_cha_back);

        try {
            Bundle bandle = getIntent().getExtras();
            companyId = bandle.getString("sup");
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
        ll_du_cha_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                model.duchaList(page, pageNum, companyId, new ICallBack() {
                    @Override
                    public void succeed(Object object) {
                        DuchaObg  dulist = (DuchaObg) object;
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
                model.duchaList(page, pageNum, companyId, new ICallBack() {
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
