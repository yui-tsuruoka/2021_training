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
.center{
	width:300px;
	margin-right: auto;
	margin-left: auto;
}
p{
	text-align: center;
	font-weight: bold;
}
.box1{
  margin: 1em -1em;
  padding: 2em;
  border-radius: 10px;
  border: solid 2px black;
   text-align: center;

}

.box1 a{
  margin: 0;
  padding: 0;
  text-decoration: none;
  text-color:black;
}



</style>
<%--
 <link href="../css/style.css" media="all" rel="stylesheet" type="text/css">
反映されないのでheadに直接書いた。
 --%>
</head>
<body>

<div class="top"></div>

<div class="center">
<p>メニュー画面</p>
<div class="box1"><a href="regist.jsp">会員情報新規登録</a></div>
<div class="box1"><a href="regist-change.jsp">会員情報変更</a></div>
<div class="box1"><a href="regist-delete.jsp">会員情報削除</a></div>

</div>

</body>
</html>
