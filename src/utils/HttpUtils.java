package utils;

import java.util.Map;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.http.BaseActivity;

import coo.http.R;

public class HttpUtils {

	public final static void MethodPsot(final int tag,
			final BaseActivity activity, String METHOD, String url,
			Map<String, String> params) {
		if (METHOD.equals("POST")) {
			RequestQueue requestQueue = Volley.newRequestQueue(activity);
			String URL = url + appendParameter(url, params);
			StringRequest jsonRequest = new StringRequest(Method.POST, URL,
					new Listener<String>() {
						@Override
						public void onResponse(String response) {
							// TODO Auto-generated method stub
							activity.toParseJson(tag, response);
						}
					}, errorListener);
			requestQueue.add(jsonRequest);
		}
	}

	public final static void getImg(final BaseActivity activity,
			String METHOD, String url,ImageView img,Map<String, String> params) {
		
		RequestQueue mQueue = Volley.newRequestQueue(activity);
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
		ImageListener listener = ImageLoader.getImageListener(img,
				R.drawable.default_image, R.drawable.failed_image);
		if (METHOD.equals("POST")) {
			String URL = url + appendParameter(url, params);
			imageLoader.get(URL, listener);
		}else if (METHOD.equals("GET")) {
			imageLoader.get(url, listener);
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
			Log.e("TAG", error.getMessage(), error);
		}

	};
}
