package myproject;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * 如果该类不在classpath中以使用注释的excludeName属性并指定完全限定的名称达到相同效果。
 * 可以通过spring.autoconfigure.exclude属性exclude多个自动配置项（自动配置项集合）
 */
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
 * 禁用特定的自动装配类
 */
@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MyConfiguration {
 //HttpMessageConverters  bean都将添加到converters列表，可以用这种方式覆盖默认的转换器列表（converters）
//	@Bean
//	public HttpMessageConverters customConverters(){
//	HttpMessageConverter<?> additional =null;
//	HttpMessageConverter<?> another=null;
//		
//		return new HttpMessageConverters(additional,another);
//		
//	}
	
	//Cors支持
	@Bean
	public WebMvcConfigurer corsConfigurer(){
	
		
		return new WebMvcConfigurerAdapter() {
			public  void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/api/**");
			}
		};
		
	}
}
