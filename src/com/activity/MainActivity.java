package com.activity;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.application.MyApplication;
import com.base.BaseActivity;
import com.bean.LoginBean;
import com.config.TagConfig;
import com.config.UrlConfig;
import com.http.ActivityDataRequest;
import com.http.JsonUtil;
import com.http.VolleySingleton;
import com.utils.BitmapCache;

import coo.http.R;

public class MainActivity extends BaseActivity{

	private String cityName;
	private TextView tv1, tv2;
	private Button bt1,bt2;
	private ImageView img1;

	@Override
	protected void setView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void setDate() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		tv1 = (TextView) findViewById(R.id.text1);
		tv2 = (TextView) findViewById(R.id.text2);
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		img1 = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	protected void setOperation() {
		// TODO Auto-generated method stub
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextHttp();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ActivityDataRequest.getImage(MainActivity.this, img1);
			}
		});
	}

	protected void TextHttp() {
		// TODO Auto-generated method stub
		LoginBean loginb = new LoginBean();
		loginb.setPhone("15236290644");
		ActivityDataRequest.getLoginCheck(TagConfig.TAG_MSG,this, loginb);
		
		LoginBean loginb2 = new LoginBean();
		loginb2.setPhone("15631001601");
		ActivityDataRequest.getLoginCheck(2,this, loginb2);
		
	}

	@Override
	public void toParseJson(int tag,String response) {
		switch (tag) {
		case TagConfig.TAG_MSG:
			Log.i("FJ", response);
			LoginBean lm = JsonUtil.getLogin(response);
			if (lm != null) {
				cityName = lm.getMsg();
			}
			tv1.setText(cityName);
			break;
		case 2:
			Log.i("FJ", response);
			LoginBean lm1 = JsonUtil.getLogin(response);
			if (lm1 != null) {
				tv2.setText(lm1.getMsg());
			}
			break;
		default:
			break;
		}
	}

}
