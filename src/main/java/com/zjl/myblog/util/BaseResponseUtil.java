package com.zjl.myblog.util;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.constant.ViewConsts;

/**
 * @author zjl
 * @description 基础类返回工具
 * @data 2019/10/30
 */
public class BaseResponseUtil {

    public static BaseResponse success(Object object, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ViewConsts.SUCCESS_CODE);
        baseResponse.setMsg(msg);
        baseResponse.setData(object);
        return baseResponse;
    }

    public static BaseResponse error(String msg, Integer code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMsg(msg);
        return baseResponse;
    }
}
