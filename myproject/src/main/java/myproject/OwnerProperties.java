package myproject;

import org.springframework.boot.context.properties.ConfigurationProperties;
//Relaxed绑定
@ConfigurationProperties(prefix="person")
public class OwnerProperties {
 private String firstName;

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}
 
}
