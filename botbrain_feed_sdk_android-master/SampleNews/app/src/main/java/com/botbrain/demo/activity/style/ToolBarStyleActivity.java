package com.botbrain.demo.activity.style;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.botbrain.demo.R;
import com.botbrain.demo.adapter.BaseRecyclerAdapter;
import com.botbrain.demo.adapter.SmartViewHolder;

import java.util.Arrays;

import ai.botbrain.ttcloud.api.BotBrain;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/27.
 */

public class ToolBarStyleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String viewUrl = "http://cloud.botbrain.ai/view/v2/VNMDT28VA9/article/AODgzNDg5MzYxNjg?column_id=100010&plt=android&sid=b3ebf6ab115119241699656f4e7481f7&uid=&guid=9002b25420ad41a718941e8cf60bd67d&scene_id=&algs=[time]&alg_group=time&show_config=true";

    private String mid = "AODgzOTM1NTQ2NDA";

    private enum Item {
        Delivery("导航栏背景颜色"),
        Delivery2("导航栏左侧按钮"),
        Delivery3("导航栏左侧图标"),;

        public String option;

        Item(String option) {
            this.option = option;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_style);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        recyclerView.setAdapter(new BaseRecyclerAdapter<Item>(Arrays.asList(Item.values()), android.R.layout.simple_list_item_1, this) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                holder.text(android.R.id.text1, model.option);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = Item.values()[position].name();
        /** 修改背景颜色 **/
        if (position == 0) {

        } else if (position == 1) {

        }

        BotBrain.newInstance().openReadNews(this, mid);
    }

}
