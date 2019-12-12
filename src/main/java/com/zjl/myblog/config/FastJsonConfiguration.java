package com.zjl.myblog.config;

/**
 * @author JLZHANG
 * @version 5.1.0 2019/12/3
 * @date: 2019/12/3
 * @function: TODO
 */

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport {

    /**
     * 修改自定义消息转换器
     *
     * @throws
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 调用父类配置
        super.configureMessageConverters ( converters );
        // 创建消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter ( );
        // 创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig ( );
        // 返回内容的过滤
        fastJsonConfig.setSerializerFeatures ( SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue );
        fastConverter.setFastJsonConfig ( fastJsonConfig );
        converters.add ( fastConverter );
    }

    /**
      *
      * 解决404
      *
      * @exception
      */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
