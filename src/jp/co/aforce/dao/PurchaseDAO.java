/*
 *
 * 購入情報を登録するためのDAO
 *
 * */


package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.ItemBean;

public class PurchaseDAO extends DAO {

	//購入情報の登録を行うinsertメソッド
	public boolean insert(
		List<CartBean> cart, String name, String address, String payment) throws  Exception {

		Connection con = getConnection();
		con.setAutoCommit(false);

		//cartに入っている商品を購入テーブルに追加する。
		for (CartBean cartBean : cart) {

			PreparedStatement st = con.prepareStatement(
				//購入IDはauto_incrementなのでnullにしておく。
				"insert into purchase values(null, ?, ?, ?, ?, ?, ?, ?)");

			//購入リストbeanと商品beanとフォームに入力した情報
			ItemBean itemBean = cartBean.getItemBean();
			st.setInt(1, itemBean.getId());
			st.setString(2, itemBean.getItemName());
			st.setInt(3, Integer.parseInt(itemBean.getPrice()));
			st.setInt(4, cartBean.getCount());
			st.setString(5, name);
			st.setString(6, address);
			st.setString(7, payment);

			int line = st.executeUpdate();
			st.close();

			//一行入っていない＝何かしら失敗した。ロールバック行ってなかったことにする。
			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();

				return false;
			}
		}

		//全ての購入リストをテーブルに追加できた場合、コミットする。(中途半端な行数の追加を制限する)
		con.commit();
		con.setAutoCommit(true);
		con.close();

		return true;

	}

}
