package myproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean  implements CommandLineRunner{
	@Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		//Spring Boot会注册一个包含Spring Environment属性的CommandLinePropertySource
        //这些允许你使用@value注解注入的应用参数		
	}

	@Override
	public void run(String... args)  {
		// TODO Auto-generated method stub
		
	}

	

}
