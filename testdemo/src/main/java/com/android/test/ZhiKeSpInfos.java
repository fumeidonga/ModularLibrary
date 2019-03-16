package com.android.test;

import java.util.List;

public class ZhiKeSpInfos {


    /**
     * 保存时间
     * 保存的信息
     */
    public static class ZhikeSpAdInfoList {

        /** 保存的时间 */
        public String saveTimeValue;
        public List<ZhikeFeedAdInfo> zhikeFeedAdInfos;

        public String getSaveTimeValue() {
            return saveTimeValue;
        }

        public void setSaveTimeValue(String saveTimeValue) {
            this.saveTimeValue = saveTimeValue;
        }

        public List<ZhikeFeedAdInfo> getZhikeFeedAdInfos() {
            return zhikeFeedAdInfos;
        }

        public void setZhikeFeedAdInfos(List<ZhikeFeedAdInfo> zhikeFeedAdInfos) {
            this.zhikeFeedAdInfos = zhikeFeedAdInfos;
        }

        @Override
        public String toString() {
            return "ZhikeSpAdInfoList{" +
                    "saveTimeValue='" + saveTimeValue + '\'' +
                    ", zhikeFeedAdInfos=" + zhikeFeedAdInfos +
                    '}';
        }
    }

    /**
     * 保存 直客相关信息
     * 比如次数、时间等
     */
    public static class ZhikeFeedAdInfo {

        /** 广告id */
        public String adv_id;

        /** 每天显示的次数 */
        public long show_frequency;
        /** 间隔时间，分钟 */
        public long interval_time;


        public String getAdv_id() {
            return adv_id;
        }

        public void setAdv_id(String planid) {
            this.adv_id = planid;
        }

        public long getShow_frequency() {
            return show_frequency;
        }

        public void setShow_frequency(long show_frequency) {
            this.show_frequency = show_frequency;
        }

        public long getInterval_time() {
            return interval_time;
        }

        public void setInterval_time(long show_time) {
            this.interval_time = show_time;
        }

        @Override
        public String toString() {
            return "ZhikeFeedAdInfo{" +
                    "adv_id='" + adv_id + '\'' +
                    ", show_frequency=" + show_frequency +
                    ", interval_time=" + interval_time +
                    '}';
        }
    }

    /**
     * 保存包名
     */
    public static class ZhiKeInstallPkg {

        public List<String> packages;

        public List<String> getPackages() {
            return packages;
        }

        public void setPackages(List<String> packages) {
            this.packages = packages;
        }

        @Override
        public String toString() {
            return "ZhiKeInstallPkg{" +
                    "packages=" + packages +
                    '}';
        }
    }
}
