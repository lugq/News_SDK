package com.botbrain.demo.listener;

import android.util.Log;

import java.util.List;

import ai.botbrain.ttcloud.api.BotBrainDataSourceInterceptor;
import ai.botbrain.ttcloud.sdk.domain.Config;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/2/23.
 */

public class MyBotBrainDataSourceInterceptor implements BotBrainDataSourceInterceptor {

    private static final String TAG = MyBotBrainDataSourceInterceptor.class.getSimpleName();

    @Override
    public void getConfigData(List<Config> configs) {
        for(Config config : configs) {
            Log.i(TAG, config.getTitle());
        }

        //configs.remove(0);
    }

}
