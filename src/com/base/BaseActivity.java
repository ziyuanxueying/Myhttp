package com.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public abstract class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setOnCreate();
	}

	private void setOnCreate() {
		// TODO Auto-generated method stub
		setView();
		setDate();
		init();
		setOperation();
	}
	
	/** 设置布局 第一步 */
	protected abstract void setView();

	/** 接收上级，填充数据 第二步 */
	protected abstract void setDate();

	/** 实例化控件 第三步 */
	protected abstract void init();

	/** 其他操作 第四步 */
	protected abstract void setOperation();
	
	/**
	 * 解析json
	 */
	public abstract void toParseJson(int tag,String json);
	
	/**
	 * 接收数据解析 
	 * @param msg
	 */
//	protected abstract void Listener();
}
