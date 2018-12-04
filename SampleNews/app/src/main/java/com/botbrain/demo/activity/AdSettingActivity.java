package com.botbrain.demo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.botbrain.demo.R;

import ai.botbrain.ttcloud.api.BotBrain;
import ai.botbrain.ttcloud.sdk.view.fragment.IndexFragment;

/**
 * 开发者自行设置广告.
 */
public class AdSettingActivity extends AppCompatActivity {

    IndexFragment mNewsIndexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_style);
        mNewsIndexFragment = BotBrain.newInstance().getNewsFragment();

        if (!mNewsIndexFragment.isAdded()) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, mNewsIndexFragment);
            fragmentTransaction.commit();
        }

    }

}
