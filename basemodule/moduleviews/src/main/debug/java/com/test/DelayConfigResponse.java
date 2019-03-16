package com.test;

/**
 * 延迟的配置
 */
public class DelayConfigResponse extends BaseResponse {

    public Data data;

    public Data getData() {
        return data;
    }

    public class Data {

        /**
         * 是否新设备
         * 0 否 . 1 是
         */
        public int is_new_device;
        /**
         * 是否显示广告 0-不显示；1-显示
         */
        public int is_show_ad;

        public LogoutSetting logout_setting;

        /** AB测试分组 **/
        public int ab_group = -1;

        @Override
        public String toString() {
            return "Data{" +
                    "is_new_device=" + is_new_device +
                    ", logout_setting=" + logout_setting +
                    ", is_show_ad=" + is_show_ad +
                    '}';
        }
    }

    /**
     * 退出登录文案
     */
    public static class LogoutSetting {
        //新设备未登录
        /**
         * 图标
         */
        public String new_device_nologin_icon;
        /**
         * 描述
         */
        public String new_device_nologin_info;
        /**
         * 跳转地址
         */
        public String new_device_nologin_link_url;
        /**
         * 新用户使用的标题
         */
        public String new_device_nologin_title;

        //登录未签到
        /**
         * 标题
         */
        public String login_nocheckin_icon;
        public String login_nocheckin_info;
        public String login_nocheckin_link_url;
        public String login_nocheckin_title;

        //其他情况
        public String title;

        //0退出 1下载
        public int showStyle;

        @Override
        public String toString() {
            return "LogoutSetting{" +
                    "new_device_nologin_icon='" + new_device_nologin_icon + '\'' +
                    ", new_device_nologin_info='" + new_device_nologin_info + '\'' +
                    ", new_device_nologin_link_url='" + new_device_nologin_link_url + '\'' +
                    ", new_device_nologin_title='" + new_device_nologin_title + '\'' +
                    ", login_nocheckin_title='" + login_nocheckin_title + '\'' +
                    '}';
        }
    }
}
