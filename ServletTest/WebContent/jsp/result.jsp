<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容</title>
</head>
<body>
	<p>以下の内容で送信しました。</p>
	<p>お名前：<%= request.getParameter("user") %></p>
	<p>会社名：<%= request.getParameter("company")%></p>
	<p>メールアドレス：<%= request.getParameter("mail")%></p>
	<p>お問い合わせ内容</p>
	<p><%= request.getParameter("content")%></p>
	<p>メルマガ種類：<%= request.getParameter("magazine")%></p>
	<p>資料請求希望<%= request.getParameter("want")%></p>
</body>
</html>


