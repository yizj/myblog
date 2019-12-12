package com.zjl.myblog.global;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.constant.ViewConsts;
import com.zjl.myblog.util.BaseResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:jlzhang
 * @Description: 全局异常处理器
 * @Date:Created in 2019/10/31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e)
    {
        return BaseResponseUtil.error(e.getLocalizedMessage(),ViewConsts.ERROR_CODE);
    }
}
