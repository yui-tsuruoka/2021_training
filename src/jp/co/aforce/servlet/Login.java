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


@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/login" })
public class Login extends HttpServlet {

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

		//会員情報のプロパティ
		UserBean user = new UserBean();

		try {

			//ログイン判定
			LoginDAO dao = new LoginDAO();
			user = dao.getMember(id, password);

			if (user != null) {

				//成功の時は商品一覧サーブレットを通ってitemList.jspに進む。
				jsp = "../jp.co.aforce.servlet/item-list";

			} else {
				//userBeanを生成しなおす。
				user = new UserBean();
				user.setMsg("IDまたはパスワードが違います");
				user.setId(id);
				user.setPassword(password);

			}

			//セッション属性にセット。
			session.setAttribute("user", user);
			request.getRequestDispatcher(jsp).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}

}