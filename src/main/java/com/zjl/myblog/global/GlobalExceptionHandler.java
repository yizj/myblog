package com.zjl.myblog.global;

import com.zjl.myblog.api.BaseResponse;
import com.zjl.myblog.utils.BaseResponseUtil;
import com.zjl.myblog.utils.ConstantUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.jws.WebResult;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

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
        return BaseResponseUtil.error(e.getLocalizedMessage(), ConstantUtils.ERRORCODE);
    }
}
