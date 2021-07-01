/*
 * 商品に関するDAO
 * ・商品一覧、検索 search
 * ・商品情報表示 display
 * ・商品情報削除 delete
 * ・商品情報更新 update
 * ・商品追加 insert
 *
 * itemList.jsp
 * ItemSearch.java
 *
 *
 *
 * */

package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;

public class ItemDAO extends DAO {


	//必須項目チェック(変更処理時使用)
	public boolean inputCheck(ItemBean itemBean) {
		//valueOfメソッド。型変換に使われる。数値を文字列に変換するときはStringクラス、逆の時はIntegerクラスを使う。
		if(itemBean.getItemName().isEmpty() || itemBean.getPrice().isEmpty()) {

			return false;
		}
		return true;
	}



	//商品一覧・検索表示 searchメソッド
//	public List<ItemBean> search (String categoryId, int price) throws Exception {

	public List<ItemBean> search (String categoryId, String sort) throws Exception {

		List<ItemBean> list = new ArrayList<>();

		//実行結果を格納する変数
		ResultSet rs = null;

		Connection con = getConnection();

		//sql文の選択
		String sql = null;
		if(categoryId == "") {
			categoryId = null;
		}
		if(sort == "") {
			sort = null;
		}

		//ソート機能
		//カテゴリーが選択されているとき。
		if(categoryId != null) {
			if(sort != null) {
				if(sort.equals("price")) {
					sql ="SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId WHERE m_item.categoryId =? order by price desc";
				}else if(sort.equals("itemName")) {
					sql ="SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId WHERE m_item.categoryId = ? order by itemName asc";
				}
			}else {
				sql = "SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId WHERE m_item.categoryId = ?";
			}
		//全表示のソート機能。
		}else {
			if(sort != null) {
				if(sort.equals("price")) {
					sql ="SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId order by price desc";
				}else if(sort.equals("itemName")) {
					sql ="SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId order by itemName asc";
				}
			}else {
				sql = "SELECT * FROM m_item left outer join category on m_item.categoryId = category.categoryId";
			}

		}

		PreparedStatement st = con.prepareStatement(sql);

		//条件検索の場合パラメータにデータを設置
		if(categoryId != null) {

			st.setString(1, categoryId);
		}

		rs = st.executeQuery();

		while(rs.next()) {
			ItemBean itemBean = new ItemBean();
			itemBean.setId(rs.getInt("id"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setPrice(rs.getString("price"));
			itemBean.setCategoryId(rs.getString("categoryId"));
			itemBean.setCategoryName(rs.getString("categoryName"));
			list.add(itemBean);

		}

		st.close();
		con.close();

		return list;

	}

	//商品詳細表示 displayメソッド
	public ItemBean display(int id) throws Exception {

		//実行結果を格納する変数
		ResultSet rs = null;
		ItemBean itemBean = new ItemBean();
		Connection con = getConnection();

		//sql文
//		String sql = "SELECT * FROM m_item WHERE id = ?";
		String sql = "select * from m_item left outer join category on m_item.categoryId = category.categoryId where id = ?";


		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		//SQLの実行
		rs = st.executeQuery();

		if(rs.next()) {
			itemBean.setId(rs.getInt("id"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setPrice(rs.getString("price"));
			itemBean.setCategoryId(rs.getString("categoryId"));
			itemBean.setCategoryName(rs.getString("categoryName"));
		} else {
			itemBean = null;
		}
		st.close();
		con.close();
		return itemBean;
	}


	//商品情報削除 deleteメソッド //dao実行時の例外処理は呼び出し元で処理する。
	public boolean delete(int id) throws Exception{

		boolean result = false;
		Connection con = getConnection();
		String sql = "DELETE FROM m_item WHERE id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		int line = st.executeUpdate();

		if(line > 0) {
			result = true;
		}

		st.close();
		con.close();

		return result;
	}

	//商品情報変更 updateメソッド
	public boolean update(ItemBean itemBean) throws Exception {

		boolean result = false;
		Connection con = getConnection();
		String sql = "UPDATE m_item SET itemName = ?, price = ?, categoryId = ? WHERE id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, itemBean.getItemName());
		st.setInt(2, Integer.parseInt(itemBean.getPrice()));
		st.setString(3, itemBean.getCategoryId());
		st.setInt(4, itemBean.getId());

		int line = st.executeUpdate();

		if (line > 0) {
			result = true;
		}

		st.close();
		con.close();

		return result;
	}

	//商品追加 insertメソッド
	public boolean insert(ItemBean itemBean) throws Exception {

		boolean result = false;
		Connection con = getConnection();
		String sql = "INSERT INTO m_item VALUES (?, ?, ?, ?)";

		//idの生成。idはintがいい！
		LocalDateTime date = LocalDateTime.now();
		 //Stringになってしまう。intにキャスト変換！文字数おーばーしてるけど大丈夫そ？定義変更必要？
		//またはパターンの秒数消す？一分以内に2回商品追加できなくなるなぁ。定義変更の方がいいかも。
		//定義変更は手間がかかるので、今回は年数を消して対処。
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMddHHmmss");
		int id = Integer.parseInt(format.format(date));

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.setString(2, itemBean.getItemName());
		st.setInt(3, Integer.parseInt(itemBean.getPrice()));
		st.setString(4, itemBean.getCategoryId());

		int line = st.executeUpdate();

		if (line > 0) {
			result = true;
		}

		st.close();
		con.close();

		return result;

	}




}