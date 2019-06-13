package com.example.study.android.androidscreening.ui;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.study.android.androidscreening.R;


public class ScreeningActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FilterSpecAttrView mFilterSpecAttrView;
    private TextView mFrameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);
        initView();
    }


    // 初始化元素
    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mFrameTv = (TextView) findViewById(R.id.screenTv);
        //设置第一屏内容
//        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);侧滑不随滑动而滑动
        mFilterSpecAttrView = (FilterSpecAttrView) findViewById(R.id.filterSpecAttrView);
        mFrameTv.setOnClickListener(new OnClickListenerWrapper() {
            @Override
            protected void onSingleClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }
        });
        mFilterSpecAttrView.setCloseMenuCallBack(new FilterSpecAttrView.CloseMenuCallBack() {
            // 重写内部方法
            @Override
            public void setupCloseMean() {
                mDrawerLayout.closeDrawer(GravityCompat.END);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
