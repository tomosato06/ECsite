package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {
	
	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{
		
		//DBにインスタンス化とDB接続
		DBConnector db =new DBConnector();
		Connection con =db.getConnection();
		DateUtil dateUtil=new DateUtil();
		
		String sql="insert into login_user_transaction(login_id,login_pass,user_name,insert_date)values(?,?,?,?)";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたloginuserIdそれぞれに入る
			ps.setString(1,loginUserId);
			ps.setString(2,loginUserPassword);
			ps.setString(3,userName);
			ps.setString(4,dateUtil.getDate());
			
			//検索を実行するのでexecuteです
			ps.execute();
			
		//eには例外の情報が入っている(eは変数なのでなんでもいい)
		}catch(Exception e){//SQLの実行で問題があった場合に投げられます。
			
			//StackTrace(通過したメソッドのリスト)
			//(各メソッドのファイルとメソッド呼び出し箇所、例外発生個所の行番号)
			e.printStackTrace();
		}finally{ //finallyは最後に実行されるものを指定するための構文
			//DB切断
			con.close();
		}
				
	}

}
