package com.http;

import java.util.HashMap;
import java.util.Map;

import android.widget.ImageView;

import com.base.BaseActivity;
import com.bean.LoginBean;
import com.config.UrlConfig;

public class ActivityDataRequest {

	public static final String POST = "POST";
	public static final String GET = "GET";

	public static void getLoginCheck(final int tag,final BaseActivity activity,
			LoginBean loginB) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("mobile", loginB.getPhone());
		HttpUtils.MethodPsot(tag,activity, POST, UrlConfig.URL_GET_LOGIN, map1);
	}
	
	public static void getImage (final BaseActivity activity,ImageView img){
       HttpUtils.getImg(activity, GET, UrlConfig.URL_IMG, img, null);
	}
}
