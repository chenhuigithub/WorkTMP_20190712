package com.example.worktmp.fg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.adapter.WorkLvAdapter;
import com.example.worktmp.application.CustomApplication;
import com.example.worktmp.aty.ChooseQuestionBankAty;
import com.example.worktmp.aty.MainActivity;
import com.example.worktmp.aty.WorkOverviewAty;
import com.example.worktmp.interfaces.AtyAndAdapterCallback;
import com.example.worktmp.model.CLasses;
import com.example.worktmp.model.KeyValue;
import com.example.worktmp.model.Work;
import com.example.worktmp.view.CustomDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 在线作业
 *
 * @author chenhui 2019.07.02
 */
@SuppressLint("ValidFragment")
public class OnLineWorkFg extends BaseNotPreLoadFg implements AtyAndAdapterCallback {
    private boolean isPrepared;// 标志位，标志已经初始化完成
    private boolean hasLoadOnce;// 是否已被加载过一次，第二次就不再去请求数据了

    private List<Work> workList;

    private CustomDialog classOperationDialog;//班级操作弹出框
    private MainActivity mainAty;//主Activity

    private View allFgView;// 总布局
    private TextView tvArrangeWork;//布置作业
    private ListView lvWork;//作业
    private WorkLvAdapter workLvAdapter;//作业列表适配器

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            mainAty = (MainActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == allFgView) {
            allFgView = inflater.inflate(R.layout.layout_fg_on_line_work, null);
            tvArrangeWork = (TextView) allFgView.findViewById(R.id.tv_arrange_work_layout_fg_on_line_work);
            tvArrangeWork.setOnClickListener(new Listeners());

            lvWork = (ListView) allFgView.findViewById(R.id.lv_wrapper_content_layout_fg_on_line_work);


            //标题文字
            TextView tvTitle = (TextView) allFgView.findViewById(R.id.in_title_layout_v_class_item);
            tvTitle.setText("在线作业");
        }

        // 因为共用一个Fragment视图，所以当前这个视图已被加载到Activity中，必须先清除后再加入Activity
        ViewGroup parent = (ViewGroup) allFgView.getParent();
        if (parent != null) {
            parent.removeView(allFgView);
        }
        // 标志当前页面可见
        isPrepared = true;

        lazyLoad();

        return allFgView;
    }

    /**
     * 设置作业列表适配器
     */
    private void setLvAdapter() {
        if (workLvAdapter == null) {
            workLvAdapter = new WorkLvAdapter(getActivity(), workList, (AtyAndAdapterCallback) this);
            lvWork.setAdapter(workLvAdapter);
        } else {
            workLvAdapter.notifyDataSetChanged();
        }
    }


    /**
     * 设置班级操作弹出框
     */
    private void showWorkOperationDialog() {
        View view = getLayoutInflater().inflate(R.layout.layout_v_class_operation_dialog, null);
        //设置弹框宽度、高度等属性
        classOperationDialog = new CustomDialog(getActivity(), CustomApplication.Screen_Width * 3 / 4, CustomApplication.Screen_Height / 3, view, R.style.DialogTheme, Gravity.CENTER);
        classOperationDialog.setCancelable(true);
        classOperationDialog.show();

        TextView tvEdit = (TextView) view.findViewById(R.id.tv_edit_layout_v_class_operation_dialog);
        tvEdit.setOnClickListener(new Listeners());

        TextView tvPublish = (TextView) view.findViewById(R.id.tv_publish_layout_v_class_operation_dialog);
        tvPublish.setOnClickListener(new Listeners());

        TextView tvDelete = (TextView) view.findViewById(R.id.tv_delete_layout_v_class_operation_dialog);
        tvDelete.setOnClickListener(new Listeners());

        TextView tvOneClickAcceleration = (TextView) view.findViewById(R.id.tv_one_click_acceleration_layout_v_class_operation_dialog);
        tvOneClickAcceleration.setOnClickListener(new Listeners());


    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || hasLoadOnce) {
            return;
        }

        workList = new ArrayList<Work>();
        for (int i = 0; i < 3; i++) {
            Work work = new Work();
            work.setId("id" + i);
            work.setIsArranged("0");
            work.setState("0");

            List<CLasses> classList = new ArrayList<CLasses>();
            for (int j = 0; j < 2; j++) {
                CLasses cLasses = new CLasses();
                cLasses.setId("id" + j);
                cLasses.setName("50");
                cLasses.setCommitNum("45");
                cLasses.setScoreRate("90%");
                classList.add(cLasses);
            }
            work.setClassList(classList);
            workList.add(work);
        }

        setLvAdapter();
    }


    @Override
    public void doAfterItemClickListener(KeyValue keyValue, int code) {
        if (keyValue instanceof Work) {
            Log.i("OnLineWorkFg Callback", "work");
            Work work = (Work) keyValue;

            switch (code) {
                case 0://查看作业概览
                    Intent intent = new Intent(getActivity(), WorkOverviewAty.class);
                    startActivity(intent);

                    break;
                case 1://具体操作项
                    showWorkOperationDialog();
                    break;
            }
        }
    }

    /**
     * 关闭弹框
     */
    private void dismissDialog() {
        if (classOperationDialog != null) {
            classOperationDialog.cancel();
        }
    }

    private class Listeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_edit_layout_v_class_operation_dialog:
                    dismissDialog();
                    break;
                case R.id.tv_publish_layout_v_class_operation_dialog:
                    dismissDialog();
                    break;
                case R.id.tv_delete_layout_v_class_operation_dialog:
                    dismissDialog();
                    break;
                case R.id.tv_one_click_acceleration_layout_v_class_operation_dialog:
                    dismissDialog();
                    break;
                case R.id.tv_arrange_work_layout_fg_on_line_work:
                    Intent intent = new Intent(getActivity(), ChooseQuestionBankAty.class);
                    startActivity(intent);
                    
                    break;
            }
        }
    }
}
