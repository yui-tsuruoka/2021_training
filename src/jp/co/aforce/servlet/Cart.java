/*
 *
 *カートの中身を表示させるサーブレット
 * itemList.jsp
 * Cart.java
 *
 * CartBean
 *
 **/


package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.ItemBean;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/cart"})

public class Cart extends HttpServlet {

	//コンパイラの警告の抑制
	@SuppressWarnings("unchecked")
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		//セッションの取得
		HttpSession session = request.getSession();

		//カートに追加する商品のidを取得。(商品の追加ボタンを押したときにurlにパラメータをつけて送信。)
		int id = Integer.parseInt(request.getParameter("id"));

		//セッション属性からカートを取得(項目beanのリスト)
		//getAttributeはオブジェクト型なのでListにキャスト変換。
		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");

		//カートが未生成の場合はカート生成、セッション属性に設定。
		if(cart == null) {
			cart = new ArrayList<CartBean>();
			session.setAttribute("cart", cart);
		}


		//追加する商品がすでにカートにあるかどうかの確認。

		//すでにあった場合の処理。
		for (CartBean cartBean : cart) {

			//左辺はすでにあるカートの中身のidを指している。
			if(cartBean.getItemBean().getId() == id) {

				//個数のカウント
				cartBean.setCount(cartBean.getCount() + 1);

				session.setAttribute("cart", cart);
				request.getRequestDispatcher("../views/cart.jsp").forward(request, response);
				return;
			}


		}

		//追加する商品がカート内に存在しない場合の処理
		//ここの属性listは商品リストのこと。
		List<ItemBean> list = (List<ItemBean>)session.getAttribute("list");

		for (ItemBean itemBean : list) {

			//追加する商品のidとitemBeanの中身ローラーして一致する商品情報を抜き出す。
			if(itemBean.getId() == id) {
				CartBean cartBean = new CartBean();
				cartBean.setItemBean(itemBean);
				cartBean.setCount(1);
				cartBean.setSubtotal(Integer.valueOf(itemBean.getPrice()));
				cart.add(cartBean);
			}

			//個数と価格を取得して小計と合計を算出する。

		}

		session.setAttribute("cart", cart);
		request.getRequestDispatcher("../views/cart.jsp").forward(request, response);
		return;



	}

}
