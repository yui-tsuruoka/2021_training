<%--
	変更確認ページ

 --%>



<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header.html" %>
<%@ include file = "menu-ad.jsp" %>

<div class="center">


	<p>管理者ID: ${ad.id}でログイン中</p>



	<%--変更の確認を表示	 --%>

		<form>
		<div class="flex_item">
			<p>${confirm.msg}</p>
			<input type="hidden" name="id" value="${confirm.id}">
			<p>商品名：${confirm.itemName}</p>
			<p>値段：${confirm.price}円</p>

			<input type="hidden" name="categoryId" value="${confirm.categoryId}">
			<p>カテゴリー:${confirm.categoryName} </p>

			<input type="button" name="back" onclick="location.href='../views/itemList-ad.jsp'" value="戻る">

			<input type="submit" name="update" value="確定" formaction="../jp.co.aforce.servlet/item-update" formmethod="post">

		</div>

		</form>





</div>







<%@ include file = "../footer.html" %>


