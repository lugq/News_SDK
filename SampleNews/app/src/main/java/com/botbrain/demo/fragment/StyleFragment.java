package com.botbrain.demo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.botbrain.demo.R;
import com.botbrain.demo.activity.TabLayoutStyleActivity;
import com.botbrain.demo.activity.style.TipsStyleActivity;
import com.botbrain.demo.activity.style.ToolBarStyleActivity;
import com.botbrain.demo.adapter.BaseRecyclerAdapter;
import com.botbrain.demo.adapter.SmartViewHolder;

import java.util.Arrays;

import ai.botbrain.ttcloud.api.BotBrain;

import static android.R.layout.simple_list_item_2;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/20.
 */

public class StyleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String viewUrl = "http://cloud.botbrain.ai/view/v2/VNMDT28VA9/article/AODgzNDg5MzYxNjg?column_id=100010&plt=android&sid=b3ebf6ab115119241699656f4e7481f7&uid=&guid=9002b25420ad41a718941e8cf60bd67d&scene_id=&algs=[time]&alg_group=time&show_config=true";

    private enum Item {
        TabLayout("修改新闻首页滑动标签样式", TabLayoutStyleActivity.class),
        Tips("修改刷新后的提示", TipsStyleActivity.class),
        ReadNewsView("连续点击状态栏3次进入自定义样式模式", ToolBarStyleActivity.class),
        SearchNewsView("连续点击状态栏3次进入自定义样式模式", ToolBarStyleActivity.class),
        ;

        public String name;
        public Class<?> clazz;

        Item(String name, Class<?> clazz) {
            this.name = name;
            this.clazz = clazz;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_style, container, false);
    }

    @Override
    public void onViewCreated(View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);
        //StatusBarUtil.setPaddingSmart(getContext(), root.findViewById(R.id.toolbar));

        View view = root.findViewById(R.id.recyclerView);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
            recyclerView.setAdapter(new BaseRecyclerAdapter<Item>(Arrays.asList(Item.values()), simple_list_item_2, this) {
                @Override
                protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                    holder.text(android.R.id.text1, model.name());
                    holder.text(android.R.id.text2, model.name);
                    holder.textColorId(android.R.id.text2, R.color.colorTextAssistant);
                }
            });
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (Item.values()[position].name().equals("ReadNewsView")) {
            BotBrain.newInstance().openReadNews(getActivity(), viewUrl);
            return;
        } else if (Item.values()[position].name().equals("SearchNewsView")) {
            BotBrain.newInstance().openSearchNews(getActivity());
            return;
        }
        startActivity(new Intent(getContext(), Item.values()[position].clazz));
    }
}
