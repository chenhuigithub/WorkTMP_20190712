package com.example.worktmp.utils;

/**
 * 终端自定义常量类
 * 
 * @author Administrator
 * 
 */

public class ConstantsUtils {
	/**
	 * 当前用户身份key值（其对应的value值意义为：-1:未登录/3:学生/1:老师/2:家长/0:培训机构）
	 */
	public static final String KEY_USER_IDENTITY = "KEY_USER_IDENTITY";

	/**
	 * 未登录
	 */
	public static final String VALUE_NOT_LOGIN = "-1";
	/**
	 * 学生
	 */
	public static final String VALUE_STUDENT = "3";
	/**
	 * 老师
	 */
	public static final String VALUE_TEACHER = "1";
	/**
	 * 家长
	 */
	public static final String VALUE_PARENT = "2";
	/**
	 * 培训机构
	 */
	public static final String VALUE_ORGAN = "0";

	/**
	 * Token,用户唯一性标志
	 */
	public static final String KEY_USER_TOKEN = "KEY_USER_TOKEN";
	/**
	 * username,用户名
	 */
	public static final String KEY_USER_LOGIN_NAME = "KEY_USER_LOGIN_NAME";
	/**
	 * 登录密码
	 */
	public static final String KEY_USER_LOGIN_PASSWARD = "KEY_USER_LOGIN_PASSWARD";
	/**
	 * userid,用户id
	 */
	public static final String KEY_USER_ID = "KEY_USER_ID";
	/**
	 * truename,真实姓名
	 */
	public static final String KEY_USER_TRUE_NAME = "KEY_USER_TRUE_NAME";
	/**
	 * nickname,用户昵称
	 */
	public static final String KEY_USER_NICK_NAME = "KEY_USER_NICK_NAME";
	/**
	 * 用户头像名称(例如：A.png)
	 */
	public static final String KEY_USER_PIC_LOGO_NAME = "KEY_USER_PIC_LOGO_NAME";

	/**
	 * 是否自动登录,默认为不自动
	 */
	public static final String KEY_IS_AUTOMATIC_LOGIN = "no";

	/**
	 * Aliy OSS endpoint
	 */
	public static String KEY_OSS_ENDPOINT = "KEY_OSS_ENDPOINT";

	/**
	 * Access Key ID（简称ID）
	 */
	public static String KEY_OSS_ACCESS_ID = "KEY_OSS_ACCESS_ID";

	/**
	 * Access Key Secret（简称KEY）
	 */
	public static String KEY_OSS_ACCESS_KEY = "KEY_OSS_ACCESS_KEY";

	/**
	 * 存储图片的Bucket
	 */
	public static String KEY_OSS_IMAGE_BUCKET = "KEY_OSS_IMAGE_BUCKET";
	/**
	 * 存储普通文件Bucket
	 */
	public static String KEY_OSS_FILE_BUCKET = "KEY_OSS_FILE_BUCKET";
	/**
	 * 存储视频文件的Bucket
	 */
	public static String KEY_OSS_VIDEO_BUCKET = "KEY_OSS_VIDEO_BUCKET";
	/**
	 * 存储音频文件Bucket
	 */
	public static String KEY_OSS_AUDIO_BUCKET = "KEY_OSS_AUDIO_BUCKET";

	public static String KEY_OSS_RESOURCES_BUCKET = "KEY_OSS_RESOURCES_BUCKET";

	/**
	 * yes
	 */
	public static final String VALUE_YES = "yes";

	/**
	 * no
	 */
	public static final String VALUE_NO = "no";

	/**
	 * 广播消息：刷新课程信息展示
	 */
	public static final String ACTION_REFRESH_COURSES = "ACTION_REFRESH_COURSES";
	/**
	 * 是否首次运行程序
	 */
	public static final String IS_FIRST_RUN = "IS_FIRST_RUN";

	/**
	 * 广播消息：标志当前是哪个fragment
	 */
	public static final String ACTION_WHICH_FG = "ACTION_WHICH_FG";
	/**
	 * 广播消息：获取用户信息
	 */
	public static final String ACTION_OBTAIN_USER_INFO = "ACTION_OBTAIN_USER_INFO";
	/**
	 * 广播：刷新显示闯关关卡的进度
	 */
	public static String ACTION_REFRESH_DIFFICULTY_PROGRESS = "ACTION_REFRESH_DIFFICULTY_PROGRESS";

	/**
	 * 学段编号
	 */
	public static String EXTRA_STUDY_PEROID_CODE = "EXTRA_STUDY_PEROID_CODE";
	/**
	 * 学科编号
	 */
	public static String EXTRA_SUBJECT_CODE = "EXTRA_SUBJECT_CODE";
	/**
	 * 区域编号层级列表
	 */
	public static String EXTRA_ALL_AREA_CODE_LIST = "EXTRA_ALL_AREA_CODE_LIST";

	/**
	 * 是否被推荐
	 */
	public static String EXTRA_IS_RECOMMEND = "EXTRA_IS_RECOMMEND";

	/**
	 * 支付成功
	 */
	public static final String ACTION_PAY_SUCCESSFULLY = "ACTION_PAY_SUCCESSFULLY";
	/**
	 * 支付失败
	 */
	public static final String ACTION_PAY_FAILED = "ACTION_PAY_FAILED";
	/**
	 * 支付结果待确认
	 */
	public static final String ACTION_PAY_TO_BE_CONFIRMED = "ACTION_PAY_TO_BE_CONFIRMED";

	/**
	 * 登录成功
	 */
	public static final String ACTION_LOGIN_SUCCEED = "ACTION_LOGIN_SUCCEED";
	/**
	 * 退出登录
	 */
	public static final String ACTION_EXIT_LOGIN = "ACTION_EXIT_LOGIN";

	/**
	 * 从扫二维码界面返回结果
	 */
	public static final String ACTION_SCAN_QR_CODE_RESULT = "ACTION_SCAN_QR_CODE_RESULT";

	/**
	 * 练习题-章节分页中显示题目章节信息
	 */
	public static int SHOW_CHAPTER_DATA = 1001;
	/**
	 * 练习题-知识点分页中显示知识点信息
	 */
	public static int SHOW_KNOWLEDGE_POINT = 1002;
	/**
	 * 练习题-套卷分页中显示题目试卷信息
	 */
	public static int SHOW_TEST_PAPER = 1003;
	/**
	 * 关闭弹出的加载框
	 */
	public static int DISMISS_DIALOG = 1004;

	/**
	 * 支付宝付款界面返回给选择支付方式界面的标志requestCode(写到此工具类中是为了避免值重复)
	 */
	public static int REQUEST_CODE_FROM_ALIY_PAY_PAGE = 1111;
	/**
	 * 微信付款界面返回给选择支付方式界面的标志requestCode(写到此工具类中是为了避免值重复)
	 */
	public static int REQUEST_CODE_FROM_WE_CHAT_PAY_PAGE = 1112;

	/**
	 * 从答题情况界面返回答题界面的标志
	 */
	public static final int REQUEST_CODE_TO_STATE_ACTIVITY = 1113;

	/**
	 * 关闭此页面
	 */
	public static String FINISH_THIS = "FINISH_THIS";

	/**
	 * 视频类型
	 */
	public static String FILE_TYPE_FOR_VIDEO = "0";
	/**
	 * 音频类型
	 */
	public static String FILE_TYPE_FOR_AUDIO = "1";
	/**
	 * 文档：flash格式
	 */
	public static String FILE_TYPE_FOR_FLASH = "2";

	/**
	 * 答案解析
	 */
	public final static String ACTION_GO_TO_ANSWER_ANALYSIS = "ACTION_GO_TO_ANSWER_ANALYSIS";
	/**
	 * 继续做题
	 */
	public final static String ACTION_CONTINUE_EXTERCISE = "ACTION_CONTINUE_EXTERCISE";
	/**
	 * 关闭回跳的页面
	 */
	public final static String ACTION_FINISH = "ACTION_FINISH";

	/**
	 * 从拍照界面回跳至主界面
	 */
	public final static int REQUEST_CODE_TO_MAIN = 1114;

	/**
	 * 压缩前的图片存储路径（key值）
	 */
	public final static String KEY_PIC_URI = "KEY_PIC_URI";

	/**
	 * 选择的教材、目录
	 */
	public final static String ACTION_MATERIAL_CHOICED = "ACTION_MATERIAL_CHOICED";

	/**
	 * 教材、目录列表数据
	 */
	public final static String MATERIAL_LIST = "MATERIAL_LIST";

	public final static String SHOW_TYPE = "SHOW_TYPE";

	/**
	 * token
	 */
	public static final String TOKEN = "token";

	/**
	 * 用户信息
	 */
	public static final String USER = "USER";

	/**
	 * ID
	 */
	public static final String ID = "ID";

	/**
	 * 是否已登录 HAS_LOGINED
	 */
	public static final String HAS_LOGINED = "HAS_LOGINED";

	/**
	 * 用户登录名 USER_LOGIN_NAME
	 */
	public static final String USER_LOGIN_NAME = "USER_LOGIN_NAME";

	/**
	 * 用户登录密码 USER_LOGIN_PSD
	 */
	public static final String USER_LOGIN_PSD = "USER_LOGIN_PSD";

	/**
	 * 用户头像 USER_LOGO
	 */
	public static final String USER_LOGO = "USER_LOGO";
}
