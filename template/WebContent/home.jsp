<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<!-- 	文章の文字コード設定（文字化けを防ぐためのコード） -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!-- 	スタイルシートとスクリプト言語の指定 -->
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<!-- 	イメージツールバルを表示しない（headの中で表示する） -->
	<meta http-equiv="imagetoolbar" content="no"/>
<!-- 	html文章内を簡潔な概要にまとめて記述できる -->
	<meta name="description" content=""/>
<!-- 	html文章内容をキーワードで指定できる -->
	<meta name="keywords" content=""/>
	<title>Home画面</title>
	
	
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
		
		table{
		    text-align: center;
		    margin: 0 auto;
		    
		}
		
		/*----id layout-----*/
		#top{
		    width: 780px;
		    margin: 30px auto;
		    border: 1px solid #333;
		}
		
		#header{
		    width: 100%;
		    height: 80px;
		    background-color: black;
		}
		
		#main{
		    width: 100%;
		    height: 80px;
		    text-align: center;
		}
		
		#footer{
			position: absolute;
    		bottom: 0;
    		left: 0;
		    width: 100%;
		    height: 80px;
		    background-color: black;
		    clear: both;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div>
			<s:form action="HomeAction">
				<s:submit value="商品購入"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>