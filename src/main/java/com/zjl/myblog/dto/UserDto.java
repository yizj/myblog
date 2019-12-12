package com.zjl.myblog.dto;

import com.zjl.myblog.domain.UserDO;
import lombok.Data;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/2
 * @date: 2019/12/2
 * @function: TODO
 */
@Data
public class UserDto extends UserDO {
    private String token;
}
