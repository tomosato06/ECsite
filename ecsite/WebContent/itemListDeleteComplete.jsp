<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>itemListDeleteComplete</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>商品一覧削除完了</p>
		</div>
		<p><s:property value="message"/></p>
		<div>
			<p><a href='<s:url action="AdminAction"/>'>管理者TOP画面へ戻る</a><p>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>