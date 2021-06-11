//p.235 ProductDAO参照
package jp.co.aforce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.RegisterBean;

//memberテーブルを操作するDAOクラス

public class RegisterDAO extends DAO{

	//insert（新規登録）
	public int insert(RegisterBean register) throws Exception{  //なぜint型？(insertメソッドの戻り値が変更した行数だから？)
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"insert into members values(CONCAT('A', cast(now() as signed)), ?, ?, ?, ?,?)");
			//concat(a,b)で結合、cast(now() as signed)で日付取得と(castで)数列化
		st.setString(1, register.getName());
		st.setInt(2, register.getAge());
		st.setInt(3, register.getYear());
		st.setInt(4, register.getMonth());
		st.setInt(5, register.getDay());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	//delete（登録削除）
	//delete from members where member_no = ?;
	public int delete(RegisterBean register)throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"delete from members where member_no = ?");
		st.setString(1, register.getId());  //入力された会員番号を取得し代入
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	//Update文（登録変更）
	public int update(RegisterBean register) throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
			"update members set name=?, age=?, birth_year=?, birth_month=?, birth_day=? whrere member_no=?");
		st.setString(1, register.getName());
		st.setInt(2, register.getAge());
		st.setInt(3, register.getYear());
		st.setInt(4, register.getMonth());
		st.setInt(5, register.getDay());
		st.setString(6, register.getId());
		int line = st.executeUpdate();  //sql実行

		st.close();
		con.close();
		return line;


	}




	//search（表示）
	public List<RegisterBean> search(String id) throws Exception{
		List<RegisterBean> list = new ArrayList<>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
			"select * from members where member_no = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			//beanの呼び出し格納（daoの時点でbeanまで終わってる）
			RegisterBean bean = new RegisterBean();
			bean.setId("member_no");
			bean.setName(rs.getString("name"));
			bean.setAge(rs.getInt("age"));
			bean.setYear(rs.getInt("birth_year"));
			bean.setMonth(rs.getInt("birth_month"));
			bean.setDay(rs.getInt("birth_day"));
			list.add(bean);
		}



		st.close();
		con.close();

		return list;
	}



	//update文（教科書にはないのでメソッドなどなどネットでみなきゃかな。）
}
