/*
 * 商品情報を更新するサーブレット
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

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-update"})

public class ItemUpdate extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		//confirmに突っ込んだセッションを取得
		ItemBean itemBean = (ItemBean)session.getAttribute("confirm");

		//成功したときの画面
		String jsp = "../views/update-result.jsp";

		//daoをインスタンス化してdelete文使ってテーブルからデータ削除
		ItemDAO dao = new ItemDAO();

		//SQL実行
		//updateメソッドはboolean型にしているのでこの形で書ける。
		try {

			if(dao.inputCheck(itemBean)) {
				if(dao.update(itemBean)) {
					//ダイアログボックスで確認。または確認jspをインクルードして、最後に返す。
					itemBean.setMsg("変更に成功しました。");
				}else {
					itemBean.setMsg("変更に失敗しました。");
				}

				//入力エラーがある場合
			} else {

				//遷移先を元のjspにする。
				itemBean.setMsg("入力されていない項目があります。");
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		//最終的な変更をupdateに入れる。(結果のメッセージ出力のためにも。)
		session.setAttribute("update", itemBean);
		request.getRequestDispatcher(jsp).forward(request, response);

	}
}


