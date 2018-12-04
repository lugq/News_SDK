package com.botbrain.demo;

import android.app.Application;

import com.botbrain.demo.listener.MyBotBrainDataSourceInterceptor;
import com.botbrain.demo.listener.MyNewsFragmentListener;
import com.botbrain.demo.listener.MyReadNewsActivityListener;
import com.botbrain.demo.listener.MySearchNewsActivityListener;

import ai.botbrain.ttcloud.api.TtCloudManager;
import ai.botbrain.ttcloud.api.TtcClient;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 17/4/17.
 */

public class App extends Application {

    private MyNewsFragmentListener myNewsFragmentListener;

    @Override
    public void onCreate() {
        super.onCreate();

        myNewsFragmentListener = new MyNewsFragmentListener();
        setMyNewsFragmentListener(myNewsFragmentListener);

        TtcClient client = new TtcClient.Builder()
                .setLogEnable(true)
                //.setDebug()
                .setBotBrainDataSourceInterceptor(new MyBotBrainDataSourceInterceptor())
                .setNewsFragmentListener(myNewsFragmentListener)
                .setReadNewsActivityListener(new MyReadNewsActivityListener())
                .setSearNewsActivityListener(new MySearchNewsActivityListener())
                .build();
        TtCloudManager.init(this, client);

        //TtCloudManager.init(this);
    }

    public MyNewsFragmentListener getMyNewsFragmentListener() {
        return myNewsFragmentListener;
    }

    public void setMyNewsFragmentListener(MyNewsFragmentListener myNewsFragmentListener) {
        this.myNewsFragmentListener = myNewsFragmentListener;
    }
}
