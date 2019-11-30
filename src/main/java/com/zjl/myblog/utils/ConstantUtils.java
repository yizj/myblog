package com.zjl.myblog.utils;

/**
 * @Author:jlzhang
 * @Description:
 * @Date:Created in 2019/10/31
 */
public class ConstantUtils {

    /**
     * 消息错误码
     */
    public static final Integer ERRORCODE = 100;

    /**
     * 消息成功碼
     */
    public static final Integer SUCCESSCODE = 200;

    /**
     * role验证消息
     */
    public static final String ROLEPATTERN = "角色名不能为空";

    /**
     * user验证消息
     */
    public static final String USERNAMENOTNULL = "用户名不能为空";

    public static final String USERNAMESIZE = "用户名应该在六位与二十位之间";

    public static final String PWD = "密码应该在六位与二十位之间";

    public static final String EMAILNOTNULL = "邮箱不能为空";

    public static final String EMAILPATTERN = "邮箱格式不正确";

    public static final String PHONENOTNULL = "手机号码不能为空";

    public static final String PHONEPATTERN = "手机号码格式不正确";


}
