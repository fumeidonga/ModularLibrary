package com.android.test;

import java.util.List;

/**
 */
public class ZhiKeResponseEntity extends BaseResponse {

    public ZhikeAdData data;

    @Override
    public String toString() {
        return "ZhiKeResponseEntity{" +
                "data=" + data +
                '}';
    }

    public static class ZhikeAdData {

        /** 广告数据 */
        public List<ApiFeedAd> list;

        @Override
        public String toString() {
            return "ZhikeAdData{" +
                    "list=" + list +
                    '}';
        }
    }

}
