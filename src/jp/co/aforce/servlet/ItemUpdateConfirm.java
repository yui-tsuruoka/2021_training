/*
 * 商品情報の更新内容を確認するサーブレット
 *
 * item-update-delete.jsp→ItemUpdateConfirm→item-confirm.jsp→ItemUpdate
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

import jp.co.aforce.beans.ItemBean;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/item-update-confirm"})

public class ItemUpdateConfirm extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{

	//	PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();


		//確認フォームに飛ぶ
		String jsp = "../views/item-confirm.jsp";

		//フォームに入力された情報を取得しitemBeanに格納
		ItemBean itemBean = new ItemBean();
		itemBean.setItemName(request.getParameter("itemName"));
		itemBean.setPrice(request.getParameter("price"));
		itemBean.setId(Integer.parseInt(request.getParameter("id")));
		itemBean.setCategoryId(request.getParameter("category"));
		itemBean.setCategoryName(request.getParameter("categoryName"));
		itemBean.setMsg("以下の内容で変更してよろしいですか。");

		//sessionに入れて確認画面に投げる。
		session.setAttribute("confirm", itemBean);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}


	/*	//YESを押したらここに戻ってきて実行。無限ループじゃない？？

		//daoをインスタンス化してupdate文使ってテーブル内容をupdate
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

		session.setAttribute("update", itemBean);
		request.getRequestDispatcher(jsp).forward(request, response);

	}
}
*/

