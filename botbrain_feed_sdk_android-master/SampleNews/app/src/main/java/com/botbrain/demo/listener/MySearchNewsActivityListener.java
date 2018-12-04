package com.botbrain.demo.listener;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.botbrain.demo.R;

import ai.botbrain.ttcloud.api.SearchNewsActivityListener;
import ai.botbrain.ttcloud.api.SearchNewsView;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/30.
 */

public class MySearchNewsActivityListener implements SearchNewsActivityListener {
    private static final String TAG = MyReadNewsActivityListener.class.getSimpleName();

    String[] str = new String[]{
            "设置导航栏返回图标",
            "设置导航栏背景颜色",
    };

    @Override
    public void getSearchNewsView(Activity activity, SearchNewsView view) {
        /** 这里定义搜索页面样式 **/
        //view.setToolBarNavigationIcon(R.drawable.ic_share_black_24dp);
        /** 设置导航栏背景 **/
        //view.setToolBarBackgroundColor(activity.getResources().getColor(R.color.colorPrimary));
    }

    /***********************************************/
    @Override
    public void onCreate(Activity activity) {
        Log.i(TAG, "onCreate()");
    }

    @Override
    public void onStart(Activity activity) {
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume(Activity activity) {
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause(Activity activity) {
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onStop(Activity activity) {
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroy(Activity activity) {
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onMultipleClick(final Activity activity, final SearchNewsView view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    //设置导航栏返回图标
                    case 0:
                        view.setToolBarNavigationIcon(R.drawable.ic_time_to_leave_black_24dp);
                        break;
                    // 设置导航栏背景颜色
                    case 1:
                        view.setToolBarBackgroundColor(activity.getResources().getColor(R.color.color_e19797));
                        break;
                }
            }
        });
        builder.show();
    }
}
