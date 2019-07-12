package com.example.worktmp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.worktmp.R;
import com.example.worktmp.model.Question;
import com.example.worktmp.view.CustomSinkingView;

import java.util.List;

/**
 * 答题 正确率适配器
 */
public class CorrectRateGridAdapter extends BaseListAdapter<Question> {
    private float percent = 0;

    public CorrectRateGridAdapter(Context context, List<Question> dataList) {
        super(context, dataList);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.layout_v_correct_rate_grid_item;
    }

    @Override
    protected void doAssignValueForView(int position, View resultView, Question dataObj) {
        CustomSinkingView sikv = (CustomSinkingView) resultView.findViewById(R.id.sikv_layout_v_correct_rate_grid_item);
        sikv.setPercent(0.9f);
        sikv.setTextSize(45);
    }
}
