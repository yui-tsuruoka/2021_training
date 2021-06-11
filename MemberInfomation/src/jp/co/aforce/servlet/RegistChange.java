//p.240参考

package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.RegisterBean;
import jp.co.aforce.dao.RegisterDAO;
import jp.co.aforce.tool.InputCheck;
import jp.co.aforce.tool.Page;


//登録変更サーブレット
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/change"})
public class RegistChange extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {

		//beanにいれるためにパラメータ取得
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		int birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
		int birthDay = Integer.parseInt(request.getParameter("birthDay"));

		//未記入項目チェック
		InputCheck check = new InputCheck();
		boolean reco =check.requiredCheck(name);
		if(reco == false) {
			out.println("未記入の項目があります。");
			return;  //メソッドを終了させる。データの登録までいかない。
		}

		//beanインスタンス化、格納
		RegisterBean bean = new RegisterBean();
		bean.setName(name);
		bean.setAge(age);
		bean.setYear(birthYear);
		bean.setMonth(birthMonth);
		bean.setDay(birthDay);

		//daoをインスタンス化してupdate文使ってテーブルに追加
		RegisterDAO dao = new RegisterDAO();
		int line;
			try {
				line = dao.update(bean);

				if(line > 0) {
					out.println("登録に成功しました。");
				}else {
					out.println("登録に失敗したよ");
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				out.println("登録に失敗しました。");
//				e.printStackTrace(out);
			}

		}catch(Exception e) {
			request.getRequestDispatcher("../jsp/regist-error.jsp").include(request, response);
		}

		Page.footer(out);
	}
}

