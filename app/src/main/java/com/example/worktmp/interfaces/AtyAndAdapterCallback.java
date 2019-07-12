package com.example.worktmp.interfaces;

import com.example.worktmp.model.KeyValue;

/**
 * Activity与adapter之间的交互
 */
public interface AtyAndAdapterCallback {

    /**
     * 点击单项后的处理
     *
     * @param keyValue 数据
     * @param code     单击项区分标志
     */
    public void doAfterItemClickListener(KeyValue keyValue, int code);
}
