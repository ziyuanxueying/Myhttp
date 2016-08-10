package utils;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtil {

	public static LoginBean getLogin(String json){
		
		json = json.replace(":null,", ":\"\",");
		LoginBean loginModel = new LoginBean();
		try {
			JSONObject loginJo = new JSONObject(json);
			if (!loginJo.isNull("error")) {
				loginModel.setError(loginJo.getString("error"));
			}
			if (!loginJo.isNull("msg")) {
				loginModel.setMsg(loginJo.getString("msg"));
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginModel;
	}
	
//    public static Listener<String> jsListener = new Response.Listener<String>() {
//
//    	public LoginBean lb = new LoginBean();
//		@Override
//		public void onResponse(JSONObject response) {
//			// TODO Auto-generated method stub
//			Log.i("FJ", response.toString());
//			String data = response.toString();
//			data = data.replace(":null,", ":\"\",");
//			try {
//				JSONObject jo = new JSONObject(data);
////				jo = jo.getJSONObject("msg");
//				lb.setMsg(jo.getString("msg"));
//				
////				JSONObject jo_sk_info = jo.getJSONObject("sk_info");
////				sk_info = jo.getString("sk_info");
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////			return lb;
//		}
//	};
	
}
