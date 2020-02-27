<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー一覧</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ユーザー一覧</p>
		</div>
		<div>
		<s:if test="userInfoDTOList==null">
			<h3>ご購入情報はありません。</h3>
		</s:if>
		<s:elseif test="message==null">
			<h3>ご購入情報は以下になります。</h3>
			<table border="1">
					<tr>
						<th>ログインID</th>
						<th>ログインPASS</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>詳細</th>
					</tr>
					<s:iterator value="userInfoDTOList">
						<tr>
							<td><s:property value="loginId"/></td>
							<td><s:property value="loginPass"/></td>
							<td><s:property value="userName"/></td>
							<td><s:property value="insert_date"/></td>
							<td><s:property value="update_date"/></td>
							<td><a href='<s:url action="UserDetailsAction"/>'>
							<s:param name="id" value="%{id}"/>詳細</a></td>
						</tr>
					</s:iterator>
				</table>
				<tr>
					<td>
						<a href='<s:url action="UserListDeleteConfirmAction"/>'><s:submit value="削除" id="delete"/></a>
					</td>
				</tr>
			</s:elseif>
			<s:if test="message !=null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<div id="text-right">
				<p>管理者TOP画面は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
		</div>
		<div id="footer"></div>	
	</body>
</html>							