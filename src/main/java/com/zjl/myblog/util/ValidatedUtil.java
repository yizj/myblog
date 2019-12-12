package com.zjl.myblog.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/10/31
 */
public class ValidatedUtil {

    /**
     *@Description: 解析校验返回消息
     *@Date: 2019/10/31 21:39
     *@Param:
     *@Return:
     */
    public static void getBindingResult(BindingResult bindingResult) throws Exception {
        List<String> errors=new ArrayList<>();
        if(bindingResult.hasErrors()) {
            List<ObjectError> objectErrors=bindingResult.getAllErrors();
            for(ObjectError objectError:objectErrors)
            {
                errors.add(objectError.getDefaultMessage());
            }
        }

        if(errors.size()>0) {
            StringBuilder stringBuilder=new StringBuilder();
            for(String s:errors)
            {
                stringBuilder.append(s);
            }
            throw new Exception(stringBuilder.toString());
        }
    }
}
