package com.example.worktmp.adapter;

import android.content.Context;
import android.view.View;

import com.example.worktmp.R;
import com.example.worktmp.model.CLasses;

import java.util.List;

public class ClassAdapter extends BaseListAdapter<CLasses> {
    public ClassAdapter(Context context, List<CLasses> dataList) {
        super(context, dataList);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.layout_v_class_item;
    }

    @Override
    protected void doAssignValueForView(int position, View resultView, CLasses dataObj) {

    }
}
