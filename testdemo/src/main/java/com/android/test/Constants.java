package com.android.test;

/**
 * 常量管理
 *
 * Created by Administrator on 2018/7/2.
 */

public class Constants {


    /** 数据存储所用Key */
    public static class SHARE_PREFER {
        /** 第一次打开书架界面 **/
        public static final String KEY_IS_FIRST_SHELF = "KEY_IS_FIRST_SHELF";
        /** 获取是否第一次引导 */
        public static final String KEY_IS_FIRST_GUIDE = "is_first_guide_km";
        /** 是否从升级过来的 */
        public static final String KEY_IS_UPDATE = "is_update";
        public static final String KEY_HAVA_UPDATE = "haveUpdate";

        /** 是否在MIUI上设置过悬浮窗权限 */
        public final static String KEY_IS_EYE_PROTECT_SETTED_IN_MIUI = "is_eye_protect_setted_in_miui";

        /** 获取是否是系统亮度，用户设置过亮度后，其对应的值设为false */
        public final static String KEY_IS_SYS_BRIGHTNESS = "is_sys_brightness";
        public final static String KEY_IS_SYS_NIGHT_BRIGHTNESS = "is_sys_night_brightness";
        public final static String KEY_BG_VALUE = "bg_value";
        /** 字体路径 **/
        public final static String KEY_CURRENT_FONT_PATH = "current_font_path";
        /** 字体样式 **/
        public final static String KEY_FONT_CACHE_DATA = "font_cache_data";
        /** 字体样式最近一次更新时间 **/
        public final static String KEY_FONT_UPDATE_SUCCESS_TIME = "font_update_success_time";

        /** 获取是否护眼模式 */
        public final static String KEY_IS_EYE_PROTECT = "is_eye_protect";

        /** 护眼相关 **/
        public final static String KEY_READ_LIGHT_TIME = "read_light_time";

        /** 第一次打开阅读器 **/
        public final static String KEY_IS_FIRST_START = "is_first_start";

        /** 我的小红点 */
        public static final String KEY_HAVA_REMIND = "hava_remind";

        /** 初始化配置-首次打开 */
        public final static String KEY_FIRST_LAUNCH_CONFIG_FLAG = "KEY_FIRST_LAUNCH_CONFIG_FLAG";
        /** 默认书籍 */
        public final static String KEY_DEFAULT_BOOKS = "KEY_DEFAULT_BOOKS";
        /** 兑换汇率 */
        public final static String KEY_EXCHANGE_RATES = "KEY_EXCHANGE_RATES";
        /** 新手红包金额 */
        public final static String KEY_RED_ENVELOPES_AMOUNT = "KEY_RED_ENVELOPES_AMOUNT";
        /** QQ群号key */
        public final static String KEY_QQ_GROUP_KEY = "KEY_QQ_GROUP_KEY";
        /** QQ群号ID */
        public final static String KEY_QQ_GROUP_ID = "KEY_QQ_GROUP_ID";
        /** 隐私协议地址 */
        public final static String KEY_PRIVACY_PROTOCOL_URL = "KEY_PRIVACY_PROTOCOL_URL";
        /** 用户协议地址 */
        public final static String KEY_USER_PROTOCOL_URL = "KEY_USER_PROTOCOL_URL";
        /** 任务列表请求地址 */
        public final static String KEY_TASK_URL = "KEY_TASK_URL";
        /** 一元提现接口地址 */
        public final static String ONE_YUAN_GET_CASH_URL = "ONE_YUAN_GET_CASH_URL";

        /** 活动分享的图片地址 */
        public final static String KEY_SPLASH_AD_IMAGE = "KEY_SPLASH_AD_IMAGE";

        /** 打开应用的日期 */
        public final static String KEY_OPEN_APP_DATE = "KEY_OPEN_APP_DATE";
        /** 小红点列表 */
        public final static String KEY_RED_POINT = "KEY_RED_POINT";
        /** 金币兑换汇率 **/
        public final static String KEY_EXCHANGE_RATE = "KEY_EXCHANGE_RATE";
        /** 定时金币奖励开关 **/
        public final static String KEY_TIMING_REWARD_SWITCH = "KEY_TIMING_REWARD_SWITCH";
        /** 定时金币奖励时长 **/
        public final static String KEY_TIMING_REWARD_SECOND = "KEY_TIMING_REWARD_SECOND";
        /** 定时金币奖励最高奖励 **/
        public final static String KEY_TIMING_MAX_REWARD_COIN = "KEY_TIMING_MAX_REWARD_COIN";
        /** 定时金币奖励每日最高累计阅读时长 **/
        public final static String KEY_TIMING_MAX_READING_TIME = "KEY_TIMING_MAX_READING_TIME";
        /** 我的钱包链接 */
        public final static String KEY_MY_WALLET_COIN_URL = "KEY_MY_WALLET_COIN_URL";
        /** 我的零钱链接 */
        public final static String KEY_MY_WALLET_CASH_URL = "KEY_MY_WALLET_CASH_URL";
        /** 我的钱包默认链接 */
        public final static String MY_WALLET_COIN_URL_DEFAULT = "freereader://mywallet?param={url='https://xiaoshuo.km.com/h5/v1/wallet/index?type=1', cache_mode=2}";
        /** 我的零钱默认链接 */
        public final static String MY_WALLET_CASH_URL_DEFAULT = "freereader://mywallet?param={url='https://xiaoshuo.km.com/h5/v1/wallet/index?type=2', cache_mode=2}";
        /** 是否开启网赚功能 */
        public final static String KEY_NET_PROFIT_OPEN_STATUS = "KEY_NET_PROFIT_OPEN_STATUS";
        /** 是否开启网赚功能(缓存状态开关) */
        public final static String KEY_NET_PROFIT_OPEN_CACHE_STATUS = "KEY_NET_PROFIT_OPEN_CACHE_STATUS";
        /** 活跃度统计时间 */
        public final static String KEY_ACTIVE_RECORD_DATE = "KEY_ACTIVE_RECORD_DATE";
        /** 发送手机号验证码时间 */
        public final static String KEY_SEND_CAPTCHA_TIME = "KEY_SEND_CAPTCHA_TIME";
        /** 搜索空值页跳转
         *  1 开启去 H5
         *  2 关闭去书城
         * */
        public final static String KEY_SEARCH_HELP_LINK = "KEY_SEARCH_HELP_LINK";
        /**
         * 数美浏览事件开关
         */
        public final static String KEY_SHUMEI_BROWSE_SWITCH = "KEY_SHUMEI_BROWSE_SWITCH";
        /** 是否开启了夜间模式 */
        public final static String KEY_ENABLE_NIGHT = "mEnableNight";

        /** 是否弹出过通知栏弹窗*/
        public final static String KEY_NOTIFICATION_DIALOG = "KEY_NOTIFICATION_DIALOG";

        /** 全本下载开关 **/
        public final static String KEY_FULL_DOWNLOAD_SWITCH = "KEY_FULL_DOWNLOAD_SWITCH";

        /** 全局预加载网页，以提示网页打开速度 */
        public final static String KEY_INIT_CSS_JS_URL = "KEY_INIT_CSS_JS_URL";
        /** 阅读器弹层文案-登录状态下 */
        public final static String KEY_READER_POPUP_TITLE = "KEY_READER_POPUP_TITLE";
        /** 阅读器弹层文案-未登录状态下 */
        public final static String KEY_READER_POPUP_NOLOGIN_TITLE = "KEY_READER_POPUP_NOLOGIN_TITLE";

        /** 主页各页面弹出插屏的次数 */
        public final static String KEY_HOME_SCREEN_POPUP_COUNT = "KEY_HOME_SCREEN_POPUP_COUNT_";
        /** 主页弹出插屏的时间戳 */
        public final static String KEY_HOME_SCREEN_POPUP_TIME = "KEY_HOME_SCREEN_POPUP_TIME";
        /** 红包弹窗图片地址 */
        public final static String KEY_HOME_BONUS_IMG = "KEY_HOME_BONUS_IMG";
        /** 红包弹窗按钮图片地址 */
        public final static String KEY_HOME_BONUS_BUTTON = "KEY_HOME_BONUS_BUTTON";
        /** 红包弹窗图片点击统计字段 */
        public final static String KEY_HOME_BONUS_BACKDROP_STATISTICAL_CODE = "KEY_HOME_BONUS_BACKDROP_STATISTICAL_CODE";
        /** 红包弹窗按钮点击统计字段 */
        public final static String KEY_HOME_BONUS_BUTTON_STATISTICAL_CODE = "KEY_HOME_BONUS_BUTTON_STATISTICAL_CODE";

        /** 退出应用时的json */
        public final static String KEY_APP_EXIT_JSON = "KEY_APP_EXIT_JSON";
        /** 是否新设备 */
        public final static String KEY_APP_IS_NEW_DEVICE = "KEY_APP_IS_NEW_DEVICE";
        /** 是否展示浮层广告 */
        public final static String KEY_APP_IS_SHOW_AD = "KEY_APP_IS_SHOW_AD";
        /** 是否签到 */
        public final static String KEY_APP_IS_SIGN_IN = "KEY_APP_IS_SIGN_IN";
        /** 用户会员标识 */
        public final static String KEY_IS_VIP = "KEY_IS_VIP";
        /** 新手红包配置 */
        public final static String NEW_PACKAGE_BUTTON = "new_package_button";
        /** 会员支付页面链接 */
        public final static String KEY_VIP_PAY_URL = "KEY_VIP_PAY_URL";
        /** 体验无广告页面链接 */
        public final static String KEY_EXPERIENCE_NO_AD_URL = "KEY_EXPERIENCE_NO_AD_URL";
        /** 是否屏蔽广告 */
        public final static String KEY_IS_ADV_DENY = "KEY_IS_ADV_DENY";
        /** VIP去广告样式 */
        public final static String KEY_AD_CLOSE_STYLE = "KEY_AD_CLOSE_STYLE";
        /** 阅读器内部大图VIP去广告样式 */
        public final static String KEY_AD_READER_CLOSE_STYLE = "KEY_AD_READER_CLOSE_STYLE";
        /** 主页各页面浮层广告关闭次数 */
        public final static String KEY_HOME_FLOAD_AD_CLOSE_COUNT = "KEY_HOME_FLOAD_AD_CLOSE_COUNT_";
        /** 应用下载安装后未领取奖励的任务 */
        public final static String KEY_APP_DOWN_IDS = "KEY_APP_DOWN_IDS";
        /** 观看激励视频后，总共能看多少时间长的书 **/
        public final static String KEY_READER_FREE_TIME_DURATION = "KEY_READER_FREE_TIME_DURATION";
        /** 观看激励视频后，去广告看书的开始时间 **/
        public final static String KEY_READER_FREE_TIME_START = "KEY_READER_FREE_TIME_START";
        /** 观看激励视频后，去广告看书的服务端的开始时间 **/
        public final static String KEY_READER_FREE_SERVER_TIME_START = "KEY_READER_FREE_SERVER_TIME_START";
        /** 激励视频是否播放完成 */
        public final static String KEY_REWARD_VIDEO_PLAY_STATUS = "KEY_REWARD_VIDEO_PLAY_STATUS";
        /** 支付页面激励视频是否已完成 */
        public final static String KEY_VIP_CHANCE_REWARD_VIDEO_COMPLETE_DAILY = "KEY_VIP_CHANCE_REWARD_VIDEO_COMPLETE_DAILY";
        /** 支付包激活状态 */
        public final static String KEY_ALIPAY_ACTIVATE = "KEY_ALIPAY_ACTIVATE";
        /** 登录引导文案 */
        public final static String KEY_LOGIN_GUIDE_TXT = "LOGIN_GUIDE_TXT";
        /** 登录按钮文案 */
        public final static String KEY_LOGIN_BUTTON_TXT = "LOGIN_BUTTON_TXT";
        /** 登录预计收益文案 */
        public final static String KEY_LOGIN_EARNING_TXT = "LOGIN_EARNING_TXT";
        /** 登录slogan */
        public final static String KEY_LOGIN_SLOGAN_TXT = "KEY_LOGIN_SLOGAN_TXT";
        /** 阅读器底部关闭广告按钮是否显示 1：显示 0：隐藏 **/
        public final static String KEY_READER_BOTTOM_AD_CLOSE_DISPLAY = "KEY_READER_BOTTOM_AD_CLOSE_DISPLAY";
        /** 签到页链接 **/
        public final static String KEY_SIGN_IN_URL = "KEY_SIGN_IN_URL";
        /** 扫描用户设备应用信息记录 **/
        public final static String KEY_SCAN_USER_DEVICE_APP_RECORD = "KEY_SCAN_USER_DEVICE_APP_RECORD";

        /** 广告下载包名 */
        public static final String KEY_AD_ZHIKE_PACKAGENAME = "KEY_AD_ZHIKE_PACKAGENAME";
        /** 广告显示次数，时间间隔等 */
        public static final String KEY_AD_ZHIKE_FEED_AD_INFO = "KEY_AD_ZHIKE_FEED_AD_INFO";
        public static final String KEY_AD_ZHIKE_INSTALL_FINISH_URL = "KEY_AD_ZHIKE_INSTALL_FINISH_URL";
    }

}
