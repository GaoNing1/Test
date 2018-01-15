package YAML;

public class Person {
 private  String name;
 private int age;
 private Person sponse;
 private Person[] children;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Person getSponse() {
	return sponse;
}
public void setSponse(Person sponse) {
	this.sponse = sponse;
}
public Person[] getChildren() {
	return children;
}
public void setChildren(Person[] children) {
	this.children = children;
}

 


}
