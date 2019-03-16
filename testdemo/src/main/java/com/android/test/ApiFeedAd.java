package com.android.test;

import java.util.List;

public class ApiFeedAd {
    /** 位置_标识  统计用 */
    public String adv_code;
    /** 素材地址 */
    public List<ImageInfo> image_list;
    /** 标题 默认空字符串 */
    public String title = "";
    /** 内容 默认空字符串 */
    public String desc = "";
    /** 广告id */
    public String adv_id;
    /** 点击跳转地址 */
    public String link_url;
    /** 广告展示成功回调地址，(必须在客户端发起) */
    public String show_url;
    /** 广告点击回调地址。(必须在客户端发起) */
    public String click_url;
    /** 下载类广告,开始下载时回调。(dev_time:本地时间戳，单位秒) */
    public String sdown_url;
    /** 下载类广告,结束下载时回调。(dev_time:本地时间戳，单位秒) */
    public String edown_url;
    /** 下载类广告,完成安装时回调。(dev_time:本地时间戳，单位秒，packagename：安装包名) */
    public String finish_url;
    /** 1：是落地页 2：直连 */
    public int adv_type;
    /** 包名 */
    public String package_name;
    /** 每天显示的次数 */
    public int show_frequency;
    /** 间隔时间，分钟 */
    public int interval_time;

    public String getAdv_code() {
        return adv_code;
    }

    public void setAdv_code(String adv_code) {
        this.adv_code = adv_code;
    }

    public List<ImageInfo> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageInfo> image_list) {
        this.image_list = image_list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAdv_id() {
        return adv_id;
    }

    public void setAdv_id(String adv_id) {
        this.adv_id = adv_id;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getShow_url() {
        return show_url;
    }

    public void setShow_url(String show_url) {
        this.show_url = show_url;
    }

    public String getClick_url() {
        return click_url;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }

    public String getSdown_url() {
        return sdown_url;
    }

    public void setSdown_url(String sdown_url) {
        this.sdown_url = sdown_url;
    }

    public String getEdown_url() {
        return edown_url;
    }

    public void setEdown_url(String edown_url) {
        this.edown_url = edown_url;
    }

    public String getFinish_url() {
        return finish_url;
    }

    public void setFinish_url(String finish_url) {
        this.finish_url = finish_url;
    }

    public int getAdv_type() {
        return adv_type;
    }

    public void setAdv_type(int adv_type) {
        this.adv_type = adv_type;
    }

    public String getPackagename() {
        return package_name;
    }

    public void setPackagename(String packagename) {
        this.package_name = packagename;
    }

    public int getShow_frequency() {
        return show_frequency;
    }

    public void setShow_frequency(int show_frequency) {
        this.show_frequency = show_frequency;
    }

    public int getInterval_time() {
        return interval_time;
    }

    public void setInterval_time(int interval_time) {
        this.interval_time = interval_time;
    }

    public static class ImageInfo{

        /** 素材序号 */
        public String image_id;
        /** 图片宽 */
        public float width;
        /** 图片高 */
        public float height;
        /** 媒体地址 */
        public String image_url;

        public String getImage_id() {
            return image_id;
        }

        public void setImage_id(String image_id) {
            this.image_id = image_id;
        }

        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }

    @Override
    public String toString() {
        return "ApiFeedAd{" +
                "adv_id='" + adv_id + '\'' +
                '}';
    }
}
