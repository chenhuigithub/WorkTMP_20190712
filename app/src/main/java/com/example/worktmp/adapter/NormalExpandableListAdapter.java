package com.example.worktmp.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.interfaces.OnGroupExpandedListener;
import com.example.worktmp.model.OmicsBean;

/**
 *
 */
public class NormalExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "NormalExpandableListAda";
    private OnGroupExpandedListener mOnGroupExpandedListener;
    // 一级页面
    List<OmicsBean.DataBean.CategoryListBean> parentList;
    // 创建child数据的二维数组
    OmicsBean.DataBean.CategoryListBean[][] childArray;

    Map<OmicsBean.DataBean.CategoryListBean, List<OmicsBean.DataBean.CategoryListBean>> dataset;

    private int gPos;// 父级位置，即groupPosition
    private int cPos;// 子级位置，即childPosition

    private Resources res;// 资源工具

    @Deprecated
    private Map<Integer, Integer> itemExpandType = null;// 展开状态

    public Integer expandType = 0;// 展开状态（默认状态）
    public Integer putAwayType = 1;// 收回状态

    /**
     * 构造方法
     *
     * @param parentList 父级（一级）目录集合
     * @param dataset1    map<父级,子集集合>
     */
    public NormalExpandableListAdapter(Context context,
                                       List<OmicsBean.DataBean.CategoryListBean> parentList,
                                       Map<OmicsBean.DataBean.CategoryListBean, List<OmicsBean.DataBean.CategoryListBean>> dataset1) {
        this.parentList = parentList;
        this.dataset = dataset1;

        itemExpandType = new HashMap<Integer, Integer>();

        res = context.getResources();
    }

    /**
     * 设置位置
     *
     * @param gPos
     * @param cPos
     */
    public void setPosition(int gPos, int cPos) {
        this.gPos = gPos;
        this.cPos = cPos;
    }

    /**
     * 获取父级位置
     *
     * @return gPos
     */
    public int getGPosition() {
        return this.gPos;
    }

    /**
     * 获取子级位置
     *
     * @return cPos
     */
    public int getCPosition() {
        return this.cPos;
    }

    public void setOnGroupExpandedListener(
            OnGroupExpandedListener onGroupExpandedListener) {
        mOnGroupExpandedListener = onGroupExpandedListener;
    }

    /**
     * @param pos
     * @param type
     * @deprecated
     */
    public void setExpandType(int pos, int type) {
        itemExpandType.put(pos, type);
    }

    /**
     * 是否展开状态
     *
     * @param pos
     * @return
     * @deprecated
     */
    public boolean isExpandType(int pos) {
        Integer type = itemExpandType.get(pos);
        if (type == null || expandType == type) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getGroupCount() {
        return dataset.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return dataset.get(parentList.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return dataset.get(parentList.get(groupPosition));
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return dataset.get(parentList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_expand_group_normal, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView
                    .findViewById(R.id.label_group_normal);
            groupViewHolder.ivSign = (ImageView) convertView
                    .findViewById(R.id.iv_layout_item_expand_group_normal);

            // 竖线部分
            groupViewHolder.vLine01 = (View) convertView
                    .findViewById(R.id.v_line01_layout_item_expand_group_normal);
            groupViewHolder.vLine02 = (View) convertView
                    .findViewById(R.id.v_line02_layout_item_expand_group_normal);

            // 子集
            List<OmicsBean.DataBean.CategoryListBean> childList = dataset.get(parentList
                    .get(groupPosition));

            if (groupPosition == 0) {// 当前数据处在第一条时
                groupViewHolder.vLine01.setVisibility(View.GONE);
            } else {
                groupViewHolder.vLine01.setVisibility(View.VISIBLE);
            }

            if (childList.size() == 0) {// 其下没有子数据的情况
                groupViewHolder.vLine01.setVisibility(View.GONE);
                groupViewHolder.vLine02.setVisibility(View.GONE);
            } else {
                groupViewHolder.vLine02.setVisibility(View.VISIBLE);
            }

            if (groupPosition == getGPosition()) {
                groupViewHolder.ivSign.setSelected(true);
            } else {
                groupViewHolder.ivSign.setSelected(false);
            }

            convertView.setTag(groupViewHolder);

        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(parentList.get(groupPosition)
                .getDataName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_expand_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = (TextView) convertView
                    .findViewById(R.id.label_expand_child);
            childViewHolder.ivSign = (ImageView) convertView
                    .findViewById(R.id.iv_layout_item_expand_child);
            // 竖线部分
            childViewHolder.vLine01 = (View) convertView
                    .findViewById(R.id.v_line01_layout_item_expand_child);
            childViewHolder.vLine02 = (View) convertView
                    .findViewById(R.id.v_line02_layout_item_expand_child);

            List<OmicsBean.DataBean.CategoryListBean> childList = dataset.get(parentList
                    .get(groupPosition));

            if ((groupPosition == parentList.size() - 1)
                    && (childPosition == childList.size() - 1)) {// 当前数据为全部数据的最后一条数据
                childViewHolder.vLine02.setVisibility(View.GONE);
            } else {
                childViewHolder.vLine01.setVisibility(View.VISIBLE);
            }

            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        int gPos = getGPosition();
        if (groupPosition == gPos && cPos == childPosition) {
            setFocused(childViewHolder);
        } else {
            setNormal(childViewHolder);
        }

        childViewHolder.tvTitle.setText(dataset
                .get(parentList.get(groupPosition)).get(childPosition)
                .getDataName());
        return convertView;
    }

    /**
     * 选中状态
     *
     * @param childViewHolder
     */
    private void setFocused(ChildViewHolder childViewHolder) {
        // childViewHolder.tvTitle.setBackgroundColor(res
        // .getColor(R.color.green01));
        // childViewHolder.tvTitle.setTextColor(res.getColor(R.color.clog));

        childViewHolder.ivSign.setSelected(true);
    }

    /**
     * 正常状态
     *
     * @param childViewHolder
     */
    private void setNormal(ChildViewHolder childViewHolder) {
        // childViewHolder.tvTitle.setBackgroundColor(res.getColor(R.color.white));
        // childViewHolder.tvTitle.setTextColor(res
        // .getColor(R.color.color_text_content));

        childViewHolder.ivSign.setSelected(false);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Log.d(TAG, "onGroupExpanded() called with: groupPosition = ["
                + groupPosition + "]");
        if (mOnGroupExpandedListener != null) {
            mOnGroupExpandedListener.onGroupExpanded(groupPosition);
        }
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        Log.d(TAG, "onGroupCollapsed() called with: groupPosition = ["
                + groupPosition + "]");
    }

    private static class GroupViewHolder {
        TextView tvTitle;
        ImageView ivSign;
        View vLine01;
        View vLine02;
    }

    private static class ChildViewHolder {
        TextView tvTitle;
        ImageView ivSign;
        View vLine01;
        View vLine02;
    }
}
