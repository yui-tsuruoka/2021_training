<%--
	削除処理をしたときの遷移画面。
 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file = "../header.html" %>

<%--余白 --%>
<div class="top"></div>

<div class="center">
	<p>${delete.msg}</p>


	<input type="button" name="back" onclick="location.href='../jp.co.aforce.servlet/item-list-ad'" value="戻る">

</div>







<%@ include file = "../footer.html" %>


