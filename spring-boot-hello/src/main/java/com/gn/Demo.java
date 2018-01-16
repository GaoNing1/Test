package com.gn;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 测试实体类
 * @author gaoning
 *
 */
public class Demo {
private int  id;
private String name;
//import com.alibaba.fastjson.annotation.JSONField;
@JSONField(format="yyyy-MM-dd HH:mm")
private Date  ctreateTime;
public Date getCtreateTime() {
	return ctreateTime;
}
public void setCtreateTime(Date ctreateTime) {
	this.ctreateTime = ctreateTime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
