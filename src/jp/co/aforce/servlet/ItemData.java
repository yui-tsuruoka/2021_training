/*
 * 変更・削除画面での商品詳細表示サーブレット
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

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-data"})
public class ItemData extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		//商品idの取得
		int id = Integer.parseInt(request.getParameter("id"));

		//商品情報のインスタンス化
		ItemBean itemBean = new ItemBean();

		//SQLのメソッドが入ったdaoのインスタンス化
		ItemDAO dao = new ItemDAO();

		try {
			itemBean = dao.display(id);
		} catch (Exception e) {
			e.printStackTrace(out);
		}


		if (itemBean == null) {
			itemBean = new ItemBean();
			itemBean.setMsg("該当する商品がありません。");
		}

		request.setAttribute("itemDisplay", itemBean);
		request.getRequestDispatcher("../views/item-update-delete.jsp").forward(request, response);

	}

}
