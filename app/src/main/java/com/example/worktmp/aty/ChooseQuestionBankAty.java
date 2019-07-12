package com.example.worktmp.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.adapter.CustomQuestionBankGridAdapter;
import com.example.worktmp.model.QuestionBank;
import com.example.worktmp.view.CustomGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择题库
 *
 * @author chenhui 2019.07.09
 */
public class ChooseQuestionBankAty extends Activity {
    private GridView gdvBankType;//题库类型网格布局
    private CustomQuestionBankGridAdapter qbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aty_choose_question_bank);

        //返回
        View vGoBack = (View) findViewById(R.id.in_go_back_menu_layout_aty_choose_question_bank);
        vGoBack.setOnClickListener(new ClickListeners());
        //标题文字
        TextView tvTitle = (TextView) findViewById(R.id.in_title_layout_aty_choose_question_bank);
        tvTitle.setText("选择题库");

        gdvBankType = (GridView) findViewById(R.id.gdv_bank_type_layout_aty_choose_question_bank);
        setBankTypeAdapter();

        gdvBankType.setOnItemClickListener(new ItemClickListeners());
    }

    /**
     * 题库类型网格布局的适配器
     */
    private void setBankTypeAdapter() {
        List<QuestionBank> qbList = new ArrayList<QuestionBank>();
        QuestionBank qb1 = new QuestionBank();
        qb1.setId("qb1");
        qb1.setName(getResources().getString(R.string.cloud_question_bank));
        qb1.setImgRes(R.drawable.ic_launcher);
        qbList.add(qb1);

        QuestionBank qb2 = new QuestionBank();
        qb2.setId("qb2");
        qb2.setName(getResources().getString(R.string.school_based_question_bank));
        qb2.setImgRes(R.drawable.ic_launcher);
        qbList.add(qb2);

        QuestionBank qb3 = new QuestionBank();
        qb3.setId("qb3");
        qb3.setName(getResources().getString(R.string.my_question_bank));
        qb3.setImgRes(R.drawable.ic_launcher);
        qbList.add(qb3);

        QuestionBank qb4 = new QuestionBank();
        qb4.setId("qb4");
        qb4.setName(getResources().getString(R.string.error_question_bank));
        qb4.setImgRes(R.drawable.ic_launcher);
        qbList.add(qb4);

        if (qbAdapter == null) {
            qbAdapter = new CustomQuestionBankGridAdapter(this, qbList);
            gdvBankType.setAdapter(qbAdapter);
        } else {
            qbAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 点击监听
     */
    private class ClickListeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.in_go_back_menu_layout_aty_choose_question_bank://返回
                    finish();
                    break;
            }
        }
    }

    /**
     * 跳转至相应界面
     *
     * @param c
     */
    private void startActivitys(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    /**
     * 单项监听
     */
    private class ItemClickListeners implements CustomGridView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
            switch (pos) {
                case 0://云题库
                    startActivitys(CloudQuestionBankAty.class);
                    break;
                case 1://校本题库
                    startActivitys(CloudQuestionBankAty.class);
                    break;
                case 2://我的题库
                    startActivitys(CloudQuestionBankAty.class);
                    break;
                case 3://错题库
                    startActivitys(CloudQuestionBankAty.class);
                    break;
            }
        }
    }
}
