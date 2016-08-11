package com.http;

import java.util.Map;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.activity.MainActivity;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.application.MyApplication;
import com.base.BaseActivity;
import com.utils.BitmapCache;

import coo.http.R;

public class HttpUtils {

	/**
	 * 与服务器进行数据交互
	 * @param tag 标志位
	 * @param activity 页面
	 * @param METHOD 方法：get/post
	 * @param url 拼的URL网址
	 * @param params 拼的参数
	 */
	public final static void MethodPsot(final int tag,
			final BaseActivity activity, String METHOD, String url,
			Map<String, String> params) {
		if (METHOD.equals("POST")) {
//			RequestQueue mRequestQueue = VolleySingleton.getVolleySingleton(activity).getRequestQueue();
//			RequestQueue requestQueue = MyApplication.getHttpQueue();
			String URL = url + appendParameter(url, params);
			StringRequest jsonRequest = new StringRequest(Method.POST, URL,
					new Listener<String>() {
						@Override
						public void onResponse(String response) {
							// TODO Auto-generated method stub
							activity.toParseJson(tag, response);
						}
					}, errorListener);
//			requestQueue.add(jsonRequest);
			VolleySingleton.getVolleySingleton(activity).addToRequestQueue(jsonRequest);
		}else if (METHOD.equals("GET")) {
			StringRequest jsonRequest = new StringRequest(Method.POST, url,
					new Listener<String>() {
						@Override
						public void onResponse(String response) {
							// TODO Auto-generated method stub
							activity.toParseJson(tag, response);
						}
					}, errorListener);
			VolleySingleton.getVolleySingleton(activity).addToRequestQueue(jsonRequest);
		}
	}

	/**
	 * 获取网络图片
	 * @param activity 页面
	 * @param METHOD 与服务器交互方法
	 * @param url 拼的URL网址
	 * @param img ImageView实例
	 * @param params 拼的参数
	 */
	public final static void getImg(final BaseActivity activity,
			String METHOD, String url,ImageView img,Map<String, String> params) {
		
		ImageLoader mImageLoader;
		mImageLoader = VolleySingleton.getVolleySingleton
				(activity.getApplicationContext()).getImageLoader();
		//R.drawable.default_image默认图片id
		//R.drawable.failed_image加载图片错误时的图片
		ImageListener listener = ImageLoader.getImageListener(img,
				R.drawable.default_image, R.drawable.failed_image);
		
		if (METHOD.equals("POST")) {
			String URL = url + appendParameter(url, params);
			mImageLoader.get(URL, listener);
		}else if (METHOD.equals("GET")) {
			mImageLoader.get(url, listener);
		}
	}

	/** 将键值对转换成字符串 */
	private final static String appendParameter(String url,
			Map<String, String> params) {
		Uri uri = Uri.parse(url);
		Uri.Builder builder = uri.buildUpon();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			// 将键值对转换成字符串
			builder.appendQueryParameter(entry.getKey(), entry.getValue());
		}
		return builder.build().getQuery();
	}

	static Response.ErrorListener errorListener = new Response.ErrorListener() {

		@Override
		public void onErrorResponse(VolleyError error) {
			// TODO Auto-generated method stub
			Log.e("ERROR", error.getMessage(), error);
		}

	};
}
