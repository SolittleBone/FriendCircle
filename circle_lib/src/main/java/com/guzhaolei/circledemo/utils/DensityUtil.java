package com.guzhaolei.circledemo.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
* @ClassName: DensityUtil 
* @Description:  解决android屏幕的适配问题
* @author 褚倩
* @date 2018-7-1 下午4:17:01
 */
public class DensityUtil {
	
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/** 获取手机的密度，解决Android屏幕适配问题*/
	public static float getDensity(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		return dm.density;
	}
}
