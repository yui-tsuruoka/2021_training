<%--
	商品一覧、ソート表示
 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header.html" %>
<%@include file = "menu.jsp" %>
<div class="top"></div>

<div class="center">

	<p>${user.name}さん、ようこそ！</p>


	<%--検索バー --%>
	<form>
		<!-- <a href="../jp.co.aforce.servlet/item-list">全表示</a> -->
		<a>カテゴリー</a>
		<select name="categoryId">
			<option value="">全て</option>
			<option value="1">家具</option>
			<option value="2">インテリア</option>
			<option value="3">食器</option>
			<option value="4">文房具</option>

		</select>
		<select name="sort">
			<option value="" selected></option>
			<option value="itemName">名前順</option>
			<option value="price">価格順</option>
		</select>
		<input type="submit" name="ad-login" value="検索" formaction="../jp.co.aforce.servlet/item-list" formmethod="post">
	</form>

	<%--ここに結果を表示
	デフォは商品テーブルをすべてここに表示
	検索後はselect * from 商品テーブル where categoryid="" order by name , order by price
	 --%>

	<div class="flex_box">

		<%--商品番号で拡張for文 --%>
		<c:forEach var="item" items="${list}">
		<div class="flex_item">
			<img src="../img/${item.id}.jpg" alt="でてません">
			<p>${item.itemName} ${item.price}円</p>
			<p><a href="../jp.co.aforce.servlet/cart?id=${item.id}">カートに追加</a>
			</div>
		</c:forEach>




	</div>



</div>






<%@ include file = "../footer.html" %>


