/*
 *
 * 商品削除サーブレット
 *
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
@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-delete"})
public class ItemDelete extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		String jsp = "../views/delete-result.jsp";

		HttpSession session = request.getSession();

		//confirmに突っ込んだセッションを取得
		ItemBean itemBean = (ItemBean)session.getAttribute("deleteConfirm");

		//daoをインスタンス化してdelete文使ってテーブルからデータ削除
		ItemDAO dao = new ItemDAO();

		//削除処理実行
		//deleteメソッドはboolean型にしているのでこの形で書ける。
		try {
			if(dao.delete(itemBean.getId())) {
				//ダイアログボックスで確認。または確認jspをインクルードして、最後に返す。
				itemBean.setMsg("削除に成功しました。");
			}else {
				itemBean.setMsg("削除に失敗しました。");
			}
		} catch (Exception e) {

			e.printStackTrace(out);
		}

		//最終的な変更をupdateに入れる。(結果のメッセージ出力のためにも。)
		session.setAttribute("delete", itemBean);
				//遷移先はメッセージを変えた同じｊｓｐ
		request.getRequestDispatcher(jsp).forward(request, response);

	}
}


