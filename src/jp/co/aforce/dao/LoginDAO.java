package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;

public class LoginDAO extends DAO {

	//ログイン判定 getMemberメソッド
	public UserBean getMember(String id, String password) throws Exception {

		//実行結果を格納する変数
		ResultSet rs = null;
		UserBean userBean = new UserBean();

		Connection con = getConnection();
		String sql = "SELECT * FROM m_user WHERE id = ? AND password = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, password);
		rs = st.executeQuery();

		if (rs.next()) {
			userBean.setId(rs.getString("id"));
			userBean.setName(rs.getString("name"));
			userBean.setPassword(rs.getString("password"));
		}else {
			return null;
		}

	/*	while (rs.next()) {
			userBean.setId(rs.getString("id"));
			userBean.setName(rs.getString("name"));
			userBean.setPassword(rs.getString("password"));
		}
	*/
		st.close();
		con.close();

		return userBean;

	}

	//管理者のログイン判定　　getAdMemberメソッド
	public UserBean getAdMember(String id, String password) throws Exception {

		//実行結果を格納する変数
		ResultSet rs = null;
		UserBean userBean = new UserBean();

		Connection con = getConnection();
		String sql = "SELECT * FROM ad_user WHERE id = ? AND password = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, password);
		rs = st.executeQuery();

		if (rs.next()) {
			userBean.setId(rs.getString("id"));
			userBean.setPassword(rs.getString("password"));
		} else {
			return null;
		}

		st.close();
		con.close();

		return userBean;

	}

}