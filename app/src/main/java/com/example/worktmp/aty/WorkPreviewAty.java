package com.example.worktmp.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worktmp.R;
import com.example.worktmp.adapter.QuestionAdapter;
import com.example.worktmp.interfaces.AtyAndAdapterCallback;
import com.example.worktmp.model.KeyValue;
import com.example.worktmp.model.Question;
import com.example.worktmp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作业预览
 *
 * @author chenhui 2019.07.11
 */
public class WorkPreviewAty extends Activity implements AtyAndAdapterCallback {
    private List<Question> questionList;//题目列表
    private List<String> assignmentsIDList;//已布置的作业ID集合

    private QuestionAdapter qAdapter;//题目适配器

    private ListView lvQustion;//题目
    private TextView tvArrangeWork;//布置作业

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aty_work_preview);

        questionList = new ArrayList<Question>();
        assignmentsIDList = new ArrayList<String>();

        //返回
        View vGoBack = (View) findViewById(R.id.in_go_back_menu_layout_aty_work_preview);
        vGoBack.setOnClickListener(new Listeners());
        //标题文字
        TextView tvTitle = (TextView) findViewById(R.id.in_title_layout_aty_work_preview);
        tvTitle.setText(getResources().getString(R.string.work_preview));
        //标题文字
        TextView tvEmpty = (TextView) findViewById(R.id.tv_empty_layout_aty_work_preview);
        tvEmpty.setOnClickListener(new Listeners());
        //存草稿
        TextView tvDepositDraft = (TextView) findViewById(R.id.tv_deposit_draft_layout_aty_work_preview);
        tvDepositDraft.setOnClickListener(new Listeners());
        //布置作业
        tvArrangeWork = (TextView) findViewById(R.id.tv_arrange_work_layout_aty_work_preview);
        tvArrangeWork.setOnClickListener(new Listeners());


        lvQustion = (ListView) findViewById(R.id.lv_work_aty_work_preview);

        setQuestionAdapter();
    }

    /**
     * 题目适配器
     */
    private void setQuestionAdapter() {
        for (int i = 1; i <= 3; i++) {
            Question question = new Question();
            question.setId("id" + i);
            question.setTitle("一.解答题");
            question.setPid("0");

            List<Question> childList = new ArrayList<Question>();
            for (int j = 1; j < 5; j++) {
                Question c = new Question();
                c.setId("id" + j);
                c.setTitle(getResources().getString(R.string.test_question1));
                c.setPid(String.valueOf(i));
                childList.add(c);
            }
            question.setChildList(childList);

            questionList.add(question);
        }

        if (qAdapter == null) {
            qAdapter = new QuestionAdapter(this, questionList);
            lvQustion.setAdapter(qAdapter);
        } else {
            qAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 设置布置作业按钮
     */
    private void setArrangeWorkTv() {
        if (assignmentsIDList.size() > 100) {
            tvArrangeWork.setText(getResources().getString(R.string.arrange_work) + "(99+题)");
        } else {
            tvArrangeWork.setText(getResources().getString(R.string.arrange_work) + "(" + assignmentsIDList.size() + "题)");
        }
    }

    @Override
    public void doAfterItemClickListener(KeyValue keyValue, int code) {
        switch (code) {
            case 0://点击移除题目
                //需要完整数据时可以转化
//                if (keyValue instanceof Question) {
//                }
                Utils.removeOne(assignmentsIDList, keyValue.getKey());

                setArrangeWorkTv();

                break;

            case 1://点击添加题目
                //需要完整数据时可以转化
//                if (keyValue instanceof Question) {
//                }
                Utils.addOne(assignmentsIDList, keyValue.getKey(), assignmentsIDList.size());

                setArrangeWorkTv();

                break;
        }
    }

    /**
     * 控件监听
     */
    private class Listeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.in_go_back_menu_layout_aty_work_preview://返回
                    finish();
                    break;
                case R.id.tv_deposit_draft_layout_aty_work_preview://存草稿
                    Toast.makeText(WorkPreviewAty.this, "已保存", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_arrange_work_layout_aty_work_preview://布置作业
                    break;
                case R.id.tv_empty_layout_aty_work_preview://清空
                    if (assignmentsIDList.size() > 0) {
                        assignmentsIDList.clear();
                    }

                    setArrangeWorkTv();

                    setQuestionAdapter();

                    break;
            }
        }
    }
}
