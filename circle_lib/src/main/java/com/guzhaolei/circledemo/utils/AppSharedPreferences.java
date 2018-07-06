package com.guzhaolei.circledemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * 
* @ClassName: AppSharedPreferences 
* @Description: SharedPreference管理类,进行管理SharedPreferences
* @author chuqian
* @date 2015-12-30 上午11:05:27 
*
 */
public class AppSharedPreferences {

	private SharedPreferences sharedPreferences;					//定义一个SharedPreferences的对象
	private static AppSharedPreferences appSharedPreferences;		//定义一个AppSharedPreferences的自身类，进行单例操作

	private AppSharedPreferences(Context context) {
		sharedPreferences = context.getSharedPreferences("CIRCLEDEMO", Activity.MODE_PRIVATE);
	}

	public static AppSharedPreferences getInstance(Context context) {
		if (null == appSharedPreferences) {
			appSharedPreferences = new AppSharedPreferences(context);
		}
		return appSharedPreferences;
	}


	//从SharedPreferences中获取某一个key对应的值
	public String get(String key) {
		if (null == sharedPreferences) {
			return "";
		}
		String result = sharedPreferences.getString(key, "");
		if (!TextUtils.isEmpty(result)) {
			return result;
		}
		return "";
	}

	//往SharedPreferences中存进某一个key对应的值
	public void set(String key, String value) {
		if (null != sharedPreferences) {
			SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.putString(key, value);
			editor.commit();
		}
	}

	//从SharedPreferences中删除某一个（些）key对应的值
	public void remove(String... key) {
		for (String k : key) {
			SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.remove(k);
			editor.commit();
		}
	}

}
