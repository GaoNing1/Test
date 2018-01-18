package com.spring.mybatis.springMybatis.entity;

//import lombok.Getter;
//import lombok.Setter;
//
//@Setter
//@Getter
public class User{
    private int id;
    private String userName; // 用户名
    private int userAge; // 年龄
    private String userAddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	} 


   
}
