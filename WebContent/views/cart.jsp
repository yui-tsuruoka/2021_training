<%--
	カート内の表示
	個数選択や削除、値段の小計が表示される。
	テーブルで表示させる。
 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header.html" %>
<%@ include file = "menu.jsp" %>
<div class="center">

	<!-- カート内商品の有無を表示 -->
	<c:choose>
		<c:when test="${cart.size() > 0 }">
			<p>${cart.size() }種類の商品があります。</p>
			<hr>
		</c:when>
		<c:otherwise>
			<p>カートに商品がありません。</p>
		</c:otherwise>
	</c:choose>



	<%--カートの中身を表示させる --%>
	<%--セッション属性に保存したcartリスト --%>
	<form action="../jp.co.aforce.servlet/cart-update">
	    <table style="border-collapse:separate; border-spacing: 10px;">
		<c:forEach var="cart" items="${cart}">
			<tr>
			<td>商品${cart.itemBean.id}</td>
			<td><img src="../img/${cart.itemBean.id}.jpg" height="96"></td>
			<td>${cart.itemBean.itemName}</td>
			<td>${cart.itemBean.price}円</td>
			<td>
				<select name="count">
					<option value="${cart.count}">${cart.count}</option>
					<%
						for(int i=1; i <= 10; i++){
							out.println("<option value=\"" + i + "\">" + i + "</option>");
						}
					%>
				</select>個
			</td>
			<td>
				小計 ${cart.count * cart.itemBean.price} 円
			</td>
			<td><a href="../jp.co.aforce.servlet/cart-remove?id=${cart.itemBean.id}">カートから削除</a></td>

			</tr>
		</c:forEach>
		</table>
		<hr>
		 <table style="border-collapse:separate; border-spacing: 10px;">
		 </table>

		 <%

		 	if(request.getAttribute("cart-error-msg") != null){
		 		out.println("<p>カートに商品を入れてください。</p>");
		 	}

		 %>

		<a href="/ShoppingSite/jp.co.aforce.servlet/item-list">買い物を続ける</a>
		<input type="submit" name="complete" value="再計算">

		<!-- カートに商品が入っているかどうかの確認をするConfirm.javaへ -->
		<a href="../jp.co.aforce.servlet/confirm">購入手続きに進む</a>
	</form>


</div>







<%@ include file = "../footer.html" %>


