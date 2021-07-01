/*
 * 購入完了サーブレット
 * 購入を確定して購入情報をデータベースに保存する。
 *confirm.jsp
 *Purchase.java
 *PurchaseDAO.java
 *purchaseComplete.jsp
 * */

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

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.dao.PurchaseDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/purchase"})
public class Purchase extends HttpServlet {
	@SuppressWarnings("unchecked")

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {


		HttpSession session = request.getSession();
		String jsp = "../views/purchase-error-empty.jsp";
		PrintWriter out = response.getWriter();

		//リクエストパラメータの取得(宛名と宛先)
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String payment = request.getParameter("payment");

	/*  前画面で必須項目にしているのでnullにはならない。
		//宛名・宛先のどちらかがnullなら、入力エラーの出力
		//フォワードするんじゃなくてメッセージ出力にしたいなあ。EL法使えるかな？要検討。
		if(name.isEmpty() || address.isEmpty() || payment.isEmpty()) {
			request.getRequestDispatcher(jsp).forward(request, response);
		}
	 */
		//購入情報の登録。
		PurchaseDAO dao = new PurchaseDAO();
		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");

		//処理中にエラーが起きたとき
		try {
			if (cart == null || !dao.insert(cart, name, address, payment)) {
				jsp = "../views/purchase-error-insert.jsp";
				request.getRequestDispatcher(jsp).forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace(out);
		} catch (IOException e) {
			e.printStackTrace(out);
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		//カートのセッションを切る。
		session.removeAttribute("cart");

		//購入完了jspに送る
		jsp = "../views/purchaseComplete.jsp";
		//out.println("購入完了しました。");
		request.getRequestDispatcher(jsp).forward(request, response);

	}

}
