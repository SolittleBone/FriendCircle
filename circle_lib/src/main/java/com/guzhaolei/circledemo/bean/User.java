package com.guzhaolei.circledemo.bean;
/**
 * 
* @ClassName: User 
* @Description: 用户的实体类
* @author guzhaolei
* @date 2018-7-1 下午3:45:04
*
 */
public class User {
	private String id;
	private String name;
	private String headUrl;				//头像路径


	public User(String id, String name, String headUrl){
		this.id = id;
		this.name = name;
		this.headUrl = headUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
}
