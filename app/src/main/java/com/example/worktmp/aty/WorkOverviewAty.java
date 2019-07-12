package com.example.worktmp.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.adapter.CorrectRateGridAdapter;
import com.example.worktmp.model.Question;
import com.example.worktmp.view.CustomGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作业概览
 */
public class WorkOverviewAty extends Activity {
    private CustomGridView gdvSingleSelection;//单选
    private CustomGridView gdvMultipleSelection;//多选
    private CustomGridView gdvAnswer;//解答

    private CorrectRateGridAdapter singleSelectionAdapter;
    private CorrectRateGridAdapter multipleSelectionAdapter;
    private CorrectRateGridAdapter answerSelectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aty_work_overview);

        //返回
        View vGoBack = (View) findViewById(R.id.in_go_back_menu_layout_aty_work_overview);
        vGoBack.setOnClickListener(new Listeners());

        //标题文字
        TextView tvTitle = (TextView) findViewById(R.id.in_title_layout_aty_work_overview);
        tvTitle.setText("作业概览");

        gdvSingleSelection = (CustomGridView) findViewById(R.id.gdv_single_election_layout_aty_work_overview);
        gdvMultipleSelection = (CustomGridView) findViewById(R.id.gdv_multiple_election_layout_aty_work_overview);
        gdvAnswer = (CustomGridView) findViewById(R.id.gdv_answer_layout_aty_work_overview);

        setSingleSelectionGdvAdapter();

    }

    private void setSingleSelectionGdvAdapter() {
        List<Question> list = new ArrayList<Question>();
        list.add(new Question());
        list.add(new Question());
        list.add(new Question());
        list.add(new Question());
        list.add(new Question());
        list.add(new Question());
        list.add(new Question());
        if (singleSelectionAdapter == null) {
            singleSelectionAdapter = new CorrectRateGridAdapter(this, list);
            gdvSingleSelection.setAdapter(singleSelectionAdapter);
        } else {
            singleSelectionAdapter.notifyDataSetChanged();
        }

        if (multipleSelectionAdapter == null) {
            multipleSelectionAdapter = new CorrectRateGridAdapter(this, list);
            gdvMultipleSelection.setAdapter(multipleSelectionAdapter);
        } else {
            multipleSelectionAdapter.notifyDataSetChanged();
        }

        if (answerSelectionAdapter == null) {
            answerSelectionAdapter = new CorrectRateGridAdapter(this, list);
            gdvAnswer.setAdapter(answerSelectionAdapter);
        } else {
            answerSelectionAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 控件的点击监听
     */
    private class Listeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.in_go_back_menu_layout_aty_work_overview://返回
                    finish();
                    break;
            }
        }
    }
}
