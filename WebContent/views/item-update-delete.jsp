<%--
	商品詳細表示
	変更・削除ボタン

	フォーム内に表示させる。

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
			<img src="../img/${itemDisplay.id}.jpg" alt="でてません">
			<input type="hidden" name="id" value="${itemDisplay.id}">
			<p>商品名：<input type="text" name="itemName" value="${itemDisplay.itemName}"></p>
			<p>値段：<input type="text" pattern="^[0-9]+$" name="price" value="${itemDisplay.price}">円</p>

			<input type="hidden" name="categoryName" value="${itemDisplay.categoryName}">
			<p>カテゴリー:
			<select name="category">
				<option value="${itemDisplay.categoryId}" selected>${itemDisplay.categoryName}</option>
				<option value="1">家具</option>
				<option value="2">インテリア</option>
				<option value="3">食器</option>
				<option value="4">文房具</option>
			</select>
			</p>

			<input type="button" name="back" onclick="location.href='../views/itemList-ad.jsp'" value="戻る">

			<input type="submit" name="update" value="変更" formaction="../jp.co.aforce.servlet/item-update-confirm" formmethod="post">

			<input type="submit" name="delete" value="削除" id="deletebtn" formaction="../jp.co.aforce.servlet/item-delete-confirm" formmethod="post">
		</div>

		</form>


	</div>








<%@ include file = "../footer.html" %>


