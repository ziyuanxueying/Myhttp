package com.http;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.application.MyApplication;
import com.utils.BitmapCache;

public class VolleySingleton {
	private static VolleySingleton volleySingleton;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private Context mContext;

	public VolleySingleton(Context context) {
		this.mContext = context;
		mRequestQueue = getRequestQueue();
		mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
	}

	public static synchronized VolleySingleton getVolleySingleton(
			Context context) {
		if (volleySingleton == null) {
			volleySingleton = new VolleySingleton(context);
		}
		return volleySingleton;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
//			mRequestQueue = MyApplication.getHttpQueue();
		}
		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req) {
		getRequestQueue().add(req);
	}

	public ImageLoader getImageLoader() {
		return mImageLoader;
	}
}
