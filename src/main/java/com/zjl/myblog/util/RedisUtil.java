package com.zjl.myblog.util;

import java.util.List;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/13
 * @date: 2019/12/13
 * @function: TODO
 */
public class RedisUtil {
    /**
      *
      * 生成redis的key
      *
      * @exception
      */
    public static String getKey(List<String> keys){
        StringBuffer key=new StringBuffer (  );
        if(!keys.isEmpty ()){
            for(String s:keys){
                key.append ( s );
            }
        }
        return key.toString ();
    }
}
