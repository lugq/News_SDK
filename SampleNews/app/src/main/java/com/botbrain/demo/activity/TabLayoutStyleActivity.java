package com.botbrain.demo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.botbrain.demo.App;
import com.botbrain.demo.R;
import com.botbrain.demo.listener.MyNewsFragmentListener;

import ai.botbrain.ttcloud.api.BotBrain;
import ai.botbrain.ttcloud.sdk.view.fragment.IndexFragment;

/**
 * 开发者自行设置广告.
 */
public class TabLayoutStyleActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    IndexFragment mNewsIndexFragment;

    MyNewsFragmentListener myNewsFragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_style);
        myNewsFragmentListener = ((App)getApplication()).getMyNewsFragmentListener();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_style_tablayout);
        toolbar.setOnMenuItemClickListener(this);

        mNewsIndexFragment = BotBrain.newInstance().getNewsFragment();

        if (!mNewsIndexFragment.isAdded()) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, mNewsIndexFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            /** 隐藏滑动标签控件 **/
            case R.id.item_hide:
                myNewsFragmentListener.mNewsView.hideTabLayout();
                break;
            /** 修改字体大小 */
            case R.id.item_size:
                myNewsFragmentListener.mNewsView.setTabTextSize(10, 20);;
                break;
            /**设置颜色**/
            case R.id.item_color:
                myNewsFragmentListener.mNewsView.setTabTextColors(getResources().getColor(R.color.color_normal),
                        getResources().getColor(R.color.color_select));
                break;
            /**设置指示器高度***/
            case R.id.item_indicator_height:
                myNewsFragmentListener.mNewsView.setTabIndicatorHeight(0);;
                break;
            /**设置滑动标签布局高度***/
            case R.id.item_layout_height:
                myNewsFragmentListener.mNewsView.setTabLayoutHeight(50);
                break;
            /**设置背景颜色**/
            case R.id.item_bg_color:
                myNewsFragmentListener.mNewsView.setTabBackground(getResources().getColor(R.color.color_e19797));
                break;
            /**设置间隔**/
            case R.id.item_space:
                myNewsFragmentListener.mNewsView.setTabSpace(10);
                break;
            /**设置指示器颜色**/
            case R.id.item_indicator_color:
                myNewsFragmentListener.mNewsView.setTabIndicatorColor(getResources().getColor(R.color.color_select));
                break;

        }
        return false;
    }
}
