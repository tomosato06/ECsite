<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品情報削除確認画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>商品情報削除確認</p>
		</div>
		<div>
			<h3>商品ID[<s:property value="id"/>]の商品を削除します。よろしいですか？</h3>
			<s:form type="button" action="ItemDeleteCompleteAction">
				<s:submit value="OK"/>
				<s:hidden name="id" value="%{id}"/>
			</s:form>
			<s:form type="button" action="ItemDetailsAction">
				<s:submit value="キャンセル"/>
			</s:form>
		</div>
		<div id="footer"></div>	
	</div>

</body>
</html>