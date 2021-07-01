/*
 * 管理者情報を格納するBean
 * 使わなかった。
 *
 * */



package jp.co.aforce.beans;
import java.io.Serializable;

public class AdBean implements Serializable {

	private String id;
	private  String password ;

	//ゲッター
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}

	//セッター
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
