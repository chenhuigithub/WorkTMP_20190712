package com.example.worktmp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.interfaces.AtyAndAdapterCallback;
import com.example.worktmp.model.KeyValue;
import com.example.worktmp.model.Question;

import java.util.List;

/**
 * 题目适配器
 */
public class QuestionAdapter extends BaseListAdapter<Question> {
    AtyAndAdapterCallback callback;

    public QuestionAdapter(Context context, List<Question> dataList) {
        super(context, dataList);
        if (context instanceof AtyAndAdapterCallback) {
            callback = (AtyAndAdapterCallback) context;
        }
    }

    private void addQuestion(KeyValue kv, TextView tv) {
        if (callback != null) {
            callback.doAfterItemClickListener(kv, 1);
        }

        tv.setText(context.getResources().getString(R.string.remove));
    }

    private void removeQuestion(KeyValue kv, TextView tv) {
        if (callback != null) {
            callback.doAfterItemClickListener(kv, 0);
        }

        tv.setText(context.getResources().getString(R.string.add));
    }

    /**
     * 控件监听
     */
    private class Listeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_add_or_remove_type_layout_v_question_item://添加或移除
                    if (view instanceof TextView) {
                        TextView tv = (TextView) view;
                        Object obj = view.getTag();

                        if (obj instanceof Question) {
                            Question q = (Question) obj;
                            if (q instanceof KeyValue) {
                                KeyValue kv = (KeyValue) q;
                                if (context.getResources().getString(R.string.add).equals(tv.getText().toString().trim())) {
                                    addQuestion(kv, tv);
                                } else if (context.getResources().getString(R.string.remove).equals(tv.getText().toString().trim())) {
                                    removeQuestion(kv, tv);
                                }
                            }
                        }
                    }
            }
        }
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.layout_v_question_item;
    }

    @Override
    protected void doAssignValueForView(int position, View resultView, Question dataObj) {
        //父级标题（子集内容）
        TextView tvTitle = (TextView) resultView.findViewById(R.id.tv_title_layout_v_question_item);
        tvTitle.setText(dataObj.getTitle());

        //菜单栏
        RelativeLayout rlMenu = (RelativeLayout) resultView.findViewById(R.id.rl_menu_layout_v_question_item);
        //添加或移除
        TextView tvAddOrRemove = (TextView) resultView.findViewById(R.id.tv_add_or_remove_type_layout_v_question_item);
        tvAddOrRemove.setTag(dataObj);
        tvAddOrRemove.setOnClickListener(new Listeners());
        //题目
        ListView lvQuestion = (ListView) resultView.findViewById(R.id.lv_question_aty_question_preview);

        //子集题目
        List<Question> cList = dataObj.getChildList();

        if ("0".equals(dataObj.getPid())) {//父层级数据，需要加载子数据
            QuestionAdapter adapter = new QuestionAdapter(context, cList);
            lvQuestion.setAdapter(adapter);

            lvQuestion.setVisibility(View.VISIBLE);
            rlMenu.setVisibility(View.GONE);
        } else {
            lvQuestion.setVisibility(View.GONE);
            rlMenu.setVisibility(View.VISIBLE);
        }
    }
}
