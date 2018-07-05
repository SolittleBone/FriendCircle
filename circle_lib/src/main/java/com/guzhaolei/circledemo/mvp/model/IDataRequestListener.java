package com.guzhaolei.circledemo.mvp.model;
/**
 * 
* @ClassName: IDataRequestListener 
* @Description: 请求后台数据服务器响应后的回调 
* @author guzhaolei
* @date 2018-7-1 下午4:01:57
*
 */
public interface IDataRequestListener {

	public void loadSuccess(Object object);
}
