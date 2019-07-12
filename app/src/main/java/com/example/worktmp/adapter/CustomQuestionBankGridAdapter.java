package com.example.worktmp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.model.QuestionBank;

import java.util.List;

/**
 * 题库适配器
 */
public class CustomQuestionBankGridAdapter extends BaseListAdapter<QuestionBank> {
    public CustomQuestionBankGridAdapter(Context context, List<QuestionBank> dataList) {
        super(context, dataList);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.layout_v_question_bank_item;
    }

    @Override
    protected void doAssignValueForView(int position, View resultView, QuestionBank dataObj) {
        //题库名称
        TextView tvName = (TextView) resultView.findViewById(R.id.tv_name_layout_aty_choose_question_bank);
        tvName.setText(dataObj.getName());

        //题库Logo
        ImageView ivLogo = (ImageView) resultView.findViewById(R.id.iv_logo_layout_aty_choose_question_bank);
        if (dataObj.getImgRes() == 0) {
            ivLogo.setBackgroundResource(R.drawable.ic_launcher);
        } else {
            ivLogo.setBackgroundResource(dataObj.getImgRes());
        }
    }
}
