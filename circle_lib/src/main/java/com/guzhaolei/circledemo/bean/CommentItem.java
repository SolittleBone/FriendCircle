package com.guzhaolei.circledemo.bean;

import java.io.Serializable;
/**
 * 
* @ClassName: CommentItem 
* @Description: 朋友圈评论的实体类
* @author guzhaolei
* @date 2018-7-1 下午3:44:38
*
 */
public class CommentItem implements Serializable{

	private String id;
	private User user;
	private User toReplyUser;		//评论用户
	private String content;			//评论内容


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getToReplyUser() {
		return toReplyUser;
	}
	public void setToReplyUser(User toReplyUser) {
		this.toReplyUser = toReplyUser;
	}
	
}
