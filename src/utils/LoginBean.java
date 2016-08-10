package utils;

public class LoginBean {
	private String login;
	private String code;
	private String phone;
	private String error;
	private String msg;
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public String toString() {
		return "LoginBean [login=" + login + ", code=" + code + ", phone="
				+ phone + ", error=" + error + ", msg=" + msg + "]";
	}
	
	
}
