/*
 * 管理者ログインサーブレット
 * dao, beanはユーザを同じものを利用
 * login.jsp→Adlogin.java→Userbean→loginDAO→itemList-ad.jsp
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

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.LoginDAO;


@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/ad-login" })
public class AdLogin extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		//リクエストパラメータを受け取る
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//セッションの開始
		HttpSession session = request.getSession();


		//失敗の時はlogin.jspに戻るように設定。
		String jsp = "../views/login.jsp";

		//管理者情報のプロパティ
		UserBean ad = new UserBean();

		try {

			//ログイン判定
			LoginDAO dao = new LoginDAO();

			//LoginDAO.javaのgetAdMemberメソッドを使う。
			ad = dao.getAdMember(id, password);

			if (ad != null) {

				//成功の時は商品一覧サーブレットを通って、itemList-ad.jspに進む。
				jsp = "../jp.co.aforce.servlet/item-list-ad";
			} else {
				ad = new UserBean();
				ad.setMsg("IDまたはパスワードが違います");
				ad.setId(id);
				ad.setPassword(password);
			}

			//セッション属性にセット。
			session.setAttribute("ad", ad);
			request.getRequestDispatcher(jsp).forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}

}