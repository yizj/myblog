package com.zjl.myblog.api;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
@author zjl
@description 基础的返回类
@data 2019/10/30
*/
@Data
@ToString
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 5231149907601109098L;
    /**返回信息提示*/
    private String msg;

    /**返回状态码*/
    private Integer code;

    /**返回数据*/
    private T data;
}
