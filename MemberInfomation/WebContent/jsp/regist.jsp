<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENU画面</title>
<style type="text/css">
.top{
	margin:100px;
}
.box2{
	width:300px;
	margin-right: auto;
	margin-left: auto;
}
p{
	text-align: center;
}
</style>
</head>
<body>
<div class="top"></div>
<div class="box2">
<form action="../jp.co.aforce.servlet/regist" method="post">
<p>会員情報新規登録画面</p>
<table>
	<tr>
		<th>名前</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>年齢</th>
		<td><input type="text" name="age"></td>
	</tr>
	<tr>
		<th>生年月日</th>
		<td>
		<select name = "birthYear">
			<option value="" selected> </option>  <%--初期設定は空欄 --%>
			<%
			for(int i=1920; i <= 2020; i++){
				out.println("<option value=\"" + i + "\">" + i + "</option>");
			}
			%>
		</select>年
		<select name = "birthMonth">
			<option value="" selected> </option>
			<%
			for(int i=1; i <= 12; i++){
				out.println("<option value=\"" + i + "\">" + i + "</option>");
			}
			%>

		</select>月
		<select name = "birthDay">
			<option value="" selected> </option>
			<%
			for(int i=1; i <= 31; i++){
				out.println("<option value=\"" + i + "\">" + i + "</option>");
			}
			%>
		</select>日

		</td>
	</tr>
</table>
<input type="button" name="back" onclick="location.href='menu.jsp'" value="戻る">
<input type="submit" name="regist" value="登録">
</form>
</div>
</body>

</html>

