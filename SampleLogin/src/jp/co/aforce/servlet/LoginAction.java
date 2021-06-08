package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;




public class LoginAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	)throws Exception {
		response.setContentType("text/html charset=utf-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String cus_name = request.getParameter("cus_name");
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.search(id, password);

		if (customer != null) {
			session.setAttribute("customer", customer);

			return "login-out.jsp";
		}

		//ログイン失敗時の処理

		session.setAttribute("id", id);
		return "login.jsp";

	/*	response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("../jsp/login-error.jsp").include(request, response);
	*/

	}


}
