<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>itemListDeleteConfirm</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>商品一覧削除確認</p>
		</div>
		<div>
			<h3>全ての商品を削除します。よろしいですか？</h3>
			<s:form type="button" action="ItemListDeleteCompleteAction">
				<s:submit value="OK"/>
			</s:form>
			<s:form type="button" action="ItemListAction">
				<s:submit value="キャンセル"/>
			</s:form>
		</div>
		<div id="footer"></div>	
	</div>
</body>
</html>