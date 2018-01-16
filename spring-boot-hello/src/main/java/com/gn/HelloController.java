package com.gn;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 使用的RestController（等价于@Controller和@RequestBody）
 * @author gaoning
 *
 */
@RestController
public class HelloController {
	/**
	 * 使用@RequestMapping建立请求映射：
	 * http://localhost:8080/hello
	 * @return
	 */
@RequestMapping("/hello")
	public String hello(){
		return "hello";
	
}
/**
 * spring boot 默认使用json解析框架jackson
 * @return
 */

@RequestMapping("/getDemo")
public  Demo getDemo(){
	Demo demo=new Demo();
	demo.setId(1);
	demo.setName("张三");
	demo.setCtreateTime(new Date());
	return demo;
	
}
}
