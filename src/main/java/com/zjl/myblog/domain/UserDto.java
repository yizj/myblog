package com.zjl.myblog.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/2
 * @date: 2019/12/2
 * @function: TODO
 */
@Data
@ToString
public class UserDto extends User {
    private String token;
}
