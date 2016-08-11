package com.http;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;
import com.utils.BitmapCache;
import com.utils.DataRequest;
import com.utils.JsonUtil;
import com.utils.LoginBean;

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
				DataRequest.getImage(MainActivity.this, img1);
			}
		});
	}

	protected void ImageHttp() {
		// TODO Auto-generated method stub
		RequestQueue mQueue = Volley.newRequestQueue(this);  
		
		//加缓存
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
		
		ImageListener listener = ImageLoader.getImageListener(img1,  
		        R.drawable.default_image, R.drawable.failed_image); 
		imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener); 
	}

	protected void TextHttp() {
		// TODO Auto-generated method stub
		LoginBean loginb = new LoginBean();
		loginb.setLogin("login");
		loginb.setCode("code");
		loginb.setPhone("15236290644");
		DataRequest.getLoginCheck(1,this, loginb);
		
		LoginBean loginb2 = new LoginBean();
		loginb2.setLogin("login");
		loginb2.setCode("code");
		loginb2.setPhone("15631001601");
		DataRequest.getLoginCheck(2,this, loginb2);
		
	}

	@Override
	public void toParseJson(int tag,String response) {
		switch (tag) {
		case 1:
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
