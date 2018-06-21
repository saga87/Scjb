package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.GuangRongFragment;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.TongBaoFragment;

import java.util.ArrayList;
import java.util.List;

public class ExposureActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_1,rb_2;
    private TextView tv1,tv2;
    private LinearLayout ll_exp_back;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exposure);

        //初始化控件
        setView();
        //设置listener;
        setOnlistener();
        //设置Adapter
        setAdapter();

        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.INVISIBLE);
    }

    private void setAdapter() {
        fragments = new ArrayList<>();
        fragments.add(new GuangRongFragment());
        fragments.add(new TongBaoFragment());

        ExposureActivity.ExposireAdapter adapter = new ExposureActivity.ExposireAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private class  ExposireAdapter extends FragmentPagerAdapter {

        public ExposireAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    private void setOnlistener() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_bgt_geb:
                        viewPager.setCurrentItem(0);
                        tv1.setVisibility(View.VISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rb_bgt_tb:
                        viewPager.setCurrentItem(1);
                        tv2.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rb_1.setChecked(true);
                        tv1.setVisibility(View.VISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        tv2.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.INVISIBLE);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        ll_exp_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setView() {
        viewPager= (ViewPager) findViewById(R.id.mViewpage1);
        radioGroup = (RadioGroup) findViewById(R.id.mRadioGroup1);
        rb_1 = (RadioButton) findViewById(R.id.rb_bgt_geb);
        rb_2 = (RadioButton) findViewById(R.id.rb_bgt_tb);
        ll_exp_back = (LinearLayout) findViewById(R.id.ll_exp_back);
        tv1 = (TextView) findViewById(R.id.tv_exp_1);
        tv2 = (TextView) findViewById(R.id.tv_exp_2);
    }
}
