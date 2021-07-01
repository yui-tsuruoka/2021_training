/*
 *
 * 個数を変更し再計算したときのアクションサーブレット
 * selectのname="count"を取得し、カートリストのカウント数に変更を加える。
 * cart.jspに返す。
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


@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/cart-update"})
public class CartUpdate extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");

/*		//一度空にしてカートに入れなおす。カウントはパラメータから取る。
		cart.removeAll(cart);

		List<ItemBean> list = (List<ItemBean>)session.getAttribute("list");

		for (CartBean cartBean : cart) {
			for (ItemBean itemBean : list) {

				//追加する商品のidとitemBeanの中身ローラーして一致する商品情報を抜き出す。
				//パラメータのnameは商品ごとに違うので一回ずつ取得。
				CartBean cartBean = new CartBean();

				if(itemBean.getId() == cartBean.getItemBean.getId()) {

					int count = Integer.parseInt(request.getParameter("count${cart.itemBean.id}"));
					cartBean.setItemBean(itemBean);
					cartBean.setCount(1);
					cart.add(cartBean);
				}

			}	//個数と価格を取得して小計と合計を算出する。

		}

*/


		//カートをローラーしてカートリストの個数を更新する。
		//変更自体はできた。ひとつめの商品のセレクトを変更したときだけ、その値が全部に反映される。インスタンス化してないから？
		for (CartBean cartBean : cart) {

			//この値の取り方だと、一つ目のしか取れない。。
			int count = Integer.parseInt(request.getParameter("count"));
			cartBean.setCount(count);
			}

		session.setAttribute("cart", cart);
		request.getRequestDispatcher("../views/cart.jsp").forward(request, response);
		return;

	}

}
