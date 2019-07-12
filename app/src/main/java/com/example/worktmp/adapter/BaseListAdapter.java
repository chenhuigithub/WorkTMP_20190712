package com.example.worktmp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 列表基础适配器
 *
 * @param <T> 数据类型，通常为模型类名
 * @author zhaochenhui_2017.04.28
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected Context context;
    private List<T> dataList;

    public BaseListAdapter(Context context, List<T> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        if (dataList != null) {
            return this.dataList.size();
        } else {
            return 0;
        }
    }

    @Override
    public T getItem(int position) {
        if (dataList != null) {
            return this.dataList.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View resultView = convertView;
        if (resultView == null) {
            resultView = LayoutInflater.from(this.context).inflate(
                    this.getLayoutResID(), null);
        }
        T dataObj = getItem(position);
        if ((resultView != null) && (dataObj != null)) {
            doAssignValueForView(position, resultView, dataObj);
        }

        return resultView;
    }

    /**
     * 子类实现该方法返回layout资源ID
     *
     * @return
     */
    protected abstract int getLayoutResID();

    /**
     * 子类进行赋值
     *
     * @param dataObj
     */
    protected abstract void doAssignValueForView(int position, View resultView,
                                                 T dataObj);
}
