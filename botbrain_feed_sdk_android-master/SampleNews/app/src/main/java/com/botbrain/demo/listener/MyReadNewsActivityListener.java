package com.botbrain.demo.listener;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.botbrain.demo.R;

import ai.botbrain.ttcloud.api.BotBrain;
import ai.botbrain.ttcloud.api.ReadNewsActivityListener;
import ai.botbrain.ttcloud.api.ReadNewsView;
import ai.botbrain.ttcloud.sdk.domain.Article;
import ai.botbrain.ttcloud.sdk.util.ContextHolder;
import ai.botbrain.ttcloud.sdk.util.GsonUtil;
import ai.botbrain.ttcloud.sdk.util.ToastUtil;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/27.
 */

public class MyReadNewsActivityListener implements ReadNewsActivityListener {

    private static final String mAvatar = "http://photocdn.sohu.com/20160218/mp59391866_1455765846844_6.jpeg";
    private static final String mNickName = "周星星";
    private static final String mUserId = "ZhouXC";

    private static final String TAG = MyReadNewsActivityListener.class.getSimpleName();

    private Activity mActivity;

    String[] str = new String[]{
            "设置导航栏背景颜色",
            "设置导航栏返回图标",
            "设置导航栏右侧菜单",
            "设置导航栏标题颜色",
            "隐藏底部评论框",
            "设置分享icon",
            "设置点赞的icon",
            "隐藏点赞",
    };

    @Override
    public void getReadNewsView(Activity activity, ReadNewsView view) {
        mActivity = activity;
        // 隐藏评论模块
        //view.hideCommentFunction();
    }

    @Override
    public void onClickShare(Article article) {
        showMessage(GsonUtil.GsonString(article));
    }

    @Override
    public void onClickLike(Article article) {
    }

    @Override
    public void onComment(Article article) {
    }

    @Override
    public void onCollect(Article article) {
    }

    @Override
    public void onClickMore(Article article) {
        showMessage(GsonUtil.GsonString(article));
    }

    /********************************* 生命周期回调 ************************************/
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onMultipleClick(final Activity activity, final ReadNewsView view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        view.setToolBarBackgroundColor(activity.getResources().getColor(R.color.color_e19797));
                        break;
                    // 设置导航栏返回图标
                    case 1:
                        view.setToolBarNavigationIcon(R.drawable.ic_time_to_leave_black_24dp);
                        break;
                    //设置导航栏右侧菜单
                    case 2:
                        view.setToolBarInflateMenu(R.menu.menu_tip);
                        break;
                    //设置导航栏标题颜色
                    case 3:
                        view.setToolBarTitleColor(activity.getResources().getColor(R.color.colorPrimary));
                        break;
                    case 4:
                        //隐藏底部评论框
                        view.hideComment();
                        break;
                    //设置分享ICON
                    case 5:
                        view.setShareImageRes(R.drawable.ic_share_black_24dp);
                        break;
                    // 设置点赞的icon
                    case 6:
                        view.setLikeImageRes(R.drawable.ic_thumb_up_black_24dp, R.drawable.ic_thumb_up_red_24dp);
                        break;
                    // 隐藏点赞
                    case 7:
                        view.hideUpView();
                }
            }
        });
        builder.show();
    }

    @Override
    public void goToLogin(Activity activity) {
        tipGotoLogin();
    }

    private void tipGotoLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("提示!");
        builder.setMessage("是否去登录？");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("去登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                login();
            }
        });
        builder.show();
    }

    private void login() {
        BotBrain.newInstance().login(mUserId, mNickName, mAvatar, new BotBrain.LoginCallback() {
            @Override
            public void onSuccess() {
                ToastUtil.showCenter(ContextHolder.getContext(), "登录成功!", Toast.LENGTH_SHORT);
            }

            @Override
            public void onFail(String error) {
                ToastUtil.showCenter(ContextHolder.getContext(), "登录失败!", Toast.LENGTH_SHORT);
            }
        });
    }

    private void showMessage(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("回调信息!");
        builder.setMessage(msg);
        builder.setPositiveButton("确定",null);
        builder.show();
    }
}
