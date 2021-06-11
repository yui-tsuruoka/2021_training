
package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.RegisterBean;
import jp.co.aforce.dao.RegisterDAO;
import jp.co.aforce.tool.Page;

/*登録表示サーブレット（二回使う）
 * 表示ボタン実行時にユーザーが書いた会員番号を取得して、テーブルを検索する。
 * テーブルに存在したら、データをフォーム内に出力(JSPに書いた方がやりやすい？)
 * →jspファイルにforwardする。
 *
 * 存在しなかったら
 * →out.prinln("");
 */
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/view"})
public class RegistDisplay extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		Page.header(out);
		try {
			String id = request.getParameter("memberNo");
			//daoインスタンス化
			RegisterDAO dao = new RegisterDAO();
			List<RegisterBean> list = dao.search(id);
			 //beanへの格納まで終了している。
			//sqlを実行してlistにいれた。

			for(RegisterBean bean : list) {
				out.println(bean.getName());
				out.println(bean.getAge());
				out.println(bean.getYear());
				out.println(bean.getMonth());
				out.println(bean.getDay());

			}

			//request.setAttribute("members", list);  //membersという属性名にlistデータを設定する。p.251参考
			//request.getRequestDispatcher("../jsp/regist-display.jsp").forward(request, response);

		//	getServletContext().getRequestDispatcher("../jsp/regist-delete.jsp").forward(request, response);


		//	response.get
	/*		for (RegisterBean bean : list) {
				out.println(bean.getName());
				out.println(bean.getAge());
				out.println(bean.getYear());
				out.println(bean.getMonth());
				out.println(bean.getDay());
			}
*/
			//条件分岐の方法！！送信元に返したい。。。
/*			if() {
				request.getRequestDispatcher("regist-delete.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("regist-change.jsp").forward(request, response);
			}
*/
			//returnで元のjspに帰る？そしてデータもjspに渡せる？


		}catch(Exception e){
			e.printStackTrace(out);
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


