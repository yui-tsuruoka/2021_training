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
a{
	font-weight: bold;

}
</style>
</head>
<body>
<div class="top"></div>
<div class="box2">
<form>
<p>会員情報削除画面</p>
<a>会員番号</a>
<input type="text" name="memberNo" value="">
<input type="submit" name="view" value="表示" formaction="../jp.co.aforce.servlet/view" formmethod="post">

<table>
	<tr>
		<th>名前</th>
		<td><input type="text" name="name" value="<% %>" disabled></td>
	</tr>
	<tr>
		<th>年齢</th>
		<td><input type="text" name="age" value="<% %>" disabled></td>
	</tr>
	<tr>
		<th>生年月日</th>
		<td>
		<select name = "birthYear">
			<option value="<%%>" disabled></option>
		</select>年
		<select name = "birthMonth">
			<option value="<%%>" disabled> </option>
		</select>月
		<select name = "birthDay">
			<option value="<%%>" disabled></option>
		</select>日

		</td>
	</tr>
</table>

<input type="button" name="back" onclick="location.href='menu.jsp'" value="戻る">
<input type="submit" name="delete" value="削除" formaction="../jp.co.aforce.servlet/delete" formmethod="post">




</form>
</div>

</body>
</html>
