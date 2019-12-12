package com.zjl.myblog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * 日志工具类
 */
public class LogUtil {
	
	
	private LogUtil() {
	}

	/**
	 * debug级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param params
	 */
	public static void debug(final Class<?> clazz, final String context, final Object... params) {
		Logger log = LoggerFactory.getLogger(clazz);
		if(null == params || params.length == 0){
			log.debug(context);
		}else{
			log.debug(MessageFormat.format(context, params));
		}
	}
	
	/**
	 * info级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param params
	 */
	public static void info(Class<?> clazz, String context, Object... params) {
		StringBuffer stringBuffer=new StringBuffer();
		Logger log = LoggerFactory.getLogger(clazz);
		String delim="";
		if(null == params || params.length == 0){
			log.info(context);
		}
		if(params instanceof Object[]&&params.length>1){
			for(Object object:params){
				stringBuffer.append(delim).append ( object );
				delim=",";
			}
			log.info(MessageFormat.format(context, stringBuffer.toString ()));
		}
		else {
			log.info(MessageFormat.format(context, params));
		}
	}

	/**
	 * info级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param params
	 */
	public static void mulinfo(Class<?> clazz, String context, Object... params) {
		Logger log = LoggerFactory.getLogger(clazz);
		if(null == params || params.length == 0){
			log.info(context);
		}
		log.info(MessageFormat.format(context, params));
	}

	/**
	 * warn级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param params
	 */
	public static void warn(Class<?> clazz, String context, Object... params) {
		Logger log = LoggerFactory.getLogger(clazz);
		if(null == params || params.length == 0){
			log.warn(context);
		}else{
			log.warn(MessageFormat.format(context, params));
		}
	}

	/**
	 * error级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param params
	 */
	public static void error(Class<?> clazz, String context, Object... params) {
		Logger log = LoggerFactory.getLogger(clazz);
		if(null == params || params.length == 0){
			log.error(context);
		}else{
			log.error(MessageFormat.format(context, params));
		}
	}
	
	/**
	 * error级别
	 * @param clazz
	 * @param context 可用占位符，如：{0}
	 * @param t
	 * @param params
	 */
	public static void error(Class<?> clazz, String context, Throwable t ,Object... params) {
		Logger log = LoggerFactory.getLogger(clazz);
		if(null == params || params.length == 0){
			log.error(context, t);
		}else{
			log.error(MessageFormat.format(context, params), t);
		}
	}
}
