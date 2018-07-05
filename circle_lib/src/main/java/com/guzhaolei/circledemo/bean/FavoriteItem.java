package com.guzhaolei.circledemo.bean;

import java.io.Serializable;
/**
 * 
* @ClassName: FavoriteItem
* @Description: 点赞的实体类
* @author guzhaolei
* @date 2018-7-1 下午3:44:56
*
 */
public class FavoriteItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
