<%--
	ログイン画面


 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file = "../header-login.html" %>



<div class="top"></div>

<div class="center">
<form>
	<div class="box1">
		<p>ログイン</p>
		<p>${user.msg}</p>
		<p>${ad.msg}</p>
		<p><input type="text" name="id" value="${user.id}" placeholder="id" required ></p>
		<p><input type="password" name="password" value="${user.password}" placeholder="password" required></p>
		<p><input type="submit" name="login" value="Login" formaction="../jp.co.aforce.servlet/login" formmethod="post"></p>
	</div>

<p><input type="submit" name="ad-login" value="管理者ログイン" formaction="../jp.co.aforce.servlet/ad-login" formmethod="post"></p>
</form>

</div>

<%@ include file = "../footer.html" %>


