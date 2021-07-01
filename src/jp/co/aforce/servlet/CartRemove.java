/*
 *
 * 「カートから削除」アクション
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

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/cart-remove"})
public class CartRemove extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(
		HttpServletRequest request, HttpServletResponse respone
	)throws ServletException, IOException {

		HttpSession session = request.getSession();

		//URLにidを付与して送る。
		int id = Integer.parseInt(request.getParameter("id"));

		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");

		for (CartBean cartBean : cart) {
			if(cartBean.getItemBean().getId() == id) {
				cart.remove(cartBean);
				break;
			}
		}

		//cart.jspに返す。
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("../views/cart.jsp").forward(request, respone);


	}


}
