package com.spring.mybatis.springMybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;






@SpringBootApplication
@MapperScan("com.spring.mybatis.springMybatis.*")
public class Application {
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		
//		
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
//	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
