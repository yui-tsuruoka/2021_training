package jp.co.aforce.beans;

import java.io.Serializable;

//顧客情報を格納するBean
public class Customer implements Serializable {

	private  String id;
	private String password;
	private String cus_name;

	//ゲッター
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return cus_name;
	}

	//セッター
	public void setId(String id) {
		this.id =id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String cus_name) {
		this.cus_name = cus_name;
	}


}
