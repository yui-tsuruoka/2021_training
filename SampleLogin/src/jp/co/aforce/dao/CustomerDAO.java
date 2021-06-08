package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

//customerテーブルを操作するDAOクラス
public class CustomerDAO extends DAO{
	public Customer search(String id, String password)
		throws Exception{
		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
			"select * from customer where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getString("id"));
			customer.setPassword(rs.getString("password"));
			customer.setName(rs.getString("cus_name"));
		}

		st.close();
		con.close();
		return customer;
	}

}
