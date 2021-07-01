/*
 *
 * 商品追加サーブレット
 *
 * */


package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-regist"})

public class ItemRegist extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		//遷移画面
		String jsp = "../views/regist-result.jsp";

		//フォームに入力された情報を取得しitemBeanに格納
		ItemBean itemBean = new ItemBean();
		itemBean.setItemName(request.getParameter("itemName"));
		itemBean.setPrice(request.getParameter("price"));
		itemBean.setCategoryId(request.getParameter("categoryId"));

		//daoをインスタンス化
		ItemDAO dao = new ItemDAO();

		//SQL実行
		//insertメソッドはboolean型にしているのでこの形で書ける。
		try {

			if(dao.inputCheck(itemBean)) {

				if(dao.insert(itemBean)) {
					//ダイアログボックスで確認。または確認jspをインクルードして、最後に返す。
					itemBean.setMsg("登録に成功しました。");
				}else {
					itemBean.setMsg("登録に失敗しました。");
				}

				//入力エラーがある場合
			} else {

				//idが取得できなくて困るので処理の始めに戻る(商品一覧)
				itemBean.setMsg("入力されていない項目があります。");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
			itemBean.setMsg("登録に失敗しました。");
		}

		session.setAttribute("regist", itemBean);

		//結果表示画面に遷移。
		request.getRequestDispatcher(jsp).forward(request, response);

	}
}




