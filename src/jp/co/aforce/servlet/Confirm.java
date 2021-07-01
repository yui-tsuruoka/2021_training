/*
 *
 * ログイン済みか、カートに商品が入っているか。の確認。
 * cart.jsp→Confirm.java→setting.jsp
 *
 * */

package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/confirm"})
public class Confirm extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException {

		HttpSession session = request.getSession();

		//未ログインの場合はログイン画面に返す。
		if(session.getAttribute("user") == null){
			//ログイン画面に返す。
			request.getRequestDispatcher("../views/login.jsp").forward(request, response);
		}

		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
		//カートが空の場合はエラーをカートページに表示させる。
		if(cart == null || cart.size() == 0) {
			request.setAttribute("cart-error-msg","商品を選択してから購入手続きに進んでください。");
			request.getRequestDispatcher("../views/cart.jsp").forward(request, response);
			return;
		}

		//問題無ければ住所設定のsetting.jspに飛ばす。
		request.getRequestDispatcher("../views/setting.jsp").forward(request, response);
		return;


	}

}
