package com.wkrj.scjdaqsc.scjdaqsc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.activity.ExposureActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeTActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.MainActivity;

/**
 * Created by fxn on 2017/6/16.
 */

public class ExposureFragment extends android.support.v4.app.Fragment {
    private View view;
    private LinearLayout ll_exp_anb,ll_exp_jw,ll_exp_dzb,ll_exp_nw,ll_exp_ljxqgzb,ll_exp_jmw,ll_exp_sqk,ll_exp_qdzz,tv_exp_back;
    private TextView tv_exp_home;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exposure,null);
        //初始化控件
        setView();
        //控件监听
        setListener();


        return view;
    }
    /**
     * 控件监听
     */
    private void setListener() {
        ll_exp_anb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830001");
                startActivity(intent);
            }
        });
        ll_exp_jw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830002");
                startActivity(intent);
            }
        });
        ll_exp_dzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830003");
                startActivity(intent);
            }
        });
        ll_exp_nw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830004");
                startActivity(intent);
            }
        });
        ll_exp_ljxqgzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830005");
                startActivity(intent);
            }
        });
        ll_exp_jmw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830006");
                startActivity(intent);
            }
        });
        ll_exp_sqk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830007");
                startActivity(intent);
            }
        });
        ll_exp_qdzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExposureActivity.class);
                intent.putExtra("exp","10000005830008");
                startActivity(intent);
            }
        });
        tv_exp_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                MainActivity.setfinish();
            }
        });
        tv_exp_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeTActivity.class);
                startActivity(intent);
                MainActivity.setfinish();
            }
        });
    }
    /**
     * 初始化控件
     */
    private void setView() {
        ll_exp_anb = (LinearLayout) view.findViewById(R.id.ll_exp_anb);
        ll_exp_jw = (LinearLayout) view.findViewById(R.id.ll_exp_jw);
        ll_exp_dzb = (LinearLayout) view.findViewById(R.id.ll_exp_dzb);
        ll_exp_nw = (LinearLayout) view.findViewById(R.id.ll_exp_nw);
        ll_exp_ljxqgzb = (LinearLayout) view.findViewById(R.id.ll_exp_ljxqgzb);
        ll_exp_jmw = (LinearLayout) view.findViewById(R.id.ll_exp_jmw);
        ll_exp_sqk = (LinearLayout) view.findViewById(R.id.ll_exp_sqk);
        ll_exp_qdzz = (LinearLayout) view.findViewById(R.id.ll_exp_qdzz);

        tv_exp_home = (TextView) view.findViewById(R.id.tv_exp_home);
        tv_exp_back = (LinearLayout) view.findViewById(R.id.tv_exp_back);
    }
}
