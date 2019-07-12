package com.example.worktmp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 可扩展ListView（ 1.在外层ScrollView布局的包裹下依然可扩展全部）
 * 
 * @author chenhui 2019.07.02
 * 
 */
public class CustomExpandListView extends ListView {

	public CustomExpandListView(Context context) {
		super(context);
	}

	public CustomExpandListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
