/*
 * 顧客情報を格納するBean
 *
 * */

package jp.co.aforce.beans;
import java.io.Serializable;

public class UserBean implements Serializable {

	private String id;
	private  String password ;
	private String name;
	private String msg;

	//ゲッター
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getMsg() {
		return msg;
	}

	//セッター
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name =name;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}



}
