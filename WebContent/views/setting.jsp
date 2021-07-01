<%--
	宛先・支払い・住所の設定
	jsp→jspに渡すだけ。あんまり重要じゃない、けしてもいい。
 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file = "../header.html" %>

<%--余白 --%>
<div class="top"></div>

<div class="center">
	<form action="../views/confirm.jsp" method="post" id="form">
		<p>宛名<input type="text" name="name" required></p>
		<p>宛先<input type="text" name="address" required></p>
		<p>お支払い方法
			<select name="payment">
				<option value="カード払い">カード払い</option>
				<option value="コンビニ支払い">コンビニ支払い</option>
				<option value="paypay">paypay</option>
			</select></p>
	<input type="submit" name="confirm" value="次に進む">
 </form>


</div>







<%@ include file = "../footer.html" %>


