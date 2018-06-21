package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.FirmMessageFragment;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.FirmQueryFragment;

import java.util.ArrayList;
import java.util.List;

public class FirmActivity extends BaseActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private List<Fragment> fragments;
    private static FirmActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firm);
        activity = this;
        //初始化控件
        setView();
        //设置listener;
        setOnlistener();
        //设置Adapter
        setAdapter();
    }
    public static void setfinal(){
        activity.finish();
    }
    private void setAdapter() {
        fragments = new ArrayList<>();
        fragments.add(new FirmMessageFragment());
        fragments.add(new FirmQueryFragment());

        FirmActivity.MyAdapter adapter = new FirmActivity.MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private class  MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
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
                    case R.id.rb_01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_02:
                        viewPager.setCurrentItem(1);
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
                        break;
                    case 1:
                        rb_2.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setView() {
        viewPager= (ViewPager) findViewById(R.id.viewPager2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        rb_1 = (RadioButton) findViewById(R.id.rb_01);
        rb_2 = (RadioButton) findViewById(R.id.rb_02);
    }

}
