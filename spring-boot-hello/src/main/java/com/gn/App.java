package com.gn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 使用@SpringBootApplication指定一个spring boot的应用程序
 * 
 * @author gaoning 启动类----入口
 */
@SpringBootApplication
public class App//{

//第一种方法	
extends WebMvcConfigurerAdapter {
	public void configureMessasgeConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		/**
		 * 1. 需要先定义一个Convert转换消息的对象
		 *  2.添加fastJson的配置信息，比如：是否需要格式化返回的json数据
		 * 3.在conver中添加配置信息
		 *  4.将conver添加到converters中
		 */
		// 1. 需要先定义一个Convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		// 2.添加fastJson的配置信息，比如：是否需要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		// 3.在conver中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		// 4.将conver添加到converters中9
		converters.add(fastConverter);
	}

	
//	//第二种方法
//	/**
//	 * 使用@Bean注入FastJsonHttpMessageConverter 
//	 * @return
//	 */
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		// 1. 需要先定义一个Convert转换消息的对象
//		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
//		
//		// 2.添加fastJson的配置信息，比如：是否需要格式化返回的json数据
//		FastJsonConfig fastJsonConfig=new FastJsonConfig();
//	    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//	    
//	    // 3.在conver中添加配置信息
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		
//		HttpMessageConverter<?> converter =fastConverter;
//		return new HttpMessageConverters(converter);
//		
//	}
	public static void main(String[] args) {
		/*
		 * 在main方法中启动应用程序
		 */

		SpringApplication.run(App.class, args);
	}
}
