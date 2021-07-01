/*
 * カート内を表示されるときに使うbean
 *
 * 基本はItemBeanと同じだけど、個数のカウント機能を追加。
 *
 * */


package jp.co.aforce.beans;

import java.io.Serializable;

public class CartBean implements Serializable {

	//ItemBeanオブジェクトをプロパティとして持つ。
	private ItemBean itemBean;

	//商品の個数を数える変数
	private int count;

	//カート内の商品の総数を数える変数
	private int totalCount;

	//商品ごとの小計
	private int subTotal;

	//合計金額
	private int total;


	//ゲッター
	public ItemBean getItemBean() {
		return itemBean;
	}

	public int getCount() {
		return count;
	}
	public int getTotalCount() {
		return totalCount;
	}

	public int getTotal() {
		return total;
	}

	public int getSubTotal() {
		return subTotal;
	}


	//セッター
	public void setItemBean(ItemBean itemBean) {
		this.itemBean = itemBean;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setSubtotal(int subTotal) {
		this.subTotal = subTotal;
	}

}
