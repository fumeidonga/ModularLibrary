package com.android.test;

/**
 * 服务端接口基础响应描述类
 * Created by ZG on 2018/6/13.
 */
public class BaseResponse {
    /**
     * 错误信息返回
     */
    public Errors errors;

    public Errors getErrors() {
        return errors;
    }
    /**
     * 错误信息
     */
    public class Errors {
        /**
         * 错误表id
         */
        public String id;
        /**
         * 状态值 固定为"200"
         */
        public String status;
        /**
         * 错误信息
         */
        public String title;
        /**
         * 详细错误
         */
        public String details;
        /**
         * 服务端定义的错误码
         */
        public int code;

        public String getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }

        public String getTitle() {
            return title;
        }

        public String getDetail() {
            return details;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "Errors{" +
                    "id='" + id + '\'' +
                    ", status='" + status + '\'' +
                    ", title='" + title + '\'' +
                    ", detail='" + details + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

}
