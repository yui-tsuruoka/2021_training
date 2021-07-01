<%--
	注文内容確認ページ
	注文の詳細とお届け先などの最終確認
 --%>



<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header.html" %>
<%@ include file = "menu.jsp" %>

<div class="center">


	<hr>


	<%--カートのリストを表示させる --%>
	<table style="border-collapse:separate; border-spacing: 10px;">
	<c:forEach var="cart" items="${cart}">
		<tr>
		<td>商品${cart.itemBean.id}</td>
		<td><img src="../img/${cart.itemBean.id}.jpg" height="96"></td>
		<td>${cart.itemBean.itemName}</td>
		<td>${cart.itemBean.price}円</td>
		<td>${cart.count}個</td>
		<td class="total-price">小計 ${cart.count * cart.itemBean.price} 円</td>
		</tr>
	</c:forEach>
	</table>
	<hr>

	<%--setting.jspの値を持ってくる。 --%>
     <%--合計と支払い、住所の記載  jsp→jsp値の受け渡し--%>
     <%--フォームの形にして、入力不可のものにしておけばもう一回リクエスト属性でおくれるのでは？？ --%>

     <%
     request.setCharacterEncoding("utf-8");
     String name = request.getParameter("name");
     String address = request.getParameter("address");
     String payment = request.getParameter("payment");

     %>


     <form action="../jp.co.aforce.servlet/purchase">
     <p>宛名：<input type="text" name="name" readonly value="<%= name %>"></p>
     <p>宛先：<input type="text" name="address" readonly value="<%= address %>"></p>
     <p>お支払い方法：<input type="text" name="payment" readonly value="<%= payment %>"></p>


     <p>以上の内容で注文してよろしいですか。</p>


	<input type="button" name="back" onclick="location.href='cart.jsp'" value="変更">
	<input type="submit" name="complete" value="注文を確定する">


 </form>



</div>







<%@ include file = "../footer.html" %>


