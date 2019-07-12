package com.example.worktmp.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 班级操作弹出框
 *
 * @author chenhui 2019.07.04
 */
public class CustomDialog extends Dialog {
    //    style引用style样式
    public CustomDialog(Context context, int width, int height, View layout, int style,int gravity) {

        super(context, style);

        setContentView(layout);

        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();

        params.gravity = gravity;
        params.width=width;
        params.height=height;

        window.setAttributes(params);
    }
}
