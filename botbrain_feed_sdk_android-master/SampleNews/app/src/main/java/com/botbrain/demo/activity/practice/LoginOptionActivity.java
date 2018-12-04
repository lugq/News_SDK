package com.botbrain.demo.activity.practice;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.botbrain.demo.R;

import ai.botbrain.ttcloud.api.TtCloudManager;
import ai.botbrain.ttcloud.sdk.view.fragment.IndexFragment;

public class LoginOptionActivity extends AppCompatActivity {

    IndexFragment mNewsIndexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_tip);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_day:
                        TtCloudManager.setDayTheme();
                        break;
                    case R.id.item_night:
                        TtCloudManager.setNightTheme();
                        break;
                }
                return false;
            }
        });

        mNewsIndexFragment = new IndexFragment();

        if (!mNewsIndexFragment.isAdded()) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, mNewsIndexFragment);
            fragmentTransaction.commit();
        }

    }
}
