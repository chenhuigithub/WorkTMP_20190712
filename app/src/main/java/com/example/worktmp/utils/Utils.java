package com.example.worktmp.utils;

import android.widget.ListView;

import java.util.List;

/**
 * 工具类
 */
public class Utils {

    /**
     * 查重，集合中是否存在该值
     *
     * @param strList 集合
     * @param str     该值
     * @return 是否存在该值
     */
    public static boolean isHasOne(List<String> strList, String str) {
        boolean hasOne = false;
        for (int i = 0; i < strList.size(); i++) {
            String itemID = strList.get(i);
            if (str.equals(itemID)) {
                hasOne = true;
            }
        }
        return hasOne;
    }

    /**
     * 移除该值
     *
     * @param strList 集合
     * @param str     该值
     * @return 是否存在该值
     */
    public static List<String> removeOne(List<String> strList, String str) {
        boolean hasOne = false;
        int a = 0;
        for (int i = 0; i < strList.size(); i++) {
            String itemID = strList.get(i);
            if (str.equals(itemID)) {
                hasOne = true;
                a = i;
            }
        }
        if (hasOne) {
            strList.remove(a);
        }

        return strList;
    }

    /**
     * 添加该值
     *
     * @param strList 集合
     * @param str     该值
     * @param pos     添加位置
     * @return 添加该值后的集合
     */
    public static List<String> addOne(List<String> strList, String str, int pos) {
        if (!isHasOne(strList, str)) {//确保无该值后再添加，以免重复添加
            strList.add(pos, str);
        }

        return strList;
    }
}
