<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>admin画面</title>

			<style type="text/css">
	
			/*----tag layout-----*/
				body{
					margin:0;
					padding: 0;
				    line-height: 1.6;
				    letter-spacing: 1px;
				    font-family: Verdana,Helvetica,sans-serif;
				    font-size: 12px;
				    color: #333;
				    background: #fff;
				}
				
				.left{
					display:inline-block;
					border: 1px solid #333;
					width:500px;
					height:400px;
				}
				
				.right{
					display:inline-block;
					border: 1px solid #333;
					width:500px;
					height:400px;
				}
				
			/*----id layout-----*/
				#top{
				    width: 780px;
				    margin: 30px auto;
				    border: 1px solid #333;
				    text-align: center;
				}
				
				#header{
				    width: 100%;
				    height: 80px;
				    background-color: black;
				}
				
				#main{
				    width: 100%;
				    height: 500px;
				    text-align: center;
				}
				
				#box{
					margin-right : 35%;
					margin-top : 20px;
				}
				
				#footer{
					position: absolute;
		    		bottom: 0;
		    		left: 0;
				    width:100%;
				    height:80px;
				    background-color: black;
				    clear: both;
				}
		</style>
	</head>
	<body>
		<div id="header"></div>
		<div id="main">
			<div id="top"><p>管理者画面</p></div>
			<div class="left">
				<h2>商品</h2>
				<div id="link">
					<a href='<s:url action="ItemCreateAction"/>'><s:submit value="新規登録" id="box"/></a>
					<a href='<s:url action="ItemListAction"/>'><s:submit value="一覧" id="box"/></a>
				</div>
			</div>
			<div class="right">
				<h2>ユーザー</h2>
				<div id ="link">
					<a href='<s:url action="UserCreateAction"/>'><s:submit value="新規登録" id="box"/></a>
					<a href='<s:url action="UserListAction"/>'><s:submit value="一覧" id="box"/></a>
				</div>
			</div>
			<div id="text-right">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
			<div id="footer"></div>
		</div>
	</body>
</html>