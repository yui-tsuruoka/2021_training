package jp.co.aforce.beans;

import java.io.Serializable;

//顧客情報を格納するBean
public class RegisterBean implements Serializable {

	private String memberNo;
	private  String name ;
	private int age;
	private int birthYear;
	private int birthMonth;
	private int birthDay;

	//ゲッター
	public String getId() {    //便宜上、セッターゲッター名だけはmemberNo = Id　とする。
		return memberNo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getYear() {
		return birthYear;
	}
	public int getMonth() {
		return birthMonth;
	}
	public int getDay() {
		return birthDay;
	}
	//セッター
	public void setId(String memberNo) {
		this.memberNo = memberNo;
	}

	public void setName(String name) {
		this.name =name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public void setMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public void setDay(int birthDay) {
		this.birthDay = birthDay;
	}

}
