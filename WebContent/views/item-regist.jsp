<%--

	商品追加の入力ページ

	フォームに入れた値をItemRegist.javaに送る。

 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header-ad.html" %>
<%@include file = "menu-ad.jsp" %>
<div class="top"></div>

<div class="center">

	<p>管理者ID: ${ad.id}でログイン中</p>



	<%--商品詳細を表示	 --%>

		<form>
		<div class="flex_item">
			<p>商品名：<input type="text" name="itemName"></p>
			<p>値段：<input type="text" pattern="^[0-9]+$" name="price"></p>

			<p>カテゴリー:
			<select name="categoryId">
				<option value="" selected></option>
				<option value="1">家具</option>
				<option value="2">インテリア</option>
				<option value="3">食器</option>
				<option value="4">文房具</option>
			</select>
			</p>

			<input type="button" name="back" onclick="location.href='../views/itemList-ad.jsp'" value="戻る">

			<input type="submit" name="regist" value="追加" formaction="../jp.co.aforce.servlet/item-regist" formmethod="post">

		</div>

		</form>


	</div>









<%@ include file = "../footer.html" %>


