package com.zjl.myblog.util;

import com.alibaba.fastjson.JSON;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/2
 * @date: 2019/12/2
 * @function: TODO
 */
public class JsonClassConvertUtil {

        /**
          *
          * 任意类型转换成String
          *
          * @exception
          */
        public static<T> String classToString(T bean){
            if (bean == null) {
                return null;
            }
            Class<?> clazz=bean.getClass ();
            if(clazz==int.class ||
                    Integer.class==clazz ||
                    clazz==long.class ||
                    Long.class==clazz
                    ){
                return String.valueOf ( bean );
            }
            else if(clazz==String.class){
                return (String)bean;
            }
            else {
                return JSON.toJSONString ( bean );
            }
        }
        /**
         *
         * String转换成对象
         *
         * @exception
         */
        public static <T> T stringToBean(String val,Class<T> clazz){
            if (val == null||
                    val.length ()<=0||
                    clazz==null
                    ) {
                return null;
            }
            else if(clazz==int.class||clazz==Integer.class){
                return (T)Integer.valueOf ( val );
            }
            else if(clazz==long.class||clazz==Long.class){
                return (T)Long.valueOf ( val );
            }
            else if(clazz==String.class){
                return (T)val;
            }
            else {
                return (T)JSON.toJavaObject (JSON.parseObject ( val ),clazz );
            }
        }
}
