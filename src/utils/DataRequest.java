package utils;

import java.util.HashMap;
import java.util.Map;

import android.widget.ImageView;

import com.http.BaseActivity;

public class DataRequest {

	public static final String POST = "POST";
	public static final String GET = "GET";
	public static final String url = "http://api.54youwei.com/api.php??";
	public static final String url_img = "http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg";

	public static void getLoginCheck(final int tag,final BaseActivity activity,
			LoginBean loginB) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("c", loginB.getLogin());
		map1.put("m", loginB.getCode());
		map1.put("mobile", loginB.getPhone());
		HttpUtils.MethodPsot(tag,activity, POST, url, map1);
	}
	
	public static void getImage (final BaseActivity activity,ImageView img){
       HttpUtils.getImg(activity, GET, url_img, img, null);
	}
}
