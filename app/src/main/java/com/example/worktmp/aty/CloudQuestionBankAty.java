package com.example.worktmp.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.adapter.NormalExpandableListAdapter;
import com.example.worktmp.interfaces.OnGroupExpandedListener;
import com.example.worktmp.model.OmicsBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * 云题库
 */
public class CloudQuestionBankAty extends Activity {
    // 目录
    private List<OmicsBean.DataBean.CategoryListBean> caFiList;
    // map<父级,子集集合>
    private Map<OmicsBean.DataBean.CategoryListBean, List<OmicsBean.DataBean.CategoryListBean>> dataset = new HashMap<OmicsBean.DataBean.CategoryListBean, List<OmicsBean.DataBean.CategoryListBean>>();


    private NormalExpandableListAdapter caAdapter;

    private ExpandableListView lstvCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aty_cloud_question_bank);

        caFiList = new ArrayList<OmicsBean.DataBean.CategoryListBean>();

        for (int i = 0; i < 5; i++) {
            OmicsBean.DataBean.CategoryListBean bean = new OmicsBean.DataBean.CategoryListBean();
            bean.setDataID("id" + (i + 1));
            bean.setDataName("第" + (i + 1) + "单元");
            bean.setDataPID("0");

            caFiList.add(bean);

            List<OmicsBean.DataBean.CategoryListBean> childList = new ArrayList<OmicsBean.DataBean.CategoryListBean>();
            for (int j = 0; j < 8; j++) {
                OmicsBean.DataBean.CategoryListBean child = new OmicsBean.DataBean.CategoryListBean();
                child.setDataID("id" + (j + 1));
                child.setDataName("第" + (j + 1) + "章节");
                child.setDataPID(String.valueOf(i));

                childList.add(child);
            }

            dataset.put(bean, childList);
        }

        initView();
        setCaAdatper(0, 0);


        //返回
        View vGoBack = (View) findViewById(R.id.in_go_back_menu_layout_aty_cloud_question_bank);
        vGoBack.setOnClickListener(new Listeners());

        //标题文字
        TextView tvTitle = (TextView) findViewById(R.id.in_title_layout_aty_cloud_question_bank);
        tvTitle.setText(getResources().getString(R.string.cloud_question_bank));
    }


    private void initView() {
        lstvCa = (ExpandableListView) findViewById(R.id.expandable_list);
        lstvCa.setGroupIndicator(null);
        lstvCa.setDivider(null);
        // 遍历所有group,将所有项设置成默认展开
        int groupCount = lstvCa.getCount();
        for (int i = 0; i < groupCount; i++) {
            lstvCa.expandGroup(i);
        }

        // 设置分组项的点击监听事件
        lstvCa.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition
                        + ", id:" + id);

                // 如果需要收起展开效果就去掉此句，但加上此句可刷新界面
//                setCaAdatper(groupPosition, -1);

                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });


        // 设置子选项点击监听事件
        lstvCa.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, final int childPosition, long id) {
                setCaAdatper(groupPosition, childPosition);

                Intent intent =new Intent(CloudQuestionBankAty.this,WorkPreviewAty.class);
                startActivity(intent);

                return true;
            }
        });
    }

    /**
     * 给左侧目录设置适配器
     *
     * @param parentPos 父级位置
     * @param childPos  子级位置
     */
    private void setCaAdatper(int parentPos, int childPos) {
        // if (caAdapter == null)
        // {//暂时不加，因getChildrenCount()的groupPosition无法重置的问题
        caAdapter = new NormalExpandableListAdapter(this, caFiList,
                dataset);
        lstvCa.setAdapter(caAdapter);
        // } else {
        // caAdapter.notifyDataSetChanged();
        // }

        // 遍历所有group,将所有项设置成默认展开
        int groupCount = lstvCa.getCount();
        for (int i = 0; i < groupCount; i++) {
            lstvCa.expandGroup(i);
        }

        caAdapter.setPosition(parentPos, childPos);

        caAdapter.setOnGroupExpandedListener(new OnGroupExpandedListener() {
            @Override
            public void onGroupExpanded(int groupPosition) {
                // / expandOnlyOne(groupPosition);

            }
        });
    }

    /**
     * 控件监听
     */
    private class Listeners implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.in_go_back_menu_layout_aty_cloud_question_bank://返回
                    finish();
                    break;
            }
        }
    }

}
