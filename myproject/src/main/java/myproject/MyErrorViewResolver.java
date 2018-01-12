package myproject;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class MyErrorViewResolver implements ErrorViewResolver{
//可以添加实现ErrorViewResolver接口的Bean 
	@Override
	public ModelAndView resolveErrorView(
			HttpServletRequest request, 
			HttpStatus status, 
			Map<String, Object> model) {
		// TODO Auto-generated method stub
		return null;
	}

}
