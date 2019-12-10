package com.zjl.myblog.utils;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/10/31
 */
public class ConstantUtils {

    /**
     * 消息成功码
     */
    public static final Integer SUCCESS_CODE= 200;
    /**
     * 消息错误码
     */
    public static final Integer ERROR_CODE = 100;
    /**
     * role验证消息
     */
    public static final String ROLE_PATTERN = "角色名不能为空";
    /**
     * user验证消息
     */
    public static final String USER_NAME_NOTNULL = "用户名不能为空";

    public static final String USER_NAME_SIZE = "用户名应该在六位与二十位之间";

    public static final String EMAIL_NOTNULL = "邮箱不能为空";

    public static final String EMAIL_PATTERN = "邮箱格式不正确";

    public static final String PHONE_NOTNULL = "手机号码不能为空";

    public static final String PHONE_PATTERN = "手机号码格式不正确";

    public static final String EMAIL_SUBJECT="请点击下面超链接完成邮箱激活";

    public static final String EMAIL_TYPE="EMAIL";

    public static final String EMAIL_STEP="ACTIVE";

}
