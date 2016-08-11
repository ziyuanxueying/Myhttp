package com.config;

public class UrlConfig {
	// 正式服务器 new
		public static final String BaseUrl_1_0 = "http://api.54youwei.com/api.php?";
	public static final String BaseUrl = BaseUrl_1_0;
	/** 发送验证码 */
	public static final String URL_GET_LOGIN = BaseUrl + "&c=login&m=code";
	/** 网络图片 */
	public static final String URL_IMG = "http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg";
}
