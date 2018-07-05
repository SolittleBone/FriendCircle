package com.guzhaolei.circledemo.mvp.view;

import com.guzhaolei.circledemo.bean.User;
/**
 * 
* @ClassName: ICircleViewUpdateListener 
* @Description: view,服务器响应后更新界面 
* @author guzhaolei
* @date 2018-7-1 下午4:13:04
*
 */
public interface ICircleViewUpdate {

	//发布评论的标识为0
	public static final int TYPE_PUBLIC_COMMENT = 0;

	//回复评论的标识为1
	public static final int TYPE_REPLY_COMMENT = 1;

	//删除动态的接口
	public void update2DeleteCircle(String circleId);

	//点赞的接口
	public void update2AddFavorite(int circlePosition);

	//删除点赞的接口
	public void update2DeleteFavort(int circlePosition, String favortId);

	//添加评论的接口
	public void update2AddComment(int circlePosition, int type, User replyUser);//type: 0 发布评论  1 回复评论

	//删除评论的接口
	public void update2DeleteComment(int circlePosition, String commentId);
}
