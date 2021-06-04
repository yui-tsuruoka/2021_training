package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servlet/contact"})
public class Contact extends HttpServlet{

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();


		//ここ全部jspに表示でいいかもしれない。
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String company = request.getParameter("company");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		String magazine = request.getParameter("magazine");
		String want = request.getParameter("want");


	/*	request.getParameter("user");
		request.getParameter("company");
		 request.getParameter("mail");
		 request.getParameter("content");
		 request.getParameter("magazine");
		 request.getParameter("want");

*/

		Page.header(out);




		if(want.equals("Yes")) {   //資料請求にYesが入っていたらwant.jspを表示させる。
			request.getRequestDispatcher("../jsp/want.jsp").include(request, response);
		}else {
			request.getRequestDispatcher("../jsp/result.jsp").include(request, response);
		}




			Page.footer(out);

	}


}
