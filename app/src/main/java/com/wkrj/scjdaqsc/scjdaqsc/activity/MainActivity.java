package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.ExposureFragment;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.InformFragment;
import com.wkrj.scjdaqsc.scjdaqsc.fragment.SuperviseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private List<Fragment> fragments;
    private static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        //初始化控件
        setView();
        //设置listener;
        setOnlistener();
        //设置Adapter
        setAdapter();
        //获取intent的值
        getBundle();
    }
    public static void setfinish(){
        activity.finish();
    }
    /**
     *获取intent的值
     */
    private void getBundle() {
        try {
            Bundle bundle = getIntent().getExtras();
            String s = bundle.getString("page");
            if (s.equals("1")) {
                viewPager.setCurrentItem(0);
            } else if (s.equals("2")) {
                viewPager.setCurrentItem(1);
            } else if (s.equals("3")) {
                viewPager.setCurrentItem(2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            Intent intent = new Intent(this, HomeTActivity.class);
            startActivity(intent);
            MainActivity.setfinish();
        }
        return false;
    }
    private void setAdapter() {
        fragments = new ArrayList<>();
        fragments.add(new InformFragment());
        fragments.add(new ExposureFragment());
        fragments.add(new SuperviseFragment());

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
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
                    case R.id.rb_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        viewPager.setCurrentItem(2);
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
                    case 2:
                        rb_3.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setView() {
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
    }

}
