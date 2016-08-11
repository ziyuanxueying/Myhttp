package com.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application{
	 public static RequestQueue queue;

	    @Override
	    public void onCreate() {
	        super.onCreate();
	        queue = Volley.newRequestQueue(getApplicationContext());//使用全局上下文
	    }

	    public static RequestQueue getHttpQueue() {
	        return queue;
	    }
}
