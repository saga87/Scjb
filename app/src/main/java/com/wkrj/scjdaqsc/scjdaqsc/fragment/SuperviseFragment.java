package com.wkrj.scjdaqsc.scjdaqsc.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.activity.DuChaActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.ExposureActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.HomeTActivity;
import com.wkrj.scjdaqsc.scjdaqsc.activity.MainActivity;

/**
 * Created by fxn on 2017/6/16.
 */

public class SuperviseFragment extends android.support.v4.app.Fragment {
    View view;
    private LinearLayout ll_sup_ajb,ll_sup_jw,ll_sup_dzb,ll_sup_nw,ll_sup_ljxqgzb,ll_sup_jmw,ll_sup_sqk,ll_sup_qdzz,tv_sup_back;
    private TextView tv_sup_home;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_supervise,null);

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
        SharedPreferences preferences = getActivity().getSharedPreferences("wwj", Context.MODE_PRIVATE);
        String enterprise_id = preferences.getString("enterprise_id", "");
        long user_id = preferences.getLong("user_id", 0);
        long dept_id = preferences.getLong("dept_id", 0);
        final String dept = String.valueOf(dept_id);

        ll_sup_ajb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830001")||dept.equals("10000000000002")){
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830001");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_jw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830002")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830002");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_dzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830003")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830003");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_nw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830004")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830004");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_ljxqgzb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830005")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830005");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_jmw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830006")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830006");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_sqk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830007")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830007");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ll_sup_qdzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dept.equals("10000005830008")||dept.equals("10000000000002")) {
                    Intent intent = new Intent(getActivity(), DuChaActivity.class);
                    intent.putExtra("sup", "10000005830008");
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"您的权限不足",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_sup_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                MainActivity.setfinish();
            }
        });
        tv_sup_back.setOnClickListener(new View.OnClickListener() {
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
        ll_sup_ajb = (LinearLayout) view.findViewById(R.id.ll_sup_ajb);
        ll_sup_jw = (LinearLayout) view.findViewById(R.id.ll_sup_jw);
        ll_sup_dzb = (LinearLayout) view.findViewById(R.id.ll_sup_dzb);
        ll_sup_nw = (LinearLayout) view.findViewById(R.id.ll_sup_nv);
        ll_sup_ljxqgzb = (LinearLayout) view.findViewById(R.id.ll_sup_ljxq);
        ll_sup_jmw = (LinearLayout) view.findViewById(R.id.ll_sup_jmw);
        ll_sup_sqk = (LinearLayout) view.findViewById(R.id.ll_sup_sqk);
        ll_sup_qdzz = (LinearLayout) view.findViewById(R.id.ll_sup_qdzz);
        tv_sup_back = (LinearLayout) view.findViewById(R.id.tv_sup_back);

        tv_sup_home = (TextView) view.findViewById(R.id.tv_sup_home);
    }
}
