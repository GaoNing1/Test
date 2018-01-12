package myproject;

import javax.annotation.PostConstruct;

import org.apache.catalina.Server;

public class MyService {

	private final FooProperties properties;
 public MyService(FooProperties properties){
	 this .properties=properties;
 }
	
 @PostConstruct
 public void openConnection(){

 }
}
