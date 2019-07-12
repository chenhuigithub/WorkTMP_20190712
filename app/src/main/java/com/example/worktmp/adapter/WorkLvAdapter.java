package com.example.worktmp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.worktmp.R;
import com.example.worktmp.aty.MainActivity;
import com.example.worktmp.interfaces.AtyAndAdapterCallback;
import com.example.worktmp.model.CLasses;
import com.example.worktmp.model.Work;
import com.example.worktmp.view.CustomExpandListView;

import java.util.List;

/**
 * 作业列表适配器
 */
public class WorkLvAdapter extends BaseListAdapter<Work> {
    private Context context;
    private AtyAndAdapterCallback callback;

    public WorkLvAdapter(Context context, List<Work> dataList, AtyAndAdapterCallback callback) {
        super(context, dataList);
        this.context = context;
        this.callback = callback;
    }

    /**
     * 设置班级信息适配器
     *
     * @param lvClass 布局
     * @param list    班级数据
     */
    private void setClassLvAdapter(CustomExpandListView lvClass, List<CLasses> list) {
        ClassAdapter classAdapter = new ClassAdapter(context, list);
        lvClass.setAdapter(classAdapter);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.layout_v_work_item;
    }

    @Override
    protected void doAssignValueForView(int position, View resultView, final Work dataObj) {
        //作业名称
        String name = dataObj.getName();
        if ("".equals(name)) {
        }

        RelativeLayout rlTitle = (RelativeLayout) resultView.findViewById(R.id.rl_wrapper_title_layout_fg_v_work_item);
        LinearLayout ll01 = (LinearLayout) resultView.findViewById(R.id.ll_wrapper_01_layout_v_work_item);
        LinearLayout ll02 = (LinearLayout) resultView.findViewById(R.id.ll_wrapper_02_layout_v_work_item);
        ll01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.doAfterItemClickListener(dataObj, 0);
            }
        });

        ll02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.doAfterItemClickListener(dataObj, 1);
            }
        });

        //班级
        List<CLasses> classList = dataObj.getClassList();
        CustomExpandListView lvClass = (CustomExpandListView) resultView.findViewById(R.id.lv_content_layout_v_work_item);
        setClassLvAdapter(lvClass, classList);

    }
}
