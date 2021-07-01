/*
 * 商品の削除を確認するためのサーブレット
 *
 * item-update-delete.jsp→ItemDeleteConfirm→delete-confirm.jsp→ItemDelete
 *
 * */


package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-delete-confirm"})

public class ItemDeleteConfirm extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

	//	PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();



		//確認フォームに飛ぶ
		String jsp = "../views/delete-confirm.jsp";

		//フォームに入力された情報を取得しitemBeanに格納
		ItemBean itemBean = new ItemBean();
		itemBean.setItemName(request.getParameter("itemName"));
		itemBean.setPrice(request.getParameter("price"));
		itemBean.setId(Integer.parseInt(request.getParameter("id")));
		itemBean.setCategoryId(request.getParameter("category"));
		itemBean.setCategoryName(request.getParameter("categoryName"));
		itemBean.setMsg("以下の商品を削除してよろしいですか。");

		session.setAttribute("deleteConfirm", itemBean);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}



