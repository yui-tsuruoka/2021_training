/*
 * 管理者ログアウトサーブレット
 *
 *
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

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/logout-ad"})
public class AdLogout extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse respone
	) throws ServletException, IOException {

		HttpSession session = request.getSession();
	//	String jsp = "../views/logout-error.jsp";



		//セッション属性userが存在しているということはログイン状態ということ。
		//セッションを切る。
		if (session.getAttribute("ad") != null) {
			session.removeAttribute("ad");
			request.getRequestDispatcher("../views/logout-out.jsp").forward(request, respone);
			return;

		}
		//セッション属性userが獲得できない=ログイン状態じゃない。のでエラーページ。
		request.getRequestDispatcher("../views/logout-error.jsp").forward(request, respone);
		return;


	}

}
