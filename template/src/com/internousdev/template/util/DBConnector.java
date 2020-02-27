package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/ecsite";

	//アカウント、パスワード指定
	private static String user ="root";
	private static String password="";
	
	
	public Connection getConnection(){ //接続する状態
	Connection con =null;  //初期化　この二つは接続しない（公式として覚えておく）
	
	//例外処理
	try{
	//ドライバーがロードされ使えるような状態にする
	Class.forName(driverName);
	con =DriverManager.getConnection(url,user,password);
	}catch(ClassNotFoundException e){
	
	e.printStackTrace();
	}catch(SQLException e){
	
	e.printStackTrace();//エラーに至る履歴を表示してくれる
	}
	return con;
	
	}
}
