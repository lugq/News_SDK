package com.botbrain.demo.listener;

import android.app.Activity;
import android.util.Log;

import com.botbrain.demo.R;
import com.botbrain.demo.adapter.MyCustomHolder;

import java.util.List;

import ai.botbrain.smartrefresh.layout.api.RefreshLayout;
import ai.botbrain.ttcloud.api.NewsFragmentListener;
import ai.botbrain.ttcloud.api.NewsView;
import ai.botbrain.ttcloud.sdk.domain.Article;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/31.
 */

public class MyNewsFragmentListener implements NewsFragmentListener {

    private static final String TAG = MyNewsFragmentListener.class.getSimpleName();

    public NewsView mNewsView;

    @Override
    public void getNewsView(Activity activity, NewsView view) {
        mNewsView = view;
        // 添加广告视图
        view.setCustomHolder(new MyCustomHolder());
        view.setTabTextSelectColor(activity.getResources().getColor(R.color.tsd_color_187cdc));
    }

    @Override
    public void onCustomItemClick(int position, Object object) {
        Log.i(TAG, "click position:" + position + ":object" + object.toString());
    }

    @Override
    public void onRefresh(List<Article> datas) {
        //自由添加广告数据
        /*
        if (position == 1) {
            // 模拟请求接口的延迟
            SystemClock.sleep(3000);
            RecommendNewsEntity.Items data = new RecommendNewsEntity.Items();
            data.type = "customType";
            data.customContent = "可以自由传入要渲染的数据";
            datas.add(0, data);
        }
        */

    }

    @Override
    public void getRefreshLayout(RefreshLayout refreshLayout) {
        // 自定义刷新Style
        /*
        ClassicsHeader header = new ClassicsHeader(TsdContextHolder.getContext());
        header.setEnableLastTime(false);
        ClassicsHeader.REFRESH_HEADER_REFRESHING = "啦啦啦...";
        refreshLayout.setRefreshHeader(header);
        */
    }
}
