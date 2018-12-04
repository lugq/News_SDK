package com.botbrain.demo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.botbrain.demo.R;

import java.util.List;

import ai.botbrain.ttcloud.sdk.data.entity.RecommendNewsEntity;
import ai.botbrain.ttcloud.sdk.util.ContextHolder;
import ai.botbrain.ttcloud.sdk.view.adapter.GraphicAdapter;
import ai.botbrain.ttcloud.sdk.view.viewholder.newsholder.CustomHolder;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2017/10/18.
 */

public class MyCustomHolder extends CustomHolder {

    private TextView tv_custom;

    @Override
    public void init(View convertView, List<RecommendNewsEntity.Items> datas) {
        super.init(convertView, datas);
        if (convertView != null) {
            LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.ll_container);
            View view = View.inflate(ContextHolder.getContext(), R.layout.ttc_customer_view, null);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(layoutParams);

            tv_custom = (TextView) view.findViewById(R.id.item_title);
            ViewGroup p = (ViewGroup) view.getParent();
            if (p!=null) {
                p.removeAllViewsInLayout();
            }

            linearLayout.addView(view);
        }
    }

    @Override
    public void bindData(int position, GraphicAdapter adapter) {
        RecommendNewsEntity.Items data = mDatas.get(position);
        String str = (String) data.customContent;

        tv_custom.setText(str);
    }
}
