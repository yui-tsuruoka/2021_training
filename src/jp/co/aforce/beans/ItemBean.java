/*
 * 商品情報を格納するためのbean
 *
 * */


package jp.co.aforce.beans;
import java.io.Serializable;



public class ItemBean implements Serializable {

	//priceをString型にすればいろいろ解決できるのでは。。。
	private int id;
	private  String itemName ;
	private String price;
	private String categoryId; //Stringの方が都合いい。
	private String categoryName;
	private String msg;

	//ゲッター
	public int getId() {
		return id;
	}
	public String getItemName() {
		return itemName;
	}
	public String getPrice() {
		return price;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getMsg() {
		return msg;
	}

	//セッター
	public void setId(int id) {
		this.id = id;
	}
	public void setItemName(String itemName) {
		this.itemName =itemName;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}



}



