package com.guzhaolei.circledemo.utils;

import com.guzhaolei.circledemo.bean.CircleItem;
import com.guzhaolei.circledemo.bean.CommentItem;
import com.guzhaolei.circledemo.bean.FavoriteItem;
import com.guzhaolei.circledemo.bean.User;
import com.guzhaolei.circledemo.resource.ResourceConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 
* @ClassName: DatasUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author guzhaolei
* @date 2018-7-1 下午4:16:21
*
 */
public class DatasUtil {

	//发布动态的文字内容
	public static final String[] CONTENTS = { "", "哈哈", "今天是个好日子", "呵呵", "图不错",
			"我勒个去" };

	//模拟的用户集
	public static List<User> users = new ArrayList<User>();
	/**
	 * 动态id自增长
	 */
	private static int circleId = 0;
	/**
	 * 点赞id自增长
	 */
	private static int favortId = 0;
	/**
	 * 评论id自增长
	 */


	private static int commentId = 0;
	public static final User curUser = new User("0", "自己", ResourceConfig.HEADIMG[0]);

	//创建模拟的用户集数据
	static {
		User user1 = new User("1", "chenmin", ResourceConfig.HEADIMG[1]);
		User user2 = new User("2", "陈露", ResourceConfig.HEADIMG[4]);
		User user3 = new User("3", "褚倩", ResourceConfig.HEADIMG[3]);
		User user4 = new User("4", "DDD", ResourceConfig.HEADIMG[2]);
		User user5 = new User("5", "guzhaolei", ResourceConfig.HEADIMG[5]);
		User user6 = new User("6", "啦啦啦", ResourceConfig.HEADIMG[6]);
		User user7 = new User("7", "这个名字是不是很长，哈哈！因为我是用来测试换行的", ResourceConfig.HEADIMG[7]);

		users.add(curUser);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
	}

	public static List<CircleItem> createCircleDatas() {
		List<CircleItem> circleDatas = new ArrayList<CircleItem>();
		for (int i = 0; i < 15; i++) {
			CircleItem item = new CircleItem();
			User user = getUser();
			item.setId(String.valueOf(circleId++));
			item.setUser(user);
			item.setContent(getContent());
			item.setCreateTime("12月24日");

			item.setFavorters(createFavortItemList());
			item.setComments(createCommentItemList());
			if (getRandomNum(10) % 2 == 0) {
				item.setType("1");// 链接
				item.setLinkImg("http://pics.sc.chinaz.com/Files/pic/icons128/2264/%E8%85%BE%E8%AE%AFQQ%E5%9B%BE%E6%A0%87%E4%B8%8B%E8%BD%BD1.png");
				item.setLinkTitle("百度一下，你就知道");
			} else {
				item.setType("2");// 图片
				item.setPhotos(createPhotos());
			}
			circleDatas.add(item);
		}

		return circleDatas;
	}

	public static User getUser() {
		return users.get(getRandomNum(users.size()));
	}

	public static String getContent() {
		return CONTENTS[getRandomNum(CONTENTS.length)];
	}

	public static int getRandomNum(int max) {
		Random random = new Random();
		int result = random.nextInt(max);
		return result;
	}

	//从模拟的图片资源中随机筛选出《=9张的图片展示
	public static List<String> createPhotos() {
		List<String> photos = new ArrayList<String>();
		//int size = getRandomNum(PHOTOS.length);
		int size = getRandomNum(ResourceConfig.CONTENT_IMAGE.length);
		if (size > 0) {
			if (size > 9) {
				size = 9;
			}
			for (int i = 0; i < size; i++) {
				//String photo = PHOTOS[getRandomNum(PHOTOS.length)];
				String photo = ResourceConfig.CONTENT_IMAGE[getRandomNum(ResourceConfig.CONTENT_IMAGE.length)];
				if (!photos.contains(photo)) {
					photos.add(photo);
				} else {
					i--;
				}
			}
		}
		return photos;
	}

	public static List<FavoriteItem> createFavortItemList() {
		int size = getRandomNum(users.size());
		List<FavoriteItem> items = new ArrayList<FavoriteItem>();
		List<String> history = new ArrayList<String>();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				FavoriteItem newItem = createFavortItem();
				String userid = newItem.getUser().getId();
				if (!history.contains(userid)) {
					items.add(newItem);
					history.add(userid);
				} else {
					i--;
				}
			}
		}
		return items;
	}

	public static FavoriteItem createFavortItem() {
		FavoriteItem item = new FavoriteItem();
		item.setId(String.valueOf(favortId++));
		item.setUser(getUser());
		return item;
	}
	
	public static FavoriteItem createCurUserFavortItem() {
		FavoriteItem item = new FavoriteItem();
		item.setId(String.valueOf(favortId++));
		item.setUser(curUser);
		return item;
	}

	public static List<CommentItem> createCommentItemList() {
		List<CommentItem> items = new ArrayList<CommentItem>();
		int size = getRandomNum(5);
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				items.add(createComment());
			}
		}
		return items;
	}

	public static CommentItem createComment() {
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		item.setContent("哈哈");
		User user = getUser();
		item.setUser(user);
		if (getRandomNum(10) % 2 == 0) {
			while (true) {
				User replyUser = getUser();
				if (!user.getId().equals(replyUser.getId())) {
					item.setToReplyUser(replyUser);
					break;
				}
			}
		}
		return item;
	}
	
	/**
	 * 创建发布评论
	 * @return
	 */
	public static CommentItem createPublicComment(String content){
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		item.setContent(content);
		item.setUser(curUser);
		return item;
	}
	
	/**
	 * 创建回复评论
	 * @return
	 */
	public static CommentItem createReplyComment(User replyUser, String content){
		CommentItem item = new CommentItem();
		item.setId(String.valueOf(commentId++));
		item.setContent(content);
		item.setUser(curUser);
		item.setToReplyUser(replyUser);
		return item;
	}
}
