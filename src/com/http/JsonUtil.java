package com.http;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.LoginBean;


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
	
}
