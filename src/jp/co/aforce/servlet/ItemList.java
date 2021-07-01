/*
 *
 * 商品一覧を表示させるサーブレット
 * itemList.jsp
 * ItemList
 * ItemDAO
 * ItemBean
 *
 **/


package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-list"})
public class ItemList extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	)throws IOException, ServletException{
		this.doPost(request, response);
	}


	//public List<itemBean>
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		) throws ServletException, IOException {

		PrintWriter out = response.getWriter();


		//セッションの取得
		HttpSession session = request.getSession();

		//検索用のデータの取得
		String categoryId = request.getParameter("categoryId");
		String sort = request.getParameter("sort");

		//カテゴリー検索をしない場合は空文字列を入れて一覧表示にする。空白という文字列が入ってしまうのでこれはなし。
		//if (categoryId == null) categoryId ="";

		try {
			ItemDAO dao = new ItemDAO();
			List<ItemBean> list = null;
			list = dao.search(categoryId, sort);

			session.setAttribute("list", list);

			request.getRequestDispatcher("../views/itemList.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}


	}

}
