package myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * 实现自动配置有两种:
 * 将@EnableAutoConfiguration或@SpringBootApplication注解到@configura类上
 */
/*
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 * 1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 *      例如：本来应该到success.jsp页面的，则其显示success.
 * 2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 * @RestController告诉Spring以字符串的形式渲染结果，并直接返回给调用者
 * @EnableAutoConfiguration这个注解告诉Spring Boot根据你添加的jar依赖来“猜测”你想要如何配置Spring
 */
//放置应用的main类
@RestController
@EnableAutoConfiguration
public class Example { 	 	
       @RequestMapping("/")
       String home(){
    	   return "Hello World";
       }
       public static void main(String[] args) {
		 SpringApplication.run(Example.class,args);
	}
}
