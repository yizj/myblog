package com.zjl.myblog.aspect;

import com.zjl.myblog.utils.DateFormatUtil;
import com.zjl.myblog.utils.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:jlzhang
 * @Description: 用AOP记录日志
 * @Date:Created in 2019/10/30
 */
@Component
@Aspect
public class LogAspect {

    DateFormatUtil dateFormatUtil = new DateFormatUtil();

    /**
     * @Description: 定义切点
     * @Date: 2019/10/30 23:16
     * @Param:
     * @Return:
     */
    @Pointcut("execution(* com.zjl.myblog.service.*.*(..))")
    public void pc() {

    }
    /**
     * 将Log标识的方法进行切面
     */
    @Pointcut("@annotation(com.zjl.myblog.annotation.Log)")
    public void logAsppect() {
    }

    /**
     * @Description: TODO
     * @Date: 2019/10/30 23:19
     * @Param:
     * @Return:
     */
    @Before(value = "pc()||logAsppect()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] objects = joinPoint.getArgs();
        LogUtil.info(LogAspect.class, "开始执行{0}方法", name);
        LogUtil.info(LogAspect.class, "参数是:{0}", objects);
    }

    /**
     * @Description: TODO
     * @Date: 2019/10/30 23:41
     * @Param:
     * @Return:
     */
    @After(value = "pc()||logAsppect()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        LogUtil.info(LogAspect.class, "结束执行{0}方法", name);
    }

    /**
     * @Description: TODO
     * @Date: 2019/10/30 23:57
     * @Param:
     * @Return:
     */
    @AfterReturning(value = "pc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        LogUtil.info(LogAspect.class, "方法{0}的返回值是：{1}", name, result);
    }

    /**
     * @Description: TODO
     * @Date: 2019/10/31 0:04
     * @Param:
     * @Return:
     */
    @AfterThrowing(value = "pc()||logAsppect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        LogUtil.error(LogAspect.class, "方法{0}抛出了异常，异常是：{1}", name, e);
    }

}
