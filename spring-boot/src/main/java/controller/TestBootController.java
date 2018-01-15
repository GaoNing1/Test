package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import service.TestInterFace;
/*
 * 第三步启动报错
 *org.springframework.beans.factory.UnsatisfiedDependencyException: 
 *Error creating bean with name 'testBootController': 
 *Unsatisfied dependency expressed through field 'testInterFace'
 *org.springframework.beans.factory.UnsatisfiedDependencyException：
 *创建名为'testBootController'的bean时出错：通过字段'testInterFace'表示的不满意的依赖：没有找到依赖关系[com.kx.springboot.service.TestInterFace]的合格bean。
 * gn.springboot.service.TestInterFace]：期望至少有1个bean被认为是这个依赖关系的自动连线候选者。依赖注释：{@ org.springframework.beans.factory.annotation.Autowired（required = true）}; 
 * 嵌套异常是org.springframework.beans.factory.NoSuchBeanDefinitionException：找不到符合[com.kx.springboot.service.TestInterFace]类型的[com.kx.springboot.service.TestInterFace]类型的合格bean：
 * 期望至少有一个bean符合此依赖关系的autowire候选人的资格。
 *依赖注释：{@ org.springframework.beans.factory。
 *springboot默认按照包顺序注入，在创建控制器时服务还没有注入，
 *springboot不需要传统的XML配置扫描包，只需要添加注解@ComponentScan（basePackages = {“com.gn.springboot.service”}
 */
@Controller
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"service"})//添加的注解
//5.修改TestBootController
@RequestMapping("test")
public class TestBootController {

	//3.修改控制器层代码
	 @Autowired
	    private TestInterFace testInterFace;

	    @RequestMapping("/num")
	    @ResponseBody
	    int home() {
	    int i = testInterFace.testInterFace();
	    return i;
	    }
	    @RequestMapping("/get")
	    @ResponseBody User getUser() {
	    return testInterFace.testUser();
	    }
////1.新建控制器
//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//    return "hello world";
//    }

    public static void main(String[] args) throws Exception {
    SpringApplication.run(TestBootController.class, args);
    }
}
