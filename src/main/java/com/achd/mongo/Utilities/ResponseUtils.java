package com.achd.mongo.Utilities;

import com.achd.mongo.Entity.WebResponse;

public class ResponseUtils {

    public static WebResponse getResponse(ResponseMessage responseMessage) {
        return getResponse(responseMessage,null);
    }

    public static WebResponse getResponse(ResponseMessage responseMessage, Object data) {
        return new WebResponse(responseMessage.getStatus(),responseMessage.getMessage(),data);
    }

    public enum ResponseMessage {

        NAME_ERROR(1, "姓名错误"),
        GENDER_ERROR(1, "性别错误"),

        SUCCESS(0,"成功"),
        SERVER_FAIL(-1, "服务器错误");

        private Integer status;
        private String message;

        ResponseMessage(Integer status, String message) {
            this.status = status;
            this.message = message;
        }

        public Integer getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
