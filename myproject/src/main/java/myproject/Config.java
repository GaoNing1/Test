package myproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


/*
 * 使用Spring DateBinder 工具绑定这些属性（这是@ConfigurationProperties的事）
 * 需要确保目标bean有一个java.utill.List或set类型的属性，并且需要提供一个setter或
 * 使用可变的值初始化她
 */
@ConfigurationProperties(prefix="my")
public class Config {
private List<String>server=new ArrayList<>();
public List<String> getServer(){
	return this.server;
}
}
