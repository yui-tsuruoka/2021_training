<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.html" %>

<%
String id = request.getParameter("id");
String message = "IDもしくはパスワードが違います。";
if (id == null) {
	id = "";
	message = "";
}
%>

<form action="../Login.action" method="post">
<p>ID:<input type="text" name="id" value="<%=id %>"></p>
<p>password:<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
<p><%= message  %>
</form>

<%@ include file = "../footer.html" %>