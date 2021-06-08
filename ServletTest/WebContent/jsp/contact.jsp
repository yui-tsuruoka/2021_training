<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせフォーム</title>
</head>
<form action="../servlet/contact" method="post">
<table>
	<tr>
		<th>お名前（必須）</th>
		<td><input type="text" name="user" required name="yourname"></td>
	</tr>
	<tr>
		<th>会社名</th>
		<td><input type="text" name="company"></td>
	</tr>
	<tr>
		<th>メールアドレス(必須)</th>
		<td><input type="email" required name="mail" pattern=".+@.+\..+"></td>
	</tr>
	<tr>
		<th>お問い合わせ内容(必須)</th>
		<td><textarea required name="content"></textarea></td>
	</tr>
	<tr>
		<th>メルマガ種類</th>
		<td><input type="checkbox" name="magazine" value="総合案内">総合案内
			<input type="checkbox" name="magazine" value="セミナー案内">セミナー案内
			<input type="checkbox" name="magazine" value="求人採用情報">求人採用情報
		</td>
	</tr>
	<tr>
		<th>資料請求希望</th>
		<td><input type="radio" name="want" value="Yes" checked>Yes
			<input type="radio" name="want" value="No">No
		</td>
	</tr>
</table>

<p><input type = "submit" value = "送信" id="button"></p>

</form>

</body>
</html>