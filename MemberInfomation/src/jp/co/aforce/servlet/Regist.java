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


//jspに追加で出力させるやり方にしたかったがうまくできなかったので取り合えずページの遷移。
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/regist"})
public class Regist extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {

		//beanにいれるためにパラメータ取得
		//request.getParameterは返り値がString型のため、parlseIntメソッドで型変換
		//getParameter("")の中はフォームのname属性。
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		int birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
		int birthDay = Integer.parseInt(request.getParameter("birthDay"));

		//未記入
		InputCheck check = new InputCheck();
		boolean req =check.requiredCheck(name);
		if(req == false) {
			out.println("入力されていない項目があります。");  //分かりやすさのため一時的な書き方。
//			request.getRequestDispatcher("../jsp/regist-error.jsp").forward(request, response);
			return;  //メソッドを終了させる。データの登録までいかない。
		}
/*		使わなかった。intに文字列を入れた時点でエラーキャッチしたので。*/
		boolean req2 =check.numberCheck(age);
		if(req2 == false) {
			out.println("年齢には数字をいれてください。");
			return;
		}

		//beanインスタンス化、格納
		RegisterBean bean = new RegisterBean();
		bean.setName(name);
		bean.setAge(age);
		bean.setYear(birthYear);
		bean.setMonth(birthMonth);
		bean.setDay(birthDay);

		//daoをインスタンス化してinsert文使ってテーブルに追加
		RegisterDAO dao = new RegisterDAO();
		int line;
			try {
				line = dao.insert(bean);

				if(line > 0) {
					out.println("登録に成功しました。");
				}else {
					out.println("登録に失敗しました。");
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				out.println("登録に失敗しました。");
//				e.printStackTrace(out);
			}

		}catch(Exception e) {
			out.println("入力されていない項目があります。");
		}

		Page.footer(out);
	}
}




/*		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		int birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
		int birthDay = Integer.parseInt(request.getParameter("birthDay"));
*/

		//未入力事項がないかチェック
/*
		InputCheck check = new InputCheck();
		check.requiredCheck(name);
		check.numberCheck(age);
		check.numberCheck(birthYear);
		check.numberCheck(birthMonth);
		check.numberCheck(birthDay);
*/
		//	try {



			/* get.Parameterの時点でnullの場合にcatchに飛んでいる。
			 * ここに、requiredcheckメソッドを使えれば必須項目のチェックができる
			 *
			 * 	out.println("入力されていない項目があります。"); or setAttribute()
			 * */





				//beans作成、格納
			/*	RegisterBean bean = new RegisterBean();
				bean.setName(name);
				bean.setAge(age);
				bean.setYear(birthYear);
				bean.setMonth(birthMonth);
				bean.setDay(birthDay);

				//daoをインスタンス化してinsert文使ってテーブルに追加
				RegisterDAO dao = new RegisterDAO();
				int line = dao.insert(bean);

				if(line > 0) {
					out.println("登録に成功しました。");
				}else {
					out.println("登録に失敗しました。");
				}
			//}else {
			//	out.println("入力されていない項目があります。");
		//	}
*/

