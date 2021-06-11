
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
import jp.co.aforce.tool.Page;


/*削除の操作
 * 削除ボタンを押すと、会員番号が送られ、そのデータをdeleteするdb操作を実行する。
 *
*/
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/delete"})
public class RegistDelete extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {

		//beanにいれるためにパラメータ取得
		//request.getParameterは返り値がString型のため、parlseIntメソッドで型変換
		//getParameter("")の中はフォームのname属性。
		String memberNo = request.getParameter("memberNo");


		//beanインスタンス化、格納
		RegisterBean bean = new RegisterBean();
		bean.setId(memberNo);

		//daoをインスタンス化してdelete文使ってテーブルからデータ削除
		RegisterDAO dao = new RegisterDAO();
		int line;
			try {
				line = dao.delete(bean);  //returnで返したlineを同じ変数で使えるように入れなおした？

				if(line > 0) {
					out.println("削除に成功しました。");
				}else {
					out.println("削除に失敗しました。");  //会員番号を入力しないとここに飛ぶらしい。
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace(out);
			}

		}catch(Exception e) {
			request.getRequestDispatcher("../jsp/regist-error.jsp").include(request, response);
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

