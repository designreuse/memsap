package com.we.sdk.memsap.base.result;

import java.util.Objects;

public class RestResultGenerator {


    public static <T> RestResult<T> createResult(Integer code, String msg, T data) {

        RestResult<T> result = RestResult.newInstance();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> RestResult<T> createOkResult() {
        return createResult(RestResult.CODE_OK, "操作成功", null);
    }

    /**成功，默认提示*/
    public static <T> RestResult<T> createOkResult(T data) {
        return createResult(RestResult.CODE_OK, "操作成功", data);
    }


    /**成功，自定义提示*/
    public static <T> RestResult<T> createOkResult(String msg, T data) {
        return createResult(RestResult.CODE_OK, msg, data);
    }

    /**失败，默认提示*/
    public static <T> RestResult<T> createFailResult() {
        return createResult(RestResult.CODE_FAIL, "操作失败", null);
    }

    /**失败，自定义提示*/
    public static <T> RestResult<T> createFailResult(String msg) {
        return createResult(RestResult.CODE_FAIL, msg, null);
    }

    /**失败，自定义提示 & 返回失败详情*/
    public static <T> RestResult<T> createFailResult(String msg, T data) {
        return createResult(RestResult.CODE_FAIL, msg, data);
    }

    public static RestResult getResult(RestResult temp, String msg) {
        RestResult result;
        if (Objects.equals(temp.getCode(), RestResult.CODE_OK)) {
            result = RestResultGenerator.createOkResult(msg);
        } else {
            if (temp.getData() == null) {
                result = RestResultGenerator.createFailResult(temp.getMsg(), temp.getMsg());
            } else {
                result = RestResultGenerator.createFailResult(temp.getMsg(), temp.getData());
            }
        }
        return result;
    }

}
