package com.example.worktmp.aty;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.worktmp.R;
import com.example.worktmp.adapter.FragmentVPagerAdapter;
import com.example.worktmp.fg.ClassErrorQuestionFg;
import com.example.worktmp.fg.DataAnalysisFg;
import com.example.worktmp.fg.OnLineWorkFg;
import com.example.worktmp.fg.PersonalCenterFg;
import com.example.worktmp.fg.QuestionBasketFg;
import com.example.worktmp.utils.ActivityUtils;
import com.example.worktmp.view.CustomViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 *
 * @author chenhui 2019.07.02
 */
public class MainActivity extends AppCompatActivity {
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度

    private Resources res;// 资源工具
    private OnLineWorkFg fg;

    protected LinearLayout llOnLineWork;// 在线作业
    protected ImageView ivOnLineWork;
    protected TextView tvOnLineWork;

    protected LinearLayout llClassErrorQuestion;// 班级错题
    protected ImageView ivClassErrorQuestion;
    protected TextView tvClassErrorQuestion;

    protected LinearLayout llDataAnalysis;// 数据分析
    protected ImageView ivDataAnalysis;
    protected TextView tvDataAnalysis;

    protected LinearLayout llQuestionBasket;// 试题篮
    protected ImageView ivQuestionBasket;
    protected TextView tvQuestionBasket;

    protected LinearLayout llPersonalCenter;// 个人中心
    protected ImageView ivPersonalCenter;
    protected TextView tvPersonalCenter;
    private CustomViewpager pager;// 滑动布局


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //注意：基类是Activity时参数为android:fragments， 一定要在super.onCreate函数前执行！！！
//       if (savedInstanceState != null) {
//            savedInstanceState.remove("android:support:fragments");
//        }
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);

        // 加入栈
//        ActivityUtils utils = new ActivityUtils();
//        utils.addActivity(this);

//        getWindow().setStatusBarColor(1);

        //如果等于API等于19
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            getWindow().setStatusBarColor(Color.parseColor("#00000000"));
            //设置layout不留出空间
//            drawer.setFitsSystemWindows(false);
        }

        //如果api大于21
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设置状态栏为透明颜色
            getWindow().setStatusBarColor(Color.parseColor("#00000000"));
        }
        res = getResources();

        initBottomBar();
        initViewPager();
        initTvFromPager();
    }


    /**
     * 初始化底部菜单栏
     */
    private void initBottomBar() {
        llOnLineWork = (LinearLayout) findViewById(R.id.ll_wrapper_online_work_layout_activity_main);// 在线作业
        ivOnLineWork = (ImageView) findViewById(R.id.iv_online_work_layout_activity_main);
        tvOnLineWork = (TextView) findViewById(R.id.tv_online_work_layout_activity_main);

        llClassErrorQuestion = (LinearLayout) findViewById(R.id.ll_wrapper_class_error_question_layout_activity_main);// 班级错题
        ivClassErrorQuestion = (ImageView) findViewById(R.id.iv_class_error_question_layout_activity_main);
        tvClassErrorQuestion = (TextView) findViewById(R.id.tv_class_error_question_layout_activity_main);

        llDataAnalysis = (LinearLayout) findViewById(R.id.ll_wrapper_data_analysis_layout_activity_main);// 数据分析
        ivDataAnalysis = (ImageView) findViewById(R.id.iv_data_analysis_exercises_layout_activity_main);
        tvDataAnalysis = (TextView) findViewById(R.id.tv_data_analysis_layout_activity_main);

        llQuestionBasket = (LinearLayout) findViewById(R.id.ll_wrapper_question_basket_layout_activity_main);// 试题篮
        ivQuestionBasket = (ImageView) findViewById(R.id.iv_question_basket_layout_activity_main);
        tvQuestionBasket = (TextView) findViewById(R.id.tv_question_basket_layout_activity_main);

        llPersonalCenter = (LinearLayout) findViewById(R.id.ll_wrapper_personal_center_layout_activity_main);// 个人中心
        ivPersonalCenter = (ImageView) findViewById(R.id.iv_personal_center_layout_activity_main);
        tvPersonalCenter = (TextView) findViewById(R.id.tv_personal_center_layout_activity_main);
    }


    /**
     * 初始化页卡,绑定相关fragment
     */
    @SuppressWarnings("deprecation")
    private void initViewPager() {
        pager = (CustomViewpager) findViewById(R.id.vp_content_layout_activity_main);
        pager.setIfTouchMode(true);
        // 关闭预加载，默认一次只加载一个Fragment，zhaochenhui
        pager.setOffscreenPageLimit(1);

        // 添加Fragment
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fg = new OnLineWorkFg();
        // 在线作业
        fragmentList.add(fg);
        // 班级错题
        fragmentList.add(new ClassErrorQuestionFg());
        //数据分析
        fragmentList.add(new DataAnalysisFg());
        //试题篮
        fragmentList.add(new QuestionBasketFg());
        //个人中心
        fragmentList.add(new PersonalCenterFg());

        // 适配器
        pager.setAdapter(new FragmentVPagerAdapter(getSupportFragmentManager(),
                fragmentList));
        // 设置当前页显示
        pager.setCurrentItem(0);
        // 监听
        pager.setOnPageChangeListener(new EAMainOnPageChangeListener());
    }

    /**
     * 初始化头标
     */
    private void initTvFromPager() {
        llOnLineWork.setOnClickListener(new EAMainOnPageListener(0));
        llClassErrorQuestion.setOnClickListener(new EAMainOnPageListener(1));
        llDataAnalysis.setOnClickListener(new EAMainOnPageListener(2));
        llQuestionBasket.setOnClickListener(new EAMainOnPageListener(3));
        llPersonalCenter.setOnClickListener(new EAMainOnPageListener(4));
    }

    /**
     * 选中底部菜单栏中任一项后的控件展示
     */
    @SuppressWarnings("deprecation")
    private void doAfterBottomBarInFocus(ImageView iv, TextView tv,
                                         int picResId, int colorResId) {
        iv.setBackgroundResource(picResId);
        tv.setTextColor(res.getColor(colorResId));
    }


    /**
     * 主界面底部的viewPager头标监听
     *
     * @author zhaochenhui
     */
    public class EAMainOnPageListener implements View.OnClickListener {
        private int index = 0;

        public EAMainOnPageListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            pager.setCurrentItem(index);
            // modifyTitleBar(index);
        }
    }

    /**
     * 主页面底部页卡偏移事件监听
     */
    private class EAMainOnPageChangeListener implements ViewPager.OnPageChangeListener {
        int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 ->页卡3偏移量
        int three = one * 3;// 1 ->4
        int four = one * 4;

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arriveIndex) {
            Animation animation = null;
            switch (arriveIndex) {
                case 0:// 在线作业
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                        doAfterBottomBarInFocus(ivClassErrorQuestion, tvClassErrorQuestion,
                                R.drawable.error_question_n, R.color.color_text_title);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                        doAfterBottomBarInFocus(ivDataAnalysis, tvDataAnalysis,
                                R.drawable.data_analysis_n, R.color.color_text_title);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, 0, 0, 0);
                        doAfterBottomBarInFocus(ivQuestionBasket, tvQuestionBasket,
                                R.drawable.question_basket_n, R.color.color_text_title);
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(four, 0, 0, 0);
                        doAfterBottomBarInFocus(ivPersonalCenter, tvPersonalCenter,
                                R.drawable.personal_center_n, R.color.color_text_title);
                    }

                    doAfterBottomBarInFocus(ivOnLineWork, tvOnLineWork,
                            R.drawable.work_p, R.color.theme);

                    break;
                case 1:// 班级错题
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                        doAfterBottomBarInFocus(ivOnLineWork, tvOnLineWork,
                                R.drawable.work_n, R.color.color_text_title);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                        doAfterBottomBarInFocus(ivDataAnalysis, tvDataAnalysis,
                                R.drawable.data_analysis_n, R.color.color_text_title);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, one, 0, 0);
                        doAfterBottomBarInFocus(ivQuestionBasket, tvQuestionBasket,
                                R.drawable.question_basket_n, R.color.color_text_title);
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(four, one, 0, 0);
                        doAfterBottomBarInFocus(ivPersonalCenter, tvPersonalCenter,
                                R.drawable.personal_center_n, R.color.color_text_title);
                    }

                    doAfterBottomBarInFocus(ivClassErrorQuestion, tvClassErrorQuestion,
                            R.drawable.error_question_p, R.color.theme);

                    break;
                case 2:// 数据分析
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                        doAfterBottomBarInFocus(ivOnLineWork, tvOnLineWork,
                                R.drawable.work_n, R.color.color_text_title);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                        doAfterBottomBarInFocus(ivClassErrorQuestion, tvClassErrorQuestion,
                                R.drawable.error_question_n, R.color.color_text_title);

                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, two, 0, 0);
                        doAfterBottomBarInFocus(ivQuestionBasket, tvQuestionBasket,
                                R.drawable.question_basket_n, R.color.color_text_title);
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(four, two, 0, 0);
                        doAfterBottomBarInFocus(ivPersonalCenter, tvPersonalCenter,
                                R.drawable.personal_center_n, R.color.color_text_title);
                    }
                    doAfterBottomBarInFocus(ivDataAnalysis, tvDataAnalysis,
                            R.drawable.data_analysis_p, R.color.theme);

                    break;
                case 3:// 试题篮
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, three, 0, 0);

                        doAfterBottomBarInFocus(ivOnLineWork, tvOnLineWork,
                                R.drawable.work_n, R.color.color_text_title);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, three, 0, 0);
                        doAfterBottomBarInFocus(ivClassErrorQuestion, tvClassErrorQuestion,
                                R.drawable.error_question_n, R.color.color_text_title);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, three, 0, 0);
                        doAfterBottomBarInFocus(ivDataAnalysis, tvDataAnalysis,
                                R.drawable.data_analysis_n, R.color.color_text_title);
                    } else if (currIndex == 4) {
                        animation = new TranslateAnimation(four, three, 0, 0);
                        doAfterBottomBarInFocus(ivPersonalCenter, tvPersonalCenter,
                                R.drawable.personal_center_n, R.color.color_text_title);
                    }
                    doAfterBottomBarInFocus(ivQuestionBasket, tvQuestionBasket,
                            R.drawable.question_basket_p, R.color.theme);
                    break;

                case 4:// 个人中心
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, four, 0, 0);

                        doAfterBottomBarInFocus(ivOnLineWork, tvOnLineWork,
                                R.drawable.work_n, R.color.color_text_title);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, four, 0, 0);
                        doAfterBottomBarInFocus(ivClassErrorQuestion, tvClassErrorQuestion,
                                R.drawable.error_question_n, R.color.color_text_title);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, four, 0, 0);
                        doAfterBottomBarInFocus(ivDataAnalysis, tvDataAnalysis,
                                R.drawable.data_analysis_n, R.color.color_text_title);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, four, 0, 0);
                        doAfterBottomBarInFocus(ivQuestionBasket, tvQuestionBasket,
                                R.drawable.question_basket_n, R.color.color_text_title);
                    }
                    doAfterBottomBarInFocus(ivPersonalCenter, tvPersonalCenter,
                            R.drawable.personal_center_p, R.color.theme);
                    break;
            }

            currIndex = arriveIndex;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            // 控制滑动标记的滑动，暂用不到
            // cursor.startAnimation(animation);
        }
    }

//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(null);
////        Parcelable p = fg.saveAllState();
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (fg != null) {
            fg.onDestroy();
        }
    }
}
